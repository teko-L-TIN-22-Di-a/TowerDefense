package towerDefense.controllers;

import towerDefense.enemies.Bat;
import towerDefense.enemies.Snake;
import towerDefense.enemies.Slime;
import towerDefense.enemies.Turtle;
import objects.PathPoint;
import towerDefense.enemies.BaseEnemy;
import towerDefense.helper.SpriteHelper;
import towerDefense.scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static towerDefense.helper.Constants.Direction.*;
import static towerDefense.helper.Constants.Enemies.*;
import static towerDefense.helper.Constants.Tiles.*;

public class EnemyController {
    private Playing playing;
    private BufferedImage[] enemyImgs;
    private ArrayList<BaseEnemy> enemies = new ArrayList<>();
    private PathPoint start, end;
    private int HPbarWidth = 20;

    public EnemyController(Playing playing, PathPoint start, PathPoint end) {
        this.playing = playing;
        enemyImgs = new BufferedImage[4];
        this.start = start;
        this.end = end;

        loadEnemyImgs();
    }

    private void loadEnemyImgs() {
        BufferedImage atlas = SpriteHelper.getSpriteAtlas();
        for(int i = 0; i < 4; ++i) {
            this.enemyImgs[i] = atlas.getSubimage((10 + i) * 32, 0, 32, 32);
        }
    }

    public void update() {
        for (BaseEnemy e : enemies)
            if (e.isAlive())
                updateEnemyMove(e);
    }

    public void updateEnemyMove(BaseEnemy e) {
        if (e.getLastDir() == -1)
            setNewDirectionAndMove(e);

        int newX = (int) (e.getX() + getSpeedAndWidth(e.getLastDir(), e.getEnemyType()));
        int newY = (int) (e.getY() + getSpeedAndHeight(e.getLastDir(), e.getEnemyType()));

        if (getTileType(newX, newY) == ROAD_TILE) {
            e.move(GetSpeed(e.getEnemyType()), e.getLastDir());
        } else if (isAtEnd(e)) {
            e.reachedEnd();
            playing.removeLife();
        } else {
            setNewDirectionAndMove(e);
        }
    }

    private void setNewDirectionAndMove(BaseEnemy e) {
        int dir = e.getLastDir();

        int xCord = (int) (e.getX() / 32);
        int yCord = (int) (e.getY() / 32);

        fixEnemyOffsetTile(e, dir, xCord, yCord);

        if (isAtEnd(e))
            return;

        if (dir == LEFT || dir == RIGHT) {
            int newY = (int) (e.getY() + getSpeedAndHeight(UP, e.getEnemyType()));
            if (getTileType((int) e.getX(), newY) == ROAD_TILE)
                e.move(GetSpeed(e.getEnemyType()), UP);
            else
                e.move(GetSpeed(e.getEnemyType()), DOWN);
        } else {
            int newX = (int) (e.getX() + getSpeedAndWidth(RIGHT, e.getEnemyType()));
            if (getTileType(newX, (int) e.getY()) == ROAD_TILE)
                e.move(GetSpeed(e.getEnemyType()), RIGHT);
            else
                e.move(GetSpeed(e.getEnemyType()), LEFT);

        }
    }

    public int getAmountOfAliveEnemies() {
        int size = 0;
        for (BaseEnemy e : enemies)
            if (e.isAlive())
                size++;

        return size;
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
        if (e.getX() == end.getxCord() * 32)
            if (e.getY() == end.getyCord() * 32)
                return true;
        return false;
    }

    private int getTileType(int x, int y) {
        return playing.getTileType(x, y);
    }

    private float getSpeedAndHeight(int dir, int enemyType) {
        if (dir == UP)
            return -GetSpeed(enemyType);
        else if (dir == DOWN)
            return GetSpeed(enemyType) + 32;

        return 0;
    }

    private float getSpeedAndWidth(int dir, int enemyType) {
        if (dir == LEFT)
            return -GetSpeed(enemyType);
        else if (dir == RIGHT)
            return GetSpeed(enemyType) + 32;

        return 0;
    }

    public void spawnEnemy(int nextEnemy) {
        addEnemy(nextEnemy);
    }

    public void addEnemy(int enemyType) {
        int x = this.start.getxCord() * 32;
        int y = this.start.getyCord() * 32;
        switch (enemyType) {
            case 0:
                this.enemies.add(new Slime(x, y, 0));
                break;
            case 1:
                this.enemies.add(new Bat(x, y, 0));
                break;
            case 2:
                this.enemies.add(new Snake(x, y, 0));
                break;
            case 3:
                this.enemies.add(new Turtle(x, y, 0));
        }

    }

    public void draw(Graphics g) {
        for (BaseEnemy e : enemies) {
            if (e.isAlive()) {
                drawEnemy(e, g);
                drawHealthBar(e, g);
            }
        }
    }


    private void drawHealthBar(BaseEnemy e, Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) e.getX() + 16 - (getNewBarWidth(e) / 2), (int) e.getY() - 10, getNewBarWidth(e), 3);
    }

    private int getNewBarWidth(BaseEnemy e) {
        return (int) (HPbarWidth * e.getHealthBarFloat());
    }


    private void drawEnemy(BaseEnemy e, Graphics g) {
        g.drawImage(this.enemyImgs[e.getEnemyType()], (int)e.getX(), (int)e.getY(), null);
    }

    public ArrayList<BaseEnemy> getEnemies() {
        return enemies;
    }

    public void reset() {
        enemies.clear();
    }
}
