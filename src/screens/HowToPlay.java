package screens;

import Util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HowToPlay extends JPanel {
    private BufferedImage background, optionsWindow, howToPlayTitle, instructionsTitle, backTitle;
    private ImageLoader loader;

    public HowToPlay(ScreenManager screenManager){

        loader = new ImageLoader();

        background = loader.importImg("/Background.png");
        optionsWindow = loader.importImg("/optionsWindow.png");
            optionsWindow = loader.resizeImage(optionsWindow, 500, 475);
        howToPlayTitle = loader.importImg("/HowToPlay.png");
            howToPlayTitle = loader.resizeImage(howToPlayTitle, 345, 60);
        instructionsTitle = loader.importImg("/Instructions.png");
            instructionsTitle = loader.resizeImage(instructionsTitle, 420, 228);
        backTitle = loader.importImg("/Back.png");
            backTitle = loader.resizeImage(backTitle, 100, 40);

        setLayout(new BorderLayout());

        JPanel components = new JPanel();
        components.setOpaque(false);
        components.setVisible(true);
        components.setLayout(new GridBagLayout());
        GridBagConstraints c;
        c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.NONE;
        c.weightx = 1;
        c.weighty = 1;

        //Labels
        ImageIcon howToPlayIcon = new ImageIcon(howToPlayTitle);
            JLabel howToPlayLabel = new JLabel(howToPlayIcon);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,15,0);
            components.add(howToPlayLabel, c);

       ImageIcon instructionsIcon = new ImageIcon(instructionsTitle);
           JLabel instructionsLabel = new JLabel(instructionsIcon);
           c = new GridBagConstraints();
           c.gridx = 0;
           c.gridy = 1;
           c.gridwidth = 2;
           c.anchor = GridBagConstraints.CENTER;
           c.fill = GridBagConstraints.NONE;
           c.insets = new Insets(0,0,15,0);
           components.add(instructionsLabel, c);

        c.gridwidth = 1;

       // Bottom Row
        JPanel bottomRow = new JPanel(new GridBagLayout());
        bottomRow.setOpaque(false);
        bottomRow.setVisible(true);

        Dimension buttonSize = new Dimension(70, 70);
        JButton menuButton = createImageButton("/Menu.png", 70,70);
            menuButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,0,0);
            bottomRow.add(menuButton, c);
            menuButton.addActionListener(e -> screenManager.getOptions());

        ImageIcon backIcon = new ImageIcon(backTitle);
            JLabel backLabel = new JLabel(backIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 0;
            c.anchor = GridBagConstraints.LINE_START;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,25,0,0);
            bottomRow.add(backLabel, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        components.add(bottomRow, c);

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
        overlay.add(components, c);
        add(overlay, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
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