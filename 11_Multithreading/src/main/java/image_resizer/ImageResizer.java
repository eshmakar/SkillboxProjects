package image_resizer;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;

public class ImageResizer extends Thread {
    private File[] files;
    private int newWidth;
    private String dstFolder;

    public ImageResizer(File[] files, int newWidth, String dstFolder) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;

    }

    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, newWidth, newHeight);

                File newFile = new File(dstFolder + "/" + file.getName());
                if (newFile != null) {
                    newFile.delete();
                }
                ImageIO.write(newImage, "jpg", newFile);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}