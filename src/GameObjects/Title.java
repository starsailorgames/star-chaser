package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Title {

    private BufferedImage image;
        private int posX, posY;

        public Title(BufferedImage image, int posX, int posY){
            this.image = image;
            this.posX = posX;
            this.posY = posY;

        }

        public Rectangle getBounds(){
            return new Rectangle(posX, posY, image.getWidth(), image.getHeight());
        }

        public int getWidth(){
            return image.getWidth();
        }

        public int getHeight(){
            return image.getHeight();
        }

        public void draw(Graphics g) {
            g.drawImage(image, posX, posY, null);
        }

}