package GameObjects;

import Util.ImageLoader;

public class PlanetSmall extends GameObject {

    public PlanetSmall(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Planet.png"),
                75, 75
        ), posX, posY);
        pointValue = 20;
        duration = 4500;
    }

}