package towerDefense.controllers;

import towerDefense.towers.Card;

import java.util.ArrayList;
import java.util.Random;

public class CardController {
    public int[] cardHand = new int[4];

    public CardController() {
        createHand();
    }

    public void createHand() {
        Random random = new Random();
        for (int x = 0; x <= 3; x++) {
            cardHand[x] = random.nextInt(5);
        }
    }
}
