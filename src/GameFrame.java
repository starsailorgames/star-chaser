import screens.ScreenManager;

import javax.swing.*;

public class GameFrame extends JFrame {

    private ScreenManager screenManager;

    public GameFrame(){
        this.setTitle("Star Chaser");
        this.setIconImage(new ImageIcon(getClass().getResource("/res/Star4.png")).getImage());
        this.setSize(960,540);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screenManager = new ScreenManager(this);

        screenManager.getMenu();

        this.setVisible(true);
    }

}