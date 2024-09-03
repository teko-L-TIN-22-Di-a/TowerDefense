package towerDefense;

import towerDefense.controllers.TileController;
import towerDefense.scenes.Menu;
import towerDefense.scenes.Playing;
import towerDefense.scenes.Settings;

import javax.swing.*;

public class Game extends JFrame implements Runnable {
    private GamePanel gamePanel;
    private Thread gameThread;

    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;

    //Classes
    private Render render;
    private Menu menu;
    private Playing playing;
    private Settings settings;

    private TileController tileController;

    public Game() {
        InitClasses();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gamePanel);

        pack();
        setVisible(true);
    }

    private void InitClasses() {
        tileController = new TileController();
        render = new Render(this);
        gamePanel = new GamePanel(this);
        menu = new Menu(this);
        playing = new Playing(this);
        settings = new Settings(this);
    }

    private void Start() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void UpdateGame() {
        switch (GameStates.gameState) {
            case PLAYING -> {
                playing.update();
            }
            case MENU -> {
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gamePanel.InitInputs();
        game.Start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long lastTimeCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        long now;

        while (true) {
            now = System.nanoTime();

            //main.towerDefense.Render -> How often redrawing happens
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                repaint();
                lastFrame = now;
                frames++;
            }

            //Update -> How often gamelogic updates
            if (System.nanoTime() - lastUpdate >= timePerUpdate) {
                UpdateGame();
                lastUpdate = now;
                updates++;
            }

            //checking FPS and UPS
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            }
        }
    }

    //Getters and setters
    public Render getRender() {
        return render;
    }

    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Settings getSettings() {
        return settings;
    }

    public TileController getTileController() {
        return tileController;
    }
}