package screens;

import Util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MenuScreen extends JPanel {

    private BufferedImage background, window, title, tag;
    private ImageLoader loader;

    public MenuScreen(ScreenManager screenManager){

        loader = new ImageLoader();

        title = loader.importImg("/Title.png");
        title = loader.resizeImage(title, 429, 68);

        tag = loader.importImg("/Tag.png");
        tag = loader.resizeImage(tag, 182, 27);

        window = loader.importImg("/Screen.png");
        background = loader.importImg("/Background.png");

        JPanel overlay = new JPanel(new BorderLayout());
        overlay.setOpaque(false);

        JPanel spacer = new JPanel();
        spacer.setPreferredSize(new Dimension(400, 280));
        spacer.setOpaque(false);

        // Button Panel
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4, 0, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.setPreferredSize(new Dimension(400, 80));

        JButton optionsButton = createImageButton("/Menu.png", 80, 80);
        JButton startButton = createImageButton("/Play.png", 80, 80);
        JButton exitButton = createImageButton("/Exit.png", 80, 80);

        // Listeners
        startButton.addActionListener(e -> screenManager.getGame());
        optionsButton.addActionListener(e -> screenManager.getOptions());
        exitButton.addActionListener(e -> System.exit(0));

        // Add
        buttonsPanel.add(optionsButton);
        buttonsPanel.add(startButton);
        buttonsPanel.add(exitButton);

        overlay.add(spacer, BorderLayout.NORTH);
        overlay.add(buttonsPanel, BorderLayout.CENTER);
        add(overlay, BorderLayout.CENTER);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        int panelWidth = getWidth();
        int panelHeight = getHeight();

        int windowWidth = window.getWidth();
        int windowHeight = window.getHeight();
        g.drawImage(window, (panelWidth - windowWidth) / 2, (panelHeight - windowHeight) / 2, null);

        int titleWidth = title.getWidth();
        g.drawImage(title, (panelWidth - titleWidth) / 2, 140, null);

        int tagWidth = tag.getWidth();
        g.drawImage(tag, (panelWidth - tagWidth) / 2, 228, null);

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