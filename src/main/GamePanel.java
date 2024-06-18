package main;

import inputs.CustomMouseListener;
import inputs.KeyboardListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Dimension size;
    private Render render;
    private Game game;

    private CustomMouseListener customMouseListener;
    private KeyboardListener keyboardListener;

    public GamePanel(Game game) {
        this.game = game;
        setPanelSize();
    }

    public void InitInputs() {
        customMouseListener = new CustomMouseListener(game);
        keyboardListener = new KeyboardListener();

        addMouseListener(customMouseListener);
        addMouseMotionListener(customMouseListener);
        addKeyListener(keyboardListener);

        //Get the focus of this component (JFrame)
        requestFocus();
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
