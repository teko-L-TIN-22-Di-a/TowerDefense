package main;

import maps.MapTile;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Render {
    MapTile[][] mapGrid = new MapTile[20][15];
    private Game game;
    Random random;
    Color pathColor = new Color(0, 0, 0);

    public Render(Game game) {
        this.game = game;
        random = new Random();

    };

    public void Render(Graphics g) {
        switch(GameStates.gameStates) {
            case MENU:
                game.getMenu().Render(g);
                CreatePath(g);
                break;
            case PLAYING:
                game.getPlaying().Render(g);
                break;
            case SETTINGS:
                game.getSettings().Render(g);
                break;
        }
    }

    private void CreatePath(Graphics g) {
        Arrays.stream(mapGrid).forEach(a -> Arrays.fill(a, new MapTile()));

        var posY = random.nextInt(15);
        var previousY = posY;
        var lengthX = random.nextInt(2, 4);
        //map gen
        for (int x = 0; x < 20; x++) {
            mapGrid[x][posY].filled = true;

            if (previousY < posY) {
                for (int currY = previousY; currY <= posY; currY++) {
                    g.fillRect(x * 32, currY * 32, 32, 32);
                    g.setColor(pathColor);
                }
                previousY = posY;
            } else if (previousY > posY) {
                for (int currY = previousY; currY >= posY; currY--) {
                    g.fillRect(x * 32, currY * 32, 32, 32);
                    g.setColor(pathColor);
                }
                previousY = posY;
            } else {
                g.fillRect(x * 32, posY * 32, 32, 32);
                g.setColor(pathColor);
            }

            if (x == lengthX) {
                while (posY == previousY) {
                    posY = random.nextInt(15);
                }
                lengthX = random.nextInt(x + 2, x + 4);
            }
        }
    }

}