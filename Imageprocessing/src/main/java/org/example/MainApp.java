package org.example; // Keep this package

import com.example.parser.ImageProcessingScriptListener;
import com.example.parser.ImageScriptLexer;
import com.example.parser.ImageScriptParser;
import com.example.imagecore.JITExecutor;
import com.example.imagecore.ImageUtils;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainApp {
    public static void main(String[] args) {
        // Create a dedicated output directory for processed images
        String outputDir = "script_output_images";
        new File(outputDir).mkdirs(); // Ensure directory exists

        String scriptFilePath = "myscript.is";
        File scriptFile = new File(scriptFilePath);

        // --- Dummy Script and Input Image Creation ---
        if (!scriptFile.exists()) {
            System.out.println("Script file '" + scriptFilePath + "' not found. Creating a dummy script for demonstration.");
            try {
                // Create dummy input.png in the output directory
                String inputImagePath = outputDir + File.separator + "input.png";
                File inputPng = new File(inputImagePath);
                if (!inputPng.exists()) {
                    BufferedImage dummyInput = new BufferedImage(200, 150, BufferedImage.TYPE_INT_ARGB); // Use ARGB for transparency
                    // Fill with some color, e.g., blue
                    for (int x = 0; x < dummyInput.getWidth(); x++) {
                        for (int y = 0; y < dummyInput.getHeight(); y++) {
                            dummyInput.setRGB(x, y, new Color(0, 0, 255, 255).getRGB()); // Blue opaque
                        }
                    }
                    ImageUtils.saveImage(dummyInput, inputImagePath, "png");
                    System.out.println("Created dummy " + inputImagePath + " for the script.");
                }

                String dummyScriptContent =
                        "// Image Processing Script Demo\n" +
                                "LOAD \"" + inputImagePath + "\" AS originalImage;\n" + // Use input path
                                "RESIZE originalImage WIDTH 150 HEIGHT 100 AS resizedImage;\n" +
                                "GRAYSCALE resizedImage AS grayImage;\n" +
                                "SAVE grayImage TO \"" + outputDir + File.separator + "processed_gray.png\" FORMAT \"png\";\n" +
                                "ROTATE originalImage ANGLE 45 AS rotatedImage;\n" +
                                "SAVE rotatedImage TO \"" + outputDir + File.separator + "processed_rotated.png\" FORMAT \"png\";\n" +
                                "FLIP originalImage HORIZONTAL AS flippedHImage;\n" +
                                "SAVE flippedHImage TO \"" + outputDir + File.separator + "processed_flipped_h.png\" FORMAT \"png\";\n" +
                                "FLIP originalImage VERTICAL AS flippedVImage;\n" +
                                "SAVE flippedVImage TO \"" + outputDir + File.separator + "processed_flipped_v.png\" FORMAT \"png\";\n" +
                                "FLIP originalImage BOTH AS flippedBImage;\n" +
                                "SAVE flippedBImage TO \"" + outputDir + File.separator + "processed_flipped_b.png\" FORMAT \"png\";\n";
                Files.writeString(Paths.get(scriptFilePath), dummyScriptContent);
                System.out.println("Dummy script '" + scriptFilePath + "' created. Please re-run or edit it.");
            } catch (IOException e) {
                System.err.println("Could not create dummy script or image: " + e.getMessage());
                return;
            }
        }
        // --- End Dummy Script and Input Image Creation ---


        try {
            System.out.println("Reading script from: " + scriptFilePath);
            String scriptContent = Files.readString(Paths.get(scriptFilePath));

            System.out.println("\n--- Script Content ---");
            System.out.println(scriptContent);
            System.out.println("--- End Script Content ---\n");

            ImageScriptLexer lexer = new ImageScriptLexer(CharStreams.fromString(scriptContent));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ImageScriptParser parser = new ImageScriptParser(tokens);

            ParseTree tree = parser.script();

            // Instantiate JITExecutor and pass it to the listener
            JITExecutor executor = new JITExecutor();
            ImageProcessingScriptListener listener = new ImageProcessingScriptListener(executor);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            System.out.println("\nScript execution finished. Check the '" + outputDir + "' directory for output images.");

        } catch (IOException e) {
            System.err.println("Error reading script file or processing: " + e.getMessage());
            e.printStackTrace();
        }
    }
}