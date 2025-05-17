package GameObjects;

import Util.ImageLoader;

public class PlanetLarge extends GameObject {

    public PlanetLarge(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Planet2.png"),
                117, 85
        ), posX, posY);
        pointValue = 20;
        duration = 4500;
    }

}