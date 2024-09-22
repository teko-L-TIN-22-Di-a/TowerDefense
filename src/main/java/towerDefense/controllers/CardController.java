package towerDefense.controllers;

import towerDefense.towers.Card;

import java.util.ArrayList;
import java.util.Random;

public class CardController {
    public int[] cardHand = new int[4];
    private int drawTickLimit = 60 * 5;
    private int drawTick = 0;
    private boolean drawStartTimer, drawTickTimerOver, drawEnabled;
    private int drawTimerIndex = 0;

    public CardController() {
        createHand();
    }

    public void update() {
        if (drawStartTimer) {
            drawTick++;
            if (drawTick >= drawTickLimit) {
                drawTickTimerOver = true;
            }
        }
    }

    public void resetDrawTimer() {
        drawTimerIndex++;
        drawTick = 0;
        drawTickTimerOver = false;
        drawStartTimer = false;
        drawEnabled = true;
    }

    public boolean isTimeForNewDraw() {
        return drawTickTimerOver;
    }

    public boolean getDrawEnabled() {
        return drawEnabled;
    }

    public void createHand() {
        Random random = new Random();
        for (int x = 0; x <= 3; x++) {
            cardHand[x] = random.nextInt(5);
        }
    }

    public void startDrawTimer() {
        drawStartTimer = true;
        drawEnabled = false;
    }

    public boolean isDrawTimerStarted() {
        return drawStartTimer;
    }

    public float getDrawTimeLeft() {
        float ticksLeft = drawTickLimit - drawTick;
        return ticksLeft / 60.0f;
    }
}
