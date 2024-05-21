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
            gameStates = MENU;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            gameStates = PLAYING;
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            gameStates = SETTINGS;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
