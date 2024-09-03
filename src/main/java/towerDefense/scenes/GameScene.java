package towerDefense.scenes;

import towerDefense.Game;
import towerDefense.controllers.TileController;

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
