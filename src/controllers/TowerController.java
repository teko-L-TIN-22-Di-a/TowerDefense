package controllers;

import helper.SpriteHelper;


import scenes.Playing;
import towers.BaseTower;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TowerController {
    private Playing playing;
    private BufferedImage[] towerImgs;
    private ArrayList<BaseTower> towers = new ArrayList<>();
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

    public BufferedImage[] getTowerImgs() {
        return towerImgs;
    }
}
