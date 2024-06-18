package inputs;

import main.Game;
import main.GameStates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CustomMouseListener  implements MouseListener, MouseMotionListener {
    private Game game;

    public CustomMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            switch (GameStates.gameState) {
                case PLAYING -> {
                    game.getPlaying().mouseClicked(e.getX(), e.getY());
                }
                case MENU -> {
                    game.getMenu().mouseClicked(e.getX(), e.getY());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING -> {
                game.getPlaying().mousePressed(e.getX(), e.getY());
            }
            case MENU -> {
                game.getMenu().mousePressed(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING -> {
                game.getPlaying().mouseReleased(e.getX(), e.getY());
            }
            case MENU -> {
                game.getMenu().mouseReleased(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING -> {
                game.getPlaying().mouseDragged(e.getX(), e.getY());
            }
            case MENU -> {
                game.getMenu().mouseDragged(e.getX(), e.getY());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameStates.gameState) {
            case PLAYING -> {
                game.getPlaying().mouseMoved(e.getX(), e.getY());
            }
            case MENU -> {
                game.getMenu().mouseMoved(e.getX(), e.getY());
            }
        }
    }
}
