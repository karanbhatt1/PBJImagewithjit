package com.example.parser;

import com.example.imagecore.ImageUtils;
import com.example.parser.ImagescriptBaseListener;
import com.example.parser.ImagescriptParser;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageProcessingScriptListener extends ImagescriptBaseListener {
    private Map<String, BufferedImage> imageVariables = new HashMap<>();
    private final String outputDir = "script_output_images";

    public ImageProcessingScriptListener() {
        new File(outputDir).mkdirs();
    }

    @Override
    public void enterLoadCmd(ImagescriptParser.LoadCmdContext ctx) {
        String filePath = stripQuotes(ctx.filePath.getText());
        String varName = ctx.varName.getText();
        try {
            BufferedImage image = ImageUtils.loadImage(filePath);
            if (image != null) {
                imageVariables.put(varName, image);
            }
        } catch (Exception ignored) {}
    }

    @Override
    public void enterResizeCmd(ImagescriptParser.ResizeCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String outputVar = ctx.outputVar.getText();
        int width = (int) Double.parseDouble(ctx.width.getText());
        int height = (int) Double.parseDouble(ctx.height.getText());
        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage resizedImage = ImageUtils.resizeImage(inputImage, width, height);
                imageVariables.put(outputVar, resizedImage);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void enterGrayscaleCmd(ImagescriptParser.GrayscaleCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String outputVar = ctx.outputVar.getText();
        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage grayImage = ImageUtils.convertToGrayscale(inputImage);
                imageVariables.put(outputVar, grayImage);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void enterRotateCmd(ImagescriptParser.RotateCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String outputVar = ctx.outputVar.getText();
        int angle = (int) Double.parseDouble(ctx.angle.getText());
        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage rotatedImage = ImageUtils.rotateImage(inputImage, angle);
                imageVariables.put(outputVar, rotatedImage);
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void enterFlipCmd(ImagescriptParser.FlipCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String outputVar = ctx.outputVar.getText();
        String direction = ctx.direction().getText();
        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage flippedImage = switch (direction) {
                    case "HORIZONTAL" -> ImageUtils.flipImage(inputImage, true, false);
                    case "VERTICAL" -> ImageUtils.flipImage(inputImage, false, true);
                    case "BOTH" -> ImageUtils.flipImage(inputImage, true, true);
                    default -> null;
                };
                if (flippedImage != null) {
                    imageVariables.put(outputVar, flippedImage);
                }
            } catch (Exception ignored) {}
        }
    }

    @Override
    public void enterSaveCmd(ImagescriptParser.SaveCmdContext ctx) {
        String varName = ctx.varName.getText();
        String filePath = stripQuotes(ctx.filePath.getText());
        String format = stripQuotes(ctx.formatName.getText());
        BufferedImage imageToSave = imageVariables.get(varName);
        if (imageToSave != null) {
            try {
                String finalPath;
                File outputFile = new File(filePath);
                if (!outputFile.isAbsolute()) {
                    finalPath = new File(outputDir, filePath).getAbsolutePath();
                } else {
                    finalPath = filePath;
                }
                ImageUtils.saveImage(imageToSave, finalPath, format);
            } catch (Exception ignored) {}
        }
    }

    private String stripQuotes(String text) {
        if (text != null && text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1).replace("\"\"", "\"");
        }
        return text;
    }
}
