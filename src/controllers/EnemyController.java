package controllers;

import enemies.BaseEnemy;
import helper.SpriteHelper;
import scenes.Playing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class EnemyController {

    private Playing playing;
    private BufferedImage[] enemyImages;
    private BaseEnemy testEnemy;
    private ArrayList<BaseEnemy> enemies = new ArrayList<>();

    public EnemyController(Playing playing) {
        this.playing = playing;

        //How many enemies on sprite sheet
        enemyImages = new BufferedImage[4];
        addEnemy(3*32, 9*32);
        loadEnemyImages();
    }

    private void loadEnemyImages() {
        BufferedImage spriteSheet = SpriteHelper.getSpriteAtlas();
        enemyImages[0] = spriteSheet.getSubimage(0, 32, 32, 32);
        enemyImages[1] = spriteSheet.getSubimage(32, 32, 32, 32);
        enemyImages[2] = spriteSheet.getSubimage(2 * 32, 32, 32, 32);
        enemyImages[3] = spriteSheet.getSubimage(3 * 32, 32, 32, 32);
    }

    public void update() {
        for (BaseEnemy e : enemies) {
            e.move(0.5f, 0);
        }
    }

    public void addEnemy(int x, int y) {
        enemies.add(new BaseEnemy( x, y, 0, 0));
    }

    public void draw(Graphics g) {
        for (BaseEnemy e : enemies) {
            drawEnemy(e, g);
        }
    }

    private void drawEnemy(BaseEnemy enemy, Graphics g) {
        g.drawImage(enemyImages[0], (int) enemy.getX(), (int) enemy.getY(), null);
    }
}
