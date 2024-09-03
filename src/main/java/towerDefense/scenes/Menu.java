package towerDefense.scenes;

import towerDefense.Game;
import towerDefense.ui.CustomButton;

import java.awt.*;

import static towerDefense.GameStates.*;
import static towerDefense.GameStates.PLAYING;
import static towerDefense.GameStates.SetGameState;

public class Menu extends GameScene implements SceneMethods {

    private CustomButton bPlaying, bQuit;

    public Menu(Game game) {
        super(game);
        initButtons();
    }

    private void initButtons() {
        int w = 150;
        int h = w / 3;
        int x = 640 / 2 - w / 2;
        int y = 150;
        int yOffset = 100;

        bPlaying = new CustomButton("Start", x, y, w, h);
        bQuit = new CustomButton("Quit", x, y + yOffset, w, h);
    }

    @Override
    public void Render(Graphics g) {
        drawButtons(g);
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAYING);
        }

        if (bQuit.getBounds().contains(x, y)) {
            System.exit(0);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseHover(false);
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMouseHover(true);
        }

        bQuit.setMouseHover(false);
        if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseHover(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        bPlaying.setMousePressed(false);
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMousePressed(true);
        }

        bQuit.setMousePressed(false);
        if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        this.resetButtons();
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bQuit.draw(g);
    }

    private void resetButtons() {
        bPlaying.setMousePressed(false);
        bQuit.setMousePressed(false);
    }
}
