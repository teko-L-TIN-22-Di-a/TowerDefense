package towerDefense.controllers;

import towerDefense.enemies.BaseEnemy;
import towerDefense.helper.SpriteHelper;


import towerDefense.helper.Utilities;
import towerDefense.scenes.Playing;
import towerDefense.towers.BaseTower;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import static towerDefense.helper.Constants.Towers.ARCHER;

public class TowerController {
    private Playing playing;
    private BufferedImage[] towerImgs;
    private ArrayList<BaseTower> towers = new ArrayList();
    private int towerAmount = 0;

    public TowerController(Playing playing) {
        this.playing = playing;
        loadTowerImgs();
    }

    private void loadTowerImgs() {
        BufferedImage atlas = SpriteHelper.getSpriteAtlas();
        towerImgs = new BufferedImage[5];
        for (int i = 0; i < 5; i++)
            towerImgs[i] = atlas.getSubimage((5 + i) * 32, 0, 32, 32);
    }

    public void addTower(BaseTower selectedTower, int xPos, int yPos) {
        towers.add(new BaseTower(xPos, yPos, towerAmount++, selectedTower.getTowerType()));
    }

    public void update() {
        for (BaseTower t : towers) {
            t.update();
            attackEnemyIfInRange(t);
        }
    }

    private void attackEnemyIfInRange(BaseTower t) {
        for (BaseEnemy e : playing.getEnemyController().getEnemies()) {
            if (e.isAlive())
                if (isEnemyInRange(t, e)) {
                    if (t.isCooldownOver()) {
                        playing.shootEnemy(t, e);
                        t.resetCooldown();
                    }
                }
        }
    }

    private boolean isEnemyInRange(BaseTower t, BaseEnemy e) {
        int range = Utilities.GetHypoDistance(t.getX(), t.getY(), e.getX(), e.getY());
        return range < t.getRange();
    }

    public void draw(Graphics g) {
        for (BaseTower t : towers)
            g.drawImage(towerImgs[t.getTowerType()], t.getX(), t.getY(), null);
    }

    public BaseTower getTowerAt(int x, int y) {
        Iterator iterator = this.towers.iterator();

        BaseTower t;
        do {
            if (!iterator.hasNext()) {
                return null;
            }

            t = (BaseTower) iterator.next();
        } while (t.getX() != x || t.getY() != y);

        return t;
    }

    public BufferedImage[] getTowerImgs() {
        return towerImgs;
    }
}
