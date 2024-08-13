package maps;

import objects.TileType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapTile {
    public boolean filled;
    public TileType type;
    public Color background;

    private BufferedImage sprite;
    private int id;
    private String name;


    public MapTile(BufferedImage sprite, int id, String name) {
        this.sprite = sprite;
        this.id = id;
        this.name = name;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public MapTile(TileType type) {
//        switch (type) {
//            case ENVIRONMENT -> background = Color.white;
//            case PATH -> background = Color.black;
//        }
//    }
}
