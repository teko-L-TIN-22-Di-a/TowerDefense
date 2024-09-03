package towerDefense.controllers;

import towerDefense.towers.Card;

import java.util.ArrayList;
import java.util.Random;

public class CardController {
    public Card ARROW, CANNON, FREEZE, MELEE;
    public ArrayList<Card> cardList = new ArrayList<>();
    public ArrayList<Card> cardHand = new ArrayList<>();

    public CardController() {
        initCards();
        createHand();
    }

    private void initCards() {
        cardList.add(new Card("1", 1));
        cardList.add(new Card("2", 1));
        cardList.add(new Card("3", 1));
        cardList.add(new Card("4", 1));
        cardList.add(new Card("5", 1));
        cardList.add(new Card("6", 1));
        cardList.add(new Card("7", 1));
        cardList.add(new Card("8", 1));
        cardList.add(new Card("9", 1));
        cardList.add(new Card("10", 1));
    }

    public void createHand() {
        cardHand = new ArrayList<>();
        Random random = new Random();
        for(int x = 0; x <= 3; x++) {
            cardHand.add(cardList.get(random.nextInt(9)));
        }
    }
}
