package towerDefense.scenes;

import towerDefense.Game;
import towerDefense.controllers.*;
import towerDefense.maps.MapTile;
import towerDefense.towers.BaseTower;
import towerDefense.ui.BottomBar;

import java.awt.*;

import static towerDefense.controllers.MapController.startTile;
import static towerDefense.helper.Constants.Tiles.GRASS_TILE;

public class Playing extends GameScene implements SceneMethods {
    private MapTile[][] map;
    private EnemyController enemyController;
    private CardController cardController;
    private TowerController towerController;
    private int mouseX, mouseY;
    private BaseTower selectedTower;

    private BottomBar bottomBar;
    private objects.PathPoint start, end;

    public Playing(Game game) {
        super(game);

        tileController = new TileController();
        cardController = new CardController();
        map = MapController.createLevel(tileController);
        enemyController = new EnemyController(this, MapController.getStartTile(), MapController.getEndTile());
        towerController = new TowerController(this);
        bottomBar = new BottomBar(0, 480, 640, 160, this);
    }

    public void update() {
        enemyController.update();
    }

    public TileController getTileController() {
        return tileController;
    }

    public CardController getCardController() {
        return cardController;
    }

    @Override
    public void Render(Graphics g) {

        drawMap(g);
        bottomBar.draw(g);
        enemyController.draw(g);
        towerController.draw(g);
        drawSelectedTower(g);
    }

    private void drawSelectedTower(Graphics g) {
        if (selectedTower != null)
            g.drawImage(towerController.getTowerImgs()[selectedTower.getTowerType()], mouseX, mouseY, null);
    }


    public void setSelectedTower(BaseTower selectedTower) {
        this.selectedTower = selectedTower;
    }

    public void drawMap(Graphics g) {
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                MapTile currentTile = map[x][y];
                g.drawImage(tileController.getSprite(currentTile.getId()), x * 32, y * 32, null);
            }
        }
    }

    public int getTileType(int x, int y) {
        int xCord = x / 32;
        int yCord = y / 32;

        if (xCord < 0 || xCord > 19)
            return 0;
        if (yCord < 0 || yCord > 14)
            return 0;


        int id = map[x / 32][y / 32].getId();
        return game.getTileController().getTile(id).getTileType();
    }

    private boolean isTileGrass(int x, int y) {
        int id = map[x / 32][y / 32].getId();
        int tileType = game.getTileController().getTile(id).getTileType();
        return tileType == GRASS_TILE;
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 480) {
            bottomBar.mouseClicked(x, y);
        } else {
            if (selectedTower != null) {
                if (isTileGrass(mouseX, mouseY)) {
                    towerController.addTower(selectedTower, mouseX, mouseY);
                    selectedTower = null;
                }
            }
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
        if (y >= 480) {
            bottomBar.mouseClicked(x, y);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 480) {
            bottomBar.mouseMoved(x, y);
        } else {
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }
    }

    public TowerController getTowerController() {
        return towerController;
    }
}
