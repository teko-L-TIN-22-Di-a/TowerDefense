package towerDefense.controllers;

import towerDefense.helper.SpriteHelper;
import towerDefense.maps.MapTile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static towerDefense.helper.Constants.Tiles.*;

public class TileController {
    public MapTile GRASS, ROAD;
    public BufferedImage atlas;
    public ArrayList<MapTile> tileList = new ArrayList<>();

    public TileController() {
        loadAtlas();
        loadTiles();
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        tileList.add(GRASS = new MapTile(getSprite(2, 0), id++, GRASS_TILE));
        tileList.add(ROAD = new MapTile(getSprite(3, 0), id++, ROAD_TILE));
    }

    private void loadTiles() {
    }

    private void loadAtlas() {
        atlas = SpriteHelper.getSpriteAtlas();

    }

    public MapTile getTile(int id) {
        return tileList.get(id);
    }

    public BufferedImage getSprite(int id) {
        return tileList.get(id).getSprite();
    }

    private BufferedImage getSprite(int xCord, int yCord) {
        return atlas.getSubimage(xCord * 32, yCord * 32, 32, 32);
    }
}
