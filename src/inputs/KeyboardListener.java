package inputs;

import static main.GameStates.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            gameState = MENU;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            gameState = PLAYING;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            gameState = SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
