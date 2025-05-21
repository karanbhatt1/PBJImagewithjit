package com.example.parser;

import com.example.parser.ImageScriptBaseListener;
import com.example.parser.ImageScriptParser;

import com.example.imagecore.ImageUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageProcessingScriptListener extends ImageScriptBaseListener {

    private Map<String, BufferedImage> imageVariables = new HashMap<>();
    private String outputDir = "script_output_images";

    public ImageProcessingScriptListener() {
        new File(outputDir).mkdirs();
    }

    @Override
    public void enterLoadCmd(ImageScriptParser.LoadCmdContext ctx) {
        String filePath = stripQuotes(ctx.STRING_LITERAL().getText());
        String varName = ctx.VAR_NAME().getText();
        System.out.println("Executing: LOAD \"" + filePath + "\" AS " + varName);
        try {
            BufferedImage image = ImageUtils.loadImage(filePath);
            if (image != null) {
                imageVariables.put(varName, image);
                System.out.println("-> Loaded image into variable: " + varName);
            } else {
                System.err.println("-> Error loading image from: " + filePath);
            }
        } catch (Exception e) {
            System.err.println("-> Error loading image " + filePath + ": " + e.getMessage());
        }
    }

    @Override
    public void enterResizeCmd(ImageScriptParser.ResizeCmdContext ctx) {
        String inputVar = ctx.VAR_NAME(0).getText();
        String outputVar = ctx.VAR_NAME(1).getText();
        int width = Integer.parseInt(ctx.INT(0).getText());
        int height = Integer.parseInt(ctx.INT(1).getText());

        System.out.println("Executing: RESIZE " + inputVar + " WIDTH " + width + " HEIGHT " + height + " AS " + outputVar);

        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage resizedImage = ImageUtils.resizeImage(inputImage, width, height);
                imageVariables.put(outputVar, resizedImage);
                System.out.println("-> Resized image from " + inputVar + " to " + outputVar);
            } catch (Exception e) {
                System.err.println("-> Error resizing image " + inputVar + ": " + e.getMessage());
            }
        } else {
            System.err.println("-> Error: Input variable " + inputVar + " not found for RESIZE command.");
        }
    }

    @Override
    public void enterGrayscaleCmd(ImageScriptParser.GrayscaleCmdContext ctx) {
        String inputVar = ctx.VAR_NAME(0).getText();
        String outputVar = ctx.VAR_NAME(1).getText();

        System.out.println("Executing: GRAYSCALE " + inputVar + " AS " + outputVar);

        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage grayImage = ImageUtils.grayscaleImage(inputImage);
                imageVariables.put(outputVar, grayImage);
                System.out.println("-> Applied grayscale to " + inputVar + " to " + outputVar);
            } catch (Exception e) {
                System.err.println("-> Error applying grayscale to " + inputVar + ": " + e.getMessage());
            }
        } else {
            System.err.println("-> Error: Input variable " + inputVar + " not found for GRAYSCALE command.");
        }
    }

    @Override
    public void enterRotateCmd(ImageScriptParser.RotateCmdContext ctx) {
        String inputVar = ctx.VAR_NAME(0).getText();
        String outputVar = ctx.VAR_NAME(1).getText();
        int angle = Integer.parseInt(ctx.INT().getText());

        System.out.println("Executing: ROTATE " + inputVar + " ANGLE " + angle + " AS " + outputVar);

        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage rotatedImage = ImageUtils.rotateImage(inputImage, angle);
                imageVariables.put(outputVar, rotatedImage);
                System.out.println("-> Rotated image from " + inputVar + " by " + angle + " degrees to " + outputVar);
            } catch (Exception e) {
                System.err.println("-> Error rotating image " + inputVar + ": " + e.getMessage());
            }
        } else {
            System.err.println("-> Error: Input variable " + inputVar + " not found for ROTATE command.");
        }
    }

    @Override
    public void enterFlipCmd(ImageScriptParser.FlipCmdContext ctx) {
        String inputVar = ctx.VAR_NAME(0).getText();
        String outputVar = ctx.VAR_NAME(1).getText();
        String flipType = ctx.FLIP_TYPE().getText();

        System.out.println("Executing: FLIP " + inputVar + " " + flipType + " AS " + outputVar);

        BufferedImage inputImage = imageVariables.get(inputVar);
        if (inputImage != null) {
            try {
                BufferedImage flippedImage = null;
                switch (flipType) {
                    case "HORIZONTAL":
                        flippedImage = ImageUtils.flipImage(inputImage, true, false);
                        break;
                    case "VERTICAL":
                        flippedImage = ImageUtils.flipImage(inputImage, false, true);
                        break;
                    case "BOTH":
                        flippedImage = ImageUtils.flipImage(inputImage, true, true);
                        break;
                    default:
                        System.err.println("-> Unknown flip type: " + flipType);
                        break;
                }
                if (flippedImage != null) {
                    imageVariables.put(outputVar, flippedImage);
                    System.out.println("-> Flipped image from " + inputVar + " (" + flipType + ") to " + outputVar);
                }
            } catch (Exception e) {
                System.err.println("-> Error flipping image " + inputVar + ": " + e.getMessage());
            }
        } else {
            System.err.println("-> Error: Input variable " + inputVar + " not found for FLIP command.");
        }
    }

    @Override
    public void enterSaveCmd(ImageScriptParser.SaveCmdContext ctx) {
        String inputVar = ctx.VAR_NAME().getText();
        String filePath = stripQuotes(ctx.STRING_LITERAL().getText());
        String format = stripQuotes(ctx.STRING_LITERAL().get(1).getText());

        System.out.println("Executing: SAVE " + inputVar + " TO \"" + filePath + "\" FORMAT \"" + format + "\"");

        BufferedImage imageToSave = imageVariables.get(inputVar);
        if (imageToSave != null) {
            try {
                String finalSavePath;
                File outputFile = new File(filePath);
                if (!outputFile.isAbsolute()) {
                    finalSavePath = new File(outputDir, filePath).getAbsolutePath();
                } else {
                    finalSavePath = filePath;
                }

                ImageUtils.saveImage(imageToSave, finalSavePath, format);
                System.out.println("-> Saved image from " + inputVar + " to " + finalSavePath);
            } catch (Exception e) {
                System.err.println("-> Error saving image " + inputVar + " to " + filePath + ": " + e.getMessage());
            }
        } else {
            System.err.println("-> Error: Input variable " + inputVar + " not found for SAVE command.");
        }
    }

    private String stripQuotes(String text) {
        if (text != null && text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1).replace("\"\"", "\"");
        }
        return text;
    }
}