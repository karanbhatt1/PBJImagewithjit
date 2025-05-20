package imageprocessing;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.List;

public class JITExecutor {
    private BufferedImage image;

    public void execute(List<String> tac) {
        try {
            for (String line : tac) {
                String[] parts = line.trim().split("\\s+");
                String cmd = parts[0].toUpperCase();

                switch (cmd) {
                    case "LOAD":
                        image = ImageIO.read(new File(parts[1]));
                        System.out.println("Loaded: " + parts[1]);
                        break;

                    case "GRAYSCALE":
                        applyGrayscale();
                        System.out.println("Applied grayscale");
                        break;

                    case "RESIZE":
                        int width = Integer.parseInt(parts[1]);
                        int height = Integer.parseInt(parts[2]);
                        resize(width, height);
                        System.out.println("Resized to " + width + "x" + height);
                        break;

                    case "FLIP":
                        flip();
                        System.out.println("Flipped image horizontally");
                        break;

                    case "ROTATE":
                        int angle = Integer.parseInt(parts[1]);
                        rotate(angle);
                        System.out.println("Rotated by " + angle + " degrees");
                        break;

                    case "SAVE":
                        ImageIO.write(image, "jpg", new File(parts[1]));
                        System.out.println("Saved to: " + parts[1]);
                        break;

                    default:
                        System.out.println("Unknown command: " + cmd);
                }
            }
        } catch (Exception e) {
            System.err.println("Error during execution: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void applyGrayscale() {
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                Color c = new Color(image.getRGB(i, j));
                int gray = (int)(0.3 * c.getRed() + 0.59 * c.getGreen() + 0.11 * c.getBlue());
                Color newColor = new Color(gray, gray, gray);
                image.setRGB(i, j, newColor.getRGB());
            }
        }
    }

    private void resize(int newWidth, int newHeight) {
        BufferedImage resized = new BufferedImage(newWidth, newHeight, image.getType());
        Graphics2D g = resized.createGraphics();
        g.drawImage(image, 0, 0, newWidth, newHeight, null);
        g.dispose();
        image = resized;
    }

    private void flip() {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(), 0);
        BufferedImage flipped = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
        Graphics2D g = flipped.createGraphics();
        g.drawImage(image, tx, null);
        g.dispose();
        image = flipped;
    }

    private void rotate(int angle) {
        double radians = Math.toRadians(angle);
        int w = image.getWidth();
        int h = image.getHeight();

        BufferedImage rotated = new BufferedImage(w, h, image.getType());
        Graphics2D g = rotated.createGraphics();
        g.rotate(radians, w / 2, h / 2);
        g.drawImage(image, 0, 0, null);
        g.dispose();
        image = rotated;
    }
}