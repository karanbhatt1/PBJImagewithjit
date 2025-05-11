package org.example;

// src/main/java/com/example/parser/ImageProcessingScriptListener.java


import com.example.imagecore.ImageUtils; // Assuming ImageUtils is in this package or imported
import org.antlr.v4.runtime.tree.TerminalNode;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

// Make sure ImageUtils is in a package like com.example.imagecore
// and you import it, or it's in the same package (not recommended for util classes)

public class ImageProcessingScriptListener extends ImageScriptBaseListener {

    private Map<String, BufferedImage> imageVariables = new HashMap<>();
    private String outputDir = "script_output_images"; // Define an output directory

    public ImageProcessingScriptListener() {
        new File(outputDir).mkdirs(); // Ensure output directory exists
    }

    @Override
    public void enterLoadCmd(ImageScriptParser.LoadCmdContext ctx) {
        String filePath = stripQuotes(ctx.filePath.getText());
        String varName = ctx.varName.getText();
        System.out.println("Executing: LOAD \"" + filePath + "\" AS " + varName);

        BufferedImage img = ImageUtils.loadImage(filePath);
        if (img != null) {
            imageVariables.put(varName, img);
            System.out.println(" -> Loaded '" + filePath + "' into variable '" + varName + "'.");
        } else {
            System.err.println(" -> Failed to load image: " + filePath);
        }
    }

    @Override
    public void enterResizeCmd(ImageScriptParser.ResizeCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        int targetWidth = Integer.parseInt(ctx.width.getText());
        int targetHeight = Integer.parseInt(ctx.height.getText());
        String outputVar = ctx.outputVar.getText();
        System.out.println("Executing: RESIZE " + inputVar + " WIDTH " + targetWidth + " HEIGHT " + targetHeight + " AS " + outputVar);

        BufferedImage originalImg = imageVariables.get(inputVar);
        if (originalImg != null) {
            BufferedImage resizedImg = ImageUtils.resizeImage(originalImg, targetWidth, targetHeight);
            if (resizedImg != null) {
                imageVariables.put(outputVar, resizedImg);
                System.out.println(" -> Resized '" + inputVar + "' into '" + outputVar + "'.");
            } else {
                System.err.println(" -> Failed to resize image: " + inputVar);
            }
        } else {
            System.err.println(" -> Error: Variable '" + inputVar + "' not found for resizing.");
        }
    }

    @Override
    public void enterGrayscaleCmd(ImageScriptParser.GrayscaleCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String outputVar = ctx.outputVar.getText();
        System.out.println("Executing: GRAYSCALE " + inputVar + " AS " + outputVar);

        BufferedImage originalImg = imageVariables.get(inputVar);
        if (originalImg != null) {
            BufferedImage grayImg = ImageUtils.convertToGrayscale(originalImg);
            if (grayImg != null) {
                imageVariables.put(outputVar, grayImg);
                System.out.println(" -> Converted '" + inputVar + "' to grayscale into '" + outputVar + "'.");
            } else {
                System.err.println(" -> Failed to grayscale image: " + inputVar);
            }
        } else {
            System.err.println(" -> Error: Variable '" + inputVar + "' not found for grayscale.");
        }
    }

    @Override
    public void enterRotateCmd(ImageScriptParser.RotateCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        double angle = Double.parseDouble(ctx.angle.getText());
        String outputVar = ctx.outputVar.getText();
        System.out.println("Executing: ROTATE " + inputVar + " ANGLE " + angle + " AS " + outputVar);

        BufferedImage originalImg = imageVariables.get(inputVar);
        if (originalImg != null) {
            BufferedImage rotatedImg = ImageUtils.rotateImage(originalImg, angle);
            if (rotatedImg != null) {
                imageVariables.put(outputVar, rotatedImg);
                System.out.println(" -> Rotated '" + inputVar + "' into '" + outputVar + "'.");
            } else {
                System.err.println(" -> Failed to rotate image: " + inputVar);
            }
        } else {
            System.err.println(" -> Error: Variable '" + inputVar + "' not found for rotation.");
        }
    }

    @Override
    public void enterFlipCmd(ImageScriptParser.FlipCmdContext ctx) {
        String inputVar = ctx.inputVar.getText();
        String direction = ctx.direction.getText();
        String outputVar = ctx.outputVar.getText();
        System.out.println("Executing: FLIP " + inputVar + " " + direction + " AS " + outputVar);

        BufferedImage originalImg = imageVariables.get(inputVar);
        if (originalImg != null) {
            boolean horizontalFlip = false;
            boolean verticalFlip = false;
            if ("HORIZONTAL".equals(direction) || "BOTH".equals(direction)) {
                horizontalFlip = true;
            }
            if ("VERTICAL".equals(direction) || "BOTH".equals(direction)) {
                verticalFlip = true;
            }
            BufferedImage flippedImg = ImageUtils.flipImage(originalImg, horizontalFlip, verticalFlip);
            if (flippedImg != null) {
                imageVariables.put(outputVar, flippedImg);
                System.out.println(" -> Flipped '" + inputVar + "' (" + direction + ") into '" + outputVar + "'.");
            } else {
                System.err.println(" -> Failed to flip image: " + inputVar);
            }
        } else {
            System.err.println(" -> Error: Variable '" + inputVar + "' not found for flipping.");
        }
    }


    @Override
    public void enterSaveCmd(ImageScriptParser.SaveCmdContext ctx) {
        String varName = ctx.varName.getText();
        String filePath = stripQuotes(ctx.filePath.getText());
        String formatName = stripQuotes(ctx.formatName.getText());
        System.out.println("Executing: SAVE " + varName + " TO \"" + filePath + "\" FORMAT \"" + formatName + "\"");

        BufferedImage imgToSave = imageVariables.get(varName);
        if (imgToSave != null) {
            // Prepend output directory
            String fullOutputPath = outputDir + File.separator + filePath;
            if (ImageUtils.saveImage(imgToSave, fullOutputPath, formatName)) {
                System.out.println(" -> Saved '" + varName + "' to '" + fullOutputPath + "'.");
            } else {
                System.err.println(" -> Failed to save image '" + varName + "' to '" + fullOutputPath + "'.");
            }
        } else {
            System.err.println(" -> Error: Variable '" + varName + "' not found for saving.");
        }
    }

    // Helper to remove quotes from string literals
    private String stripQuotes(String text) {
        if (text != null && text.length() >= 2 && text.startsWith("\"") && text.endsWith("\"")) {
            return text.substring(1, text.length() - 1).replace("\"\"", "\""); // also handle escaped quotes "" -> "
        }
        return text;
    }
}