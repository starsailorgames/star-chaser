package GameObjects;

import Util.ImageLoader;

public class Heart extends GameObject {

    public Heart(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Heart.png"),
                64, 50
        ), posX, posY);
        pointValue = 50;
        duration = 1500;
    }

}