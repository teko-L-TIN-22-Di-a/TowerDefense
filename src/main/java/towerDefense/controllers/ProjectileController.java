package towerDefense.controllers;

import towerDefense.enemies.BaseEnemy;
import towerDefense.helper.Constants;
import towerDefense.objects.Projectile;
import towerDefense.scenes.Playing;
import towerDefense.towers.BaseTower;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static towerDefense.helper.Constants.Projectiles.*;
import static towerDefense.helper.Constants.Towers.*;
import static towerDefense.helper.SpriteHelper.getSpriteAtlas;

public class ProjectileController {
    private Playing playing;
    private ArrayList<Projectile> projectiles = new ArrayList<>();
    private BufferedImage[] proj_imgs;
    private int proj_id = 0;

    public ProjectileController(Playing playing) {
        this.playing = playing;
        importImgs();
    }

    private void importImgs() {
        BufferedImage atlas = getSpriteAtlas();
        proj_imgs = new BufferedImage[5];

        for (int i = 0; i < 5; i++)
            proj_imgs[i] = atlas.getSubimage((14 + i) * 32, 0, 32, 32);
    }

    public void newProjectile(BaseTower t, BaseEnemy e) {
        int type = getProjType(t);

        int xDist = (int) (t.getX() - e.getX());
        int yDist = (int) (t.getY() - e.getY());
        int totDist = Math.abs(xDist) + Math.abs(yDist);

        float xPer = (float) Math.abs(xDist) / totDist;

        float xSpeed = xPer * Constants.Projectiles.GetSpeed(type);
        float ySpeed = Constants.Projectiles.GetSpeed(type) - xSpeed;

        if (t.getX() > e.getX())
            xSpeed *= -1;
        if (t.getY() > e.getY())
            ySpeed *= -1;

        float arcValue = (float) Math.atan(yDist / (float) xDist);
        float rotate = (float) Math.toDegrees(arcValue);

        if (xDist < 0)
            rotate += 180;

        projectiles.add(new Projectile(t.getX() + 16, t.getY() + 16, xSpeed, ySpeed, t.getDmg(), rotate, proj_id++, type));

    }

    public void update() {
        for (Projectile p : projectiles)
            if (p.isActive()) {
                p.move();
                if (isProjectileHittingEnemy(p)) {
                    p.setActive(false);
                    if (p.getProjectileType() == BOMB) {
                        explodeOnEnemies(p);
                    }
                } else if (isProjectileOutsideBounds(p)) {
                    p.setActive(false);
                }
            }

    }

    private void explodeOnEnemies(Projectile p) {
        for (BaseEnemy e : playing.getEnemyController().getEnemies()) {
            if (e.isAlive()) {
                float radius = 40.0f;

                float xDist = Math.abs(p.getPos().x - e.getX());
                float yDist = Math.abs(p.getPos().y - e.getY());

                float realDist = (float) Math.hypot(xDist, yDist);

                if (realDist <= radius)
                    e.hurt(p.getDmg());
            }
        }
    }

    private boolean isProjectileHittingEnemy(Projectile p) {
        for (BaseEnemy e : playing.getEnemyController().getEnemies()) {
            if (e.isAlive())
                if (e.getBounds().contains(p.getPos())) {
                    e.hurt(p.getDmg());
                    if (p.getProjectileType() == CHAINS)
                        e.slow();

                    return true;
                }
        }
        return false;
    }

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        for (Projectile p : projectiles)
            if (p.isActive()) {
                g2d.translate(p.getPos().x, p.getPos().y);
                g2d.rotate(Math.toRadians(p.getRotation()));
                g2d.drawImage(proj_imgs[p.getProjectileType()], -16, -16, null);
                g2d.rotate(-Math.toRadians(p.getRotation()));
                g2d.translate(-p.getPos().x, -p.getPos().y);
            }
    }

    private boolean isProjectileOutsideBounds(Projectile p) {
        if (p.getPos().x >= 0)
            if (p.getPos().x <= 640)
                if (p.getPos().y >= 0)
                    if (p.getPos().y <= 640)
                        return false;
        return true;
    }

    private int getProjType(BaseTower t) {
        switch (t.getTowerType()) {
            case ARCHER:
                return ARROW;
            case CANNON:
                return BOMB;
            case WIZARD:
                return CHAINS;
        }
        return 0;
    }

    public void reset() {
        projectiles.clear();

        proj_id = 0;
    }
}
