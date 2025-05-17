package Util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {

    public BufferedImage importImg(String filePath){
        BufferedImage image = null;
        
        InputStream is = getClass().getResourceAsStream(filePath);
        try {
            image = ImageIO.read(is);
        } catch (IOException e) {
            System.err.println("Error loading image: " + e.getMessage());
        }
        return image;
    }

    public BufferedImage resizeImage(BufferedImage image, int width, int height) {
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedResizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = bufferedResizedImage.createGraphics();
        g2d.setComposite(AlphaComposite.Src);
        g2d.drawImage(resizedImage, 0, 0, null);
        g2d.dispose();

        return bufferedResizedImage;
    }

    public int getWidth(BufferedImage image){
        return image.getWidth();
    }

    public int getHeight(BufferedImage image){
        return image.getHeight();
    }

}