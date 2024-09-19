package towerDefense.scenes;

import towerDefense.Game;
import towerDefense.controllers.TileController;

public class GameScene {
    public Game game;
    protected int animationIndex;
    protected int ANIMATION_SPEED = 25;
    protected int tick;
    public TileController tileController;

    public GameScene(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    protected void updateTick() {
        tick++;
        if (tick >= ANIMATION_SPEED) {
            tick = 0;
            animationIndex++;
            if (animationIndex >= 4)
                animationIndex = 0;
        }
    }
}
