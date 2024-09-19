package towerDefense.inputs;

import towerDefense.Game;

import static towerDefense.GameStates.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    private Game game;

    public KeyboardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (gameState == PLAYING)
            game.getPlaying().keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
