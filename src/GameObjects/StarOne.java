package GameObjects;

import Util.ImageLoader;

public class StarOne extends GameObject {

    public StarOne(ImageLoader loader, int posX, int posY) {
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Star.png"),
                70, 70
        ), posX, posY);
        pointValue = 10;
        duration = 8000;
    }

}