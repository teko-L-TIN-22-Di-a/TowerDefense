package towerDefense.controllers;

import towerDefense.enemies.BaseEnemy;
import towerDefense.helper.SpriteHelper;
import towerDefense.scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import static towerDefense.helper.Constants.Direction.*;
import static towerDefense.helper.Constants.Tiles.*;

public class EnemyController {
    private Playing playing;
    private BufferedImage[] enemyImgs;
    private ArrayList<BaseEnemy> enemies = new ArrayList<>();
    private float speed = 0.5f;

    public EnemyController(Playing playing) {
        this.playing = playing;
        enemyImgs = new BufferedImage[4];
        loadEnemyImgs();
    }

    private void loadEnemyImgs() {
        BufferedImage atlas = SpriteHelper.getSpriteAtlas();
        enemyImgs[0] = atlas.getSubimage(0, 32, 32, 32);
        enemyImgs[1] = atlas.getSubimage(32, 32, 32, 32);
        enemyImgs[2] = atlas.getSubimage(2 * 32, 32, 32, 32);
        enemyImgs[3] = atlas.getSubimage(3 * 32, 32, 32, 32);
    }

    public void update() {
        for (BaseEnemy e : enemies) {
            if (isNextTileRoad(e)) {

            }
        }
    }

    public boolean isNextTileRoad(BaseEnemy e) {
        int newX = (int) (e.getX() + getSpeedAndWidth(e.getLastDir()));
        int newY = (int) (e.getY() + getSpeedAndHeight(e.getLastDir()));

        if (getTileType(newX, newY) == ROAD_TILE) {
            e.move(speed, e.getLastDir());
        } else if (isAtEnd(e)) {

        } else {
            setNewDirectionAndMove(e);
        }
        return false;
    }

    private void setNewDirectionAndMove(BaseEnemy e) {
        int dir = e.getLastDir();

        int xCord = (int) (e.getX() / 32);
        int yCord = (int) (e.getY() / 32);

        fixEnemyOffsetTile(e, dir, xCord, yCord);

        if (dir == LEFT || dir == RIGHT) {
            int newY = (int) (e.getY() + getSpeedAndHeight(UP));
            if (getTileType((int) e.getX(), newY) == ROAD_TILE)
                e.move(speed, UP);
            else
                e.move(speed, DOWN);
        } else {
            int newX = (int) (e.getX() + getSpeedAndWidth(RIGHT));
            if (getTileType(newX, (int) e.getY()) == ROAD_TILE)
                e.move(speed, RIGHT);
            else
                e.move(speed, LEFT);

        }
    }

    private void fixEnemyOffsetTile(BaseEnemy e, int dir, int xCord, int yCord) {
        switch (dir) {
            case RIGHT:
                if (xCord < 19)
                    xCord++;
                break;
            case DOWN:
                if (yCord < 14)
                    yCord++;
                break;
        }

        e.setPos(xCord * 32, yCord * 32);

    }

    private boolean isAtEnd(BaseEnemy e) {
        return false;
    }

    private int getTileType(int x, int y) {
        return playing.getTileType(x, y);
    }

    private float getSpeedAndHeight(int dir) {
        if (dir == UP)
            return -speed;
        else if (dir == DOWN)
            return speed + 32;

        return 0;
    }

    private float getSpeedAndWidth(int dir) {
        if (dir == LEFT)
            return -speed;
        else if (dir == RIGHT)
            return speed + 32;

        return 0;
    }

    public void addEnemy(int x, int y) {
        enemies.add(new BaseEnemy(x, y, 0, 0));
    }

    public void draw(Graphics g) {
        for (BaseEnemy e : enemies)
            drawEnemy(e, g);

    }

    private void drawEnemy(BaseEnemy e, Graphics g) {
        g.drawImage(enemyImgs[0], (int) e.getX(), (int) e.getY(), null);
    }
}
