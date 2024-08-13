package scenes;

import controllers.CardController;
import controllers.MapController;
import controllers.TileController;
import controllers.TowerController;
import main.Game;
import maps.MapTile;
import ui.BottomBar;

import java.awt.*;

public class Playing extends GameScene implements SceneMethods {
    private boolean levelCreated = false;
    private MapTile[][] lvl;
    private TileController tileController;
    private CardController cardController;
    private TowerController towerController;

    private BottomBar bottomBar;

    public Playing(Game game) {
        super(game);

        tileController = new TileController();
        cardController = new CardController();
        towerController = new TowerController(this);
        lvl = MapController.createLevel(tileController);
        bottomBar = new BottomBar(0, 480, 640, 160, this);

    }

    public CardController getCardController() {
        return cardController;
    }

    public TowerController getTowerController() {
        return towerController;
    }

    @Override
    public void Render(Graphics g) {
        bottomBar.draw(g);
        for (int x = 0; x < lvl.length; x++) {
            for (int y = 0; y < lvl[x].length; y++) {
                MapTile currentTile = lvl[x][y];
                g.drawImage(tileController.getSprite(currentTile.getId()), x * 32, y * 32, null);
//                g.setColor(currentTile.background);
//                g.fillRect(x * 32, y * 32, 32, 32);
            }
        }
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 480) {
            bottomBar.mouseClicked(x, y);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (y >= 480) {
            bottomBar.mousePressed(x, y);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        bottomBar.mouseReleased(x, y);
    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 480) {
            bottomBar.mouseMoved(x, y);
        }
    }
}
