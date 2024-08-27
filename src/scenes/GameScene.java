package scenes;

import controllers.TileController;
import main.Game;

import java.awt.image.BufferedImage;

public class GameScene {
    public Game game;
    public TileController tileController;

    public GameScene(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

}
