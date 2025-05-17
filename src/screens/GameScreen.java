package screens;

import GameObjects.*;
import Util.ImageLoader;
import Util.ScoreManager;
import Util.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameScreen extends JPanel implements ActionListener {

    private ImageLoader loader;
    private BufferedImage background, score;
    private Title scoreTitle;
    private ScreenManager screenManager;

    private Timer timer;
    private final int DELAY = 16;
    private ScoreManager scoreManager;
    private ScoreBox scoreBox;
    private final int winningScore = 1000;
    private boolean gameOver = false;

    private ArrayList<GameObject> objects;
    private Random random = new Random();
    private List<Position> objectFactories;
    private int spawnTry = 500;
    private int tries = 0;
    private boolean drawn = false;
    private Dimension size(int index) {
        return switch (index) {
            case 0 -> new Dimension(70, 70);
            case 1 -> new Dimension(80, 80);
            case 2 -> new Dimension(65, 60);
            case 3 -> new Dimension(60, 60);
            case 4 -> new Dimension(152, 45);
            case 5 -> new Dimension(75, 75);
            case 6 -> new Dimension(117, 85);
            case 7 -> new Dimension(64, 50);
            default -> new Dimension(64, 64);
        };
    }

    public GameScreen(ScreenManager screenManager) {
        this.screenManager = screenManager;
        scoreManager = new ScoreManager();

        loader = new ImageLoader();
        background = loader.importImg("/Background.png");
        score = loader.importImg("/Score.png");


        scoreManager = new ScoreManager();
        scoreBox = new ScoreBox(25, 400, scoreManager);
        scoreTitle = new Title(score, 25, 345);

        timer = new Timer(DELAY, this);
        timer.start();

        objects = new ArrayList<>();
        objectFactories = List.of(
                (posX, posY) -> new StarOne(loader, posX, posY),
                (posX, posY) -> new StarTwo(loader, posX, posY),
                (posX, posY) -> new StarThree(loader, posX, posY),
                (posX, posY) -> new StarFour(loader, posX, posY),
                (posX, posY) -> new ShootingStar(loader, posX, posY),
                (posX, posY) -> new PlanetSmall(loader, posX, posY),
                (posX, posY) -> new PlanetLarge(loader, posX, posY),
                (posX, posY) -> new Heart(loader, posX, posY)
        );

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                for(int i = objects.size() - 1; i >= 0; i--){
                    Point click = e.getPoint();

                    GameObject object = objects.get(i);
                    if(object.getBounds().contains(click)){
                        object.expire();
                        scoreManager.addScore(object.getPointValue());
                        repaint();
                        break;
                    }
                }
            }
        });
        update();
    }

    private void spawnObject() {
        int index = random.nextInt(objectFactories.size());

        boolean drawn = false;
        int tries = 0;

        Dimension size = size(index);
        int boundX = 920 - size.width;
        int boundY = 500 - size.height;

        while(!drawn && tries < spawnTry){
            int x = random.nextInt(boundX);
            int y = random.nextInt(boundY);
            Rectangle bounds = new Rectangle(x, y, size.width, size.height);

            boolean intersects = false;

            for(GameObject object : objects){
                if(bounds.intersects(object.getBounds())){
                    intersects = true;
                    break;
                }
            }
            if(!intersects &&
                    !bounds.intersects(scoreBox.getBounds()) &&
                    !bounds.intersects(scoreTitle.getBounds())){
                GameObject newObject = objectFactories.get(index).create(x, y);
                objects.add(newObject);
                drawn = true;
                return;
            }
            tries++;
        }
    }

    private void update() {
        objects.removeIf(GameObject::isExpired);

        if (Math.random() < 0.05) {
            spawnObject();
        }

        if (scoreManager.getScore() >= winningScore) {
            gameOver = true;
            timer.stop();
            SwingUtilities.invokeLater(() -> screenManager.getEndScreen());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);

        scoreBox.draw(g);
        scoreTitle.draw(g);

        for (GameObject obj : objects) {
            obj.draw(g);
        }
    }

}