package scenes;

import main.Game;

import java.awt.*;

public class Settings extends GameScene implements SceneMethods {
    public Settings(Game game) {
        super(game);
    }

    @Override
    public void Render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0, 0, 640, 640);
    }
}
