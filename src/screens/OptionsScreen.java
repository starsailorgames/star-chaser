package screens;

import Util.ImageLoader;
import Util.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class OptionsScreen extends JPanel {

    private BufferedImage background, optionsWindow, optionsTitle, menuTitle, musicTitle, howToTitle, quitTitle;
    private ImageLoader loader;
    private boolean musicIsPaused = false;

    public OptionsScreen (ScreenManager screenManager){

        loader = new ImageLoader();
        Music music = Music.getInstance();

        background = loader.importImg("/Background.png");
        optionsWindow = loader.importImg("/optionsWindow.png");
            optionsWindow = loader.resizeImage(optionsWindow, 500, 475);
        optionsTitle = loader.importImg("/Options.png");
            optionsTitle = loader.resizeImage(optionsTitle, 299, 80);
        menuTitle = loader.importImg("/optionsMenu.png");
            menuTitle = loader.resizeImage(menuTitle, 144, 50);
        musicTitle = loader.importImg("/optionsMusic.png");
            musicTitle = loader.resizeImage(musicTitle, 169, 50);
        howToTitle = loader.importImg("/optionsHowTo.png");
            howToTitle = loader.resizeImage(howToTitle, 213, 50);
        quitTitle = loader.importImg("/optionsQuit.png");
            quitTitle = loader.resizeImage(quitTitle, 119, 50);

        setLayout(new BorderLayout());

        JPanel options = new JPanel();
            options.setOpaque(false);
            options.setVisible(true);
            options.setLayout(new GridBagLayout());
            GridBagConstraints c;
            c = new GridBagConstraints();
            c.insets = new Insets(5, 5, 5, 5);
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.weightx = 1;
            c.weighty = 1;

        // Labels
        ImageIcon optionsIcon = new ImageIcon(optionsTitle);
            JLabel optionsLabel = new JLabel(optionsIcon);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,15,0);
            options.add(optionsLabel, c);

        c.gridwidth = 1;

        ImageIcon menuIcon = new ImageIcon(menuTitle);
            JLabel menuLabel = new JLabel(menuIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 1;
            c.anchor = GridBagConstraints.LINE_START;
            c.insets = new Insets(10, 25, 10, 0);
            options.add(menuLabel, c);

        ImageIcon musicIcon = new ImageIcon(musicTitle);
            JLabel musicLabel = new JLabel(musicIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 2;
            c.anchor = GridBagConstraints.LINE_START;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(10, 25, 10, 0);
            options.add(musicLabel, c);

        ImageIcon questionIcon = new ImageIcon(howToTitle);
            JLabel howToLabel = new JLabel(questionIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 3;
            c.anchor = GridBagConstraints.LINE_START;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(10, 25, 10, 0);
            options.add(howToLabel, c);

        ImageIcon quitIcon = new ImageIcon(quitTitle);
            JLabel quitLabel = new JLabel(quitIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 4;
            c.anchor = GridBagConstraints.LINE_START;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(10, 25, 0, 0);
            options.add(quitLabel, c);

        // Buttons
        Dimension buttonSize = new Dimension(70,70);
        JButton menuButton = createImageButton("/Menu.png", 70, 70);
            menuButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 1;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(5, 0, 5, 0);
            options.add(menuButton, c);

        JButton musicButton = createImageButton("/Volume.png", 70, 70);
            musicButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(5, 0, 5, 0);
            options.add(musicButton, c);

        JButton questionButton = createImageButton("/Question.png", 70, 70);
            questionButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 3;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(5, 0, 5, 0);
            options.add(questionButton, c);

        JButton exitButton = createImageButton("/Exit.png", 70,70);
            exitButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 4;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(5, 0, 0, 0);
            options.add(exitButton, c);

        // Listeners
        menuButton.addActionListener(e -> screenManager.getMenu());
        musicButton.addActionListener(e -> {
            if (musicIsPaused) {
                music.resumeMusic();
            } else {
                music.pauseMusic();
            }
            musicIsPaused = !musicIsPaused;
        });
        questionButton.addActionListener(e -> screenManager.getHowToPlay());
        exitButton.addActionListener(e -> System.exit(0));

        // Add
        JPanel overlay = new JPanel(new GridBagLayout());
            GridBagConstraints overlayC = new GridBagConstraints();
            overlay.setOpaque(false);
            overlay.setVisible(true);
            overlayC.gridx = 0;
            overlayC.gridy = 0;
            overlayC.weightx = 1.0;
            overlayC.weighty = 1.0;
            overlayC.anchor = GridBagConstraints.CENTER;
            overlayC.fill = GridBagConstraints.NONE;
        overlay.add(options, c);
        add(overlay, BorderLayout.CENTER);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int windowWidth = optionsWindow.getWidth();
        int windowHeight = optionsWindow.getHeight();
        g.drawImage(optionsWindow, (panelWidth - windowWidth) / 2, (panelHeight - windowHeight) / 2, null);
    }

    private JButton createImageButton(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        JButton button = new JButton(scaledIcon);

        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }

}