package main;

import maps.MapTile;

import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class Render {
    private Game game;


    public Render(Game game) {
        this.game = game;
    };

    public void Render(Graphics g) {
        switch(GameStates.gameState) {
            case MENU:
                game.getMenu().Render(g);
                break;
            case PLAYING:
                game.getPlaying().Render(g);
                break;
            case SETTINGS:
                game.getSettings().Render(g);
                break;
        }
    }


}
