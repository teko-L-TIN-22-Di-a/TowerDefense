package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Dimension size;
    private Render render;
    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
    }

    private void setPanelSize() {
        size = new Dimension(640, 640);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.getRender().Render(g);
    }
}
