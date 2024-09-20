package towerDefense.enemies;

import towerDefense.helper.Constants;

import java.awt.*;

import static towerDefense.helper.Constants.Direction.*;

public class BaseEnemy {

    protected float x, y;
    protected Rectangle bounds;
    protected int health;
    protected int maxHealth;
    protected int Id;
    protected int enemyType;
    protected int lastDir;
    protected boolean alive = true;
    protected int slowTickLimit = 120;
    protected int slowTick = slowTickLimit;

    public BaseEnemy(float x, float y, int id, int enemyType) {
        this.x = x;
        this.y = y;
        this.Id = Id;
        this.enemyType = enemyType;
        bounds = new Rectangle((int) x, (int) y, 32, 32);
        lastDir = RIGHT;
        setStartHealth();
    }

    private void setStartHealth() {
        health =  Constants.Enemies.GetStartHealth(enemyType);
        maxHealth = health;
    }

    public void hurt(int dmg) {
        this.health -= dmg;
        if (health <= 0)
            alive = false;
    }

    public void reachedEnd() {
        alive = false;
        health = 0;
    }

    public float getHealthBarFloat() {
        return health / (float) maxHealth;
    }

    public void move(float speed, int dir) {
        lastDir = dir;

        if (slowTick < slowTickLimit) {
            slowTick++;
            speed *= 0.5f;
        }

        switch (dir) {
            case LEFT:
                this.x -= speed;
                break;
            case UP:
                this.y -= speed;
                break;
            case RIGHT:
                this.x += speed;
                break;
            case DOWN:
                this.y += speed;
                break;
        }
        updateHitbox();
    }

    public void slow() {
        slowTick = 0;
    }

    private void updateHitbox() {
        bounds.x = (int) x;
        bounds.y = (int) y;
    }
    
    public void setPos(int x, int y) {
        // Don't use this one for moving the enemy.
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getHealth() {
        return health;
    }

    public int getId() {
        return Id;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public int getLastDir() {
        return lastDir;
    }

    public boolean isAlive() {
        return alive;
    }
}
