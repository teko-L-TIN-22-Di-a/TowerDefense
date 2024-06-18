package controllers;

import maps.MapTile;

import java.util.ArrayList;

public class TileController {
    public MapTile PATH, ENVIRONMENT;
    public ArrayList<MapTile> tileList = new ArrayList<>();
    public TileController() {
        loadTiles();
        createTiles();
    }

    private void createTiles() {
    }

    private void loadTiles() {
    }
}
