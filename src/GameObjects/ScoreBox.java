package GameObjects;

import Util.FontLoader;
import Util.ImageLoader;
import Util.ScoreManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreBox {

    private ImageLoader loader;
    private BufferedImage scoreBox;
    private FontLoader fontLoader;
    private Font rainyhearts;
    private Color navy;
    private int posX, posY;
    protected int width, height;
    private ScoreManager scoreManager;
    private String score;
    private int inset;

    public ScoreBox(int posX, int posY, ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
        this.posX = posX;
        this.posY = posY;

        loader = new ImageLoader();
        scoreBox = loader.importImg("/ScoreBox.png");

        this.width = scoreBox.getWidth();
        this.height = scoreBox.getHeight();

        fontLoader = new FontLoader();
        rainyhearts = fontLoader.importFont("/rainyhearts.ttf", 50);
        navy = new Color(66,84,107);

    }

    public Rectangle getBounds(){
        return new Rectangle(posX, posY, width, height);
    }

    public void draw(Graphics g) {
        g.drawImage(scoreBox, posX, posY, null);

        Graphics2D g2D = (Graphics2D) g;
        score = Integer.toString(scoreManager.getScore());
        inset = 10;

        g2D.setFont(rainyhearts);
        g2D.setColor(navy);

        FontMetrics fM = g2D.getFontMetrics();
        int textWidth = fM.stringWidth(score);
        int textHeight = fM.getAscent();
        int boxWidth = scoreBox.getWidth();
        int boxHeight = scoreBox.getHeight();

        g2D.drawString(score, posX + ((boxWidth - textWidth) / 2), posY + ((textHeight + boxHeight) / 2) - fM.getDescent());
    }

}