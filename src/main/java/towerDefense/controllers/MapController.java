package towerDefense.controllers;

import objects.PathPoint;
import towerDefense.maps.MapTile;

import java.util.Arrays;
import java.util.Random;

public class MapController {

    public static objects.PathPoint startTile, endTile;

    public MapController() {
    }

    public static MapTile[][] createLevel(TileController tileController) {
        MapTile[][] mapGrid = new MapTile[20][15];
        Random random = new Random();
//        Color pathColor = new Color(0, 0, 0);

        Arrays.stream(mapGrid).forEach(a -> {
            Arrays.fill(a, tileController.getTile(0));
        });

        var posY = random.nextInt(1, 14);
        startTile = new objects.PathPoint(0, posY);
        var previousY = posY;
        var lengthX = random.nextInt(2, 4);
        //map gen
        for (int x = 0; x < 20; x++) {

            //Draw path
            if (previousY < posY) {
                for (int currY = previousY; currY <= posY; currY++) {
                    mapGrid[x][currY] = tileController.getTile(1);
                }
                previousY = posY;
            } else if (previousY > posY) {
                for (int currY = previousY; currY >= posY; currY--) {
                    mapGrid[x][currY] = tileController.getTile(1);
                }
                previousY = posY;
            } else {
                mapGrid[x][posY] = tileController.getTile(1);
            }

            if (x == lengthX) {
                while (posY == previousY) {
                    posY = random.nextInt(1, 14);
                }
                lengthX = random.nextInt(x + 2, x + 4);
            }

            if (x == 19) {
                endTile = new objects.PathPoint(19, previousY);
            }
        }

        return mapGrid;
    }

    public static PathPoint getStartTile() {
        return startTile;
    }

    public static PathPoint getEndTile() {
        return endTile;
    }
}
