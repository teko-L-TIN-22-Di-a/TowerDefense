package scenes;

import controllers.*;
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
    private EnemyController enemyController;

    private int lastTileX, lastTileY;
    private int mouseX, mouseY;
    private boolean drawSelect = false;
    private MapTile selectedTile;
    private int lastTileId;

    private BottomBar bottomBar;

    public Playing(Game game) {
        super(game);

        tileController = new TileController();
        cardController = new CardController();
        towerController = new TowerController(this);
        enemyController = new EnemyController(this);
        lvl = MapController.createLevel(tileController);
        bottomBar = new BottomBar(0, 480, 640, 160, this);

    }

    public void update() {
        enemyController.update();
    }

    public CardController getCardController() {
        return cardController;
    }

    public TowerController getTowerController() {
        return towerController;
    }

    public TileController getTileController() {
        return tileController;
    }

    @Override
    public void Render(Graphics g) {
        for (int x = 0; x < lvl.length; x++) {
            for (int y = 0; y < lvl[x].length; y++) {
                MapTile currentTile = lvl[x][y];
                g.drawImage(tileController.getSprite(currentTile.getId()), x * 32, y * 32, null);
            }
        }

        bottomBar.draw(g);
        drawSelectedTile(g);
        enemyController.draw(g);
    }

    public void setSelectedTile(MapTile tile) {
        this.selectedTile = tile;
        drawSelect = true;
    }

    private void drawSelectedTile(Graphics g) {
        if (selectedTile != null && drawSelect) {
            g.drawImage(selectedTile.getSprite(), mouseX, mouseY, 32, 32, null);
        }
    }

    @Override
    public void mouseClicked(int x, int y) {
        if (y >= 480) {
            bottomBar.mouseClicked(x, y);
        }
        else {
            enemyController.addEnemy(x, y);
        }
    }

    private void changeTile(int x, int y) {
        if (selectedTile != null) {

            int tileX = x / 32;
            int tileY = y / 32;

            if (lastTileX == tileX
                    && lastTileY == tileY
                    && lastTileId == selectedTile.getId())
                return;

            lastTileX = tileX;
            lastTileY = tileY;
            lastTileId = selectedTile.getId();

            lvl[tileX][tileY] = selectedTile;
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
        } else {
            changeTile(x, y);
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        if (y >= 480) {
            drawSelect = false;
            bottomBar.mouseMoved(x, y);
        } else {
            drawSelect = true;
            mouseX = (x / 32) * 32;
            mouseY = (y / 32) * 32;
        }
    }
}
