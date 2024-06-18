package controllers;

import maps.MapTile;
import objects.TileType;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class MapController {

    public MapController() {
    }

    public static MapTile[][] createLevel() {
        MapTile[][] mapGrid = new MapTile[20][15];
        Random random = new Random();
        Color pathColor = new Color(0, 0, 0);

        Arrays.stream(mapGrid).forEach(a -> Arrays.fill(a, new MapTile(TileType.ENVIRONMENT)));

        var posY = random.nextInt(15);
        var previousY = posY;
        var lengthX = random.nextInt(2, 4);
        //map gen
        for (int x = 0; x < 20; x++) {
            mapGrid[x][posY].filled = true;

            if (previousY < posY) {
                for (int currY = previousY; currY <= posY; currY++) {
                    mapGrid[x][currY] = new MapTile(TileType.PATH);
                }
                previousY = posY;
            } else if (previousY > posY) {
                for (int currY = previousY; currY >= posY; currY--) {
                    mapGrid[x][currY] = new MapTile(TileType.PATH);
                }
                previousY = posY;
            } else {
                mapGrid[x][posY] = new MapTile(TileType.PATH);
            }

            if (x == lengthX) {
                while (posY == previousY) {
                    posY = random.nextInt(15);
                }
                lengthX = random.nextInt(x + 2, x + 4);
            }
        }

        return mapGrid;
    }
}
