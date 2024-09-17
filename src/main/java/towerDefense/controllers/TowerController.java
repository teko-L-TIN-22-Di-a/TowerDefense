package towerDefense.controllers;

import towerDefense.helper.SpriteHelper;


import towerDefense.scenes.Playing;
import towerDefense.towers.BaseTower;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
        towerImgs = new BufferedImage[4];
        for (int i = 0; i < 3; i++)
            towerImgs[i] = atlas.getSubimage((4 + i) * 32, 32, 32, 32);
    }

    public void addTower(BaseTower selectedTower, int xPos, int yPos) {
        towers.add(new BaseTower(xPos, yPos, towerAmount++, selectedTower.getTowerType()));
    }

    public void update() {

    }

    public void draw(Graphics g) {
        for (BaseTower t : towers)
            g.drawImage(towerImgs[t.getTowerType()], t.getX(), t.getY(), null);
    }

    public BufferedImage[] getTowerImgs() {
        return towerImgs;
    }
}
