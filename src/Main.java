import Util.Music;

public class Main {

    public static void main(String[] args) {
        new GameFrame();

        Music music = Music.getInstance();
        music.getInstance().importMusic("src/res/stars - canbu.wav");
        music.getInstance().playMusic();

    }

}