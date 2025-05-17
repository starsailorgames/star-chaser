package GameObjects;

import Util.ImageLoader;

public class StarFour extends GameObject {

    public StarFour(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Star4.png"),
                60, 60
        ), posX, posY);
        pointValue = 10;
        duration = 8000;
    }

}