package towerDefense.maps;

import java.awt.image.BufferedImage;

public class MapTile {
    private BufferedImage[] sprite;
    private int id, tileType;


    public MapTile(BufferedImage sprite, int id, int tileType) {
        this.sprite = new BufferedImage[1];
        this.sprite[0] = sprite;
        this.id = id;
        this.tileType = tileType;
    }

    public MapTile(BufferedImage[] sprite, int id, int tileType) {
        this.sprite = sprite;
        this.id = id;
        this.tileType = tileType;
    }

    public int getTileType() {
        return tileType;
    }

    public BufferedImage getSprite() {
        return sprite[0];
    }

    public int getId() {
        return id;
    }
}
