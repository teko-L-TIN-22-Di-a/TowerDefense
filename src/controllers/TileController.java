package controllers;

import helper.SpriteHelper;
import maps.MapTile;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class TileController {
    public MapTile GRASS, WATER, ROAD_X, ROAD_Y;
    public BufferedImage  atlas;
    public ArrayList<MapTile> tileList = new ArrayList<>();

    public TileController() {
        loadAtlas();
        loadTiles();
        createTiles();
    }

    private void createTiles() {
        int id = 0;
        tileList.add(GRASS = new MapTile(getSprite(9, 0), id++, "Grass"));
        tileList.add(WATER = new MapTile(getSprite(0, 0), id++, "Water"));
        tileList.add(ROAD_X = new MapTile(getSprite(8, 0), id++, "RoadX"));
        tileList.add(ROAD_Y = new MapTile(getSprite(7, 0), id++, "RoadY"));
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
