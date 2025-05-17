package GameObjects;

import Util.ImageLoader;

public class StarThree extends GameObject {

    public StarThree(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Star3.png"),
                80, 80
        ), posX, posY);
        pointValue = 10;
        duration = 8000;
    }

}