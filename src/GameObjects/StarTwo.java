package GameObjects;

import Util.ImageLoader;

public class StarTwo extends GameObject {

    public StarTwo(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/Star2.png"),
                65, 60
        ), posX, posY);
        pointValue = 10;
        duration = 8000;
    }

}