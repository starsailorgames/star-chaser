package GameObjects;

import Util.ImageLoader;

public class ShootingStar extends GameObject {

    public ShootingStar(ImageLoader loader, int posX, int posY){
        super(new ImageLoader().resizeImage(
                new ImageLoader().importImg("/StarShooting.png"),
                152, 45
        ), posX, posY);
        pointValue = 30;
        duration = 2500;
    }

}