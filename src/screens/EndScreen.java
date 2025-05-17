package screens;

import Util.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

public class EndScreen extends JPanel {

    private BufferedImage background, replayTitle;
    private Icon constellationIcon, constellationCompleteIcon;
    private JLabel constellation, constellationComplete;
    private ImageLoader loader;

    public EndScreen(ScreenManager screenManager){

        loader = new ImageLoader();

        background = loader.importImg("/Background.png");
        replayTitle = loader.importImg("/Replay.png");
            replayTitle = loader.resizeImage(replayTitle, 210, 60);

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

        // Constellation Animation
        URL constellationGIF = getClass().getResource("/Constellation.gif");
            constellationIcon = new ImageIcon(constellationGIF);
            constellation = new JLabel(constellationIcon);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,15,0);
            components.add(constellation, c);

        URL constellationCompleteGIF = getClass().getResource("/ConstellationComplete.gif");
            constellationCompleteIcon = new ImageIcon(constellationCompleteGIF);
            constellationComplete = new JLabel(constellationCompleteIcon);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 2;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,15,0);
            components.add(constellationComplete, c);

        c.gridwidth = 1;

        // Bottom Row
        JPanel bottomRow = new JPanel(new GridBagLayout());
        bottomRow.setOpaque(false);
        bottomRow.setVisible(true);

        Dimension buttonSize = new Dimension(70, 70);
            JButton menuButton = createImageButton("/ReplayButton.png", 70,70);
            menuButton.setPreferredSize(buttonSize);
            c = new GridBagConstraints();
            c.gridx = 0;
            c.gridy = 0;
            c.anchor = GridBagConstraints.CENTER;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,0,0,0);
            bottomRow.add(menuButton, c);
            menuButton.addActionListener(e -> screenManager.getMenu());

        ImageIcon replayIcon = new ImageIcon(replayTitle);
            JLabel replayLabel = new JLabel(replayIcon);
            c = new GridBagConstraints();
            c.gridx = 1;
            c.gridy = 0;
            c.anchor = GridBagConstraints.LINE_START;
            c.fill = GridBagConstraints.NONE;
            c.insets = new Insets(0,25,0,0);
            bottomRow.add(replayLabel, c);

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(0, 0, 0, 0);
        components.add(bottomRow, c);

        // Layout
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

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
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