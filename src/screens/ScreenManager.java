package screens;

import javax.swing.*;

public class ScreenManager {

    private JFrame frame;

    public ScreenManager(JFrame frame){
        this.frame = frame;
    }

    public void getMenu(){
        frame.setContentPane(new MenuScreen(this));
        frame.revalidate();
        frame.repaint();
    }

    public void getGame(){
        frame.setContentPane(new GameScreen(this));
        frame.revalidate();
        frame.repaint();
    }

    public void getEndScreen(){
        frame.setContentPane(new EndScreen(this));
        frame.revalidate();
        frame.repaint();
    }

    public void getOptions(){
        frame.setContentPane(new OptionsScreen(this));
        frame.revalidate();
        frame.repaint();
    }

    public void getHowToPlay(){
        frame.setContentPane(new HowToPlay(this));
        frame.revalidate();
        frame.repaint();
    }

}