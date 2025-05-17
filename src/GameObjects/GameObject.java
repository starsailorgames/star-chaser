package GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {

    protected BufferedImage icon;
    protected int width, height;
    protected int pointValue;
    protected int duration;
    protected long spawnTime;
    protected boolean isExpired = false;
    protected int posX, posY;

    public GameObject(BufferedImage icon, int posX, int posY){
        this.icon = icon;
        this.width = icon.getWidth();
        this.height = icon.getHeight();

        this.spawnTime = System.currentTimeMillis();

        this.posX = posX;
        this.posY = posY;
    }

    public Boolean isExpired(){
        return isExpired || System.currentTimeMillis() - spawnTime > duration;
    }

    public void expire() {
        isExpired = true;
    }

    public int getPointValue(){
        return pointValue;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Rectangle getBounds(){
        return new Rectangle(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(icon, posX, posY, null);
    }

}