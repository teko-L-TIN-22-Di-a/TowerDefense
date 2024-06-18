package ui;

import scenes.Playing;
import towers.Card;

import java.awt.*;
import java.util.ArrayList;

public class BottomBar {
    private int x, y, width, height;

    private ArrayList<CustomButton> cardButtonList = new ArrayList<>();
    private CustomButton bDraw;
    private Playing playing;

    public BottomBar(int x, int y, int width, int height, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;

        initButtons();
    }

    private void initButtons() {
        bDraw = new CustomButton("Draw", 2, 542, 80, 40);

        drawHand();
    }

    private void drawHand() {
        int cardOffset = 20;
        int x = 120;

        for (Card card : playing.getCardController().cardHand) {
            cardButtonList.add(new CustomButton(card.getLabel(), x + cardOffset, 490, 100, 135));
            x = x + 100 + cardOffset;
        }
    }

    private void drawButtons(Graphics g) {
        bDraw.draw(g);
        for (CustomButton button : cardButtonList) {
            button.draw(g);

            if (button.isMouseOver()) {
                g.setColor(Color.white);
            } else {
                g.setColor(Color.black);
            }

            g.drawRect(button.x, button.y, button.width, button.height);
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);

        drawButtons(g);
    }

    public void mouseClicked(int x, int y) {
        if (bDraw.getBounds().contains(x, y)) {
            playing.getCardController().createHand();
            drawHand();
        }
    }

    public void mousePressed(int x, int y) {
        if (bDraw.getBounds().contains(x, y)) {
            bDraw.setMousePressed(true);
        } else {
            for (CustomButton b : cardButtonList) {
                if (b.getBounds().contains(x, y)) {
                    b.setMousePressed(true);
                    return;
                }
            }
        }
    }

    public void mouseMoved(int x, int y) {
        bDraw.setMouseHover(false);
        for (CustomButton b : cardButtonList) {
            b.setMouseHover(false);
        }

        if (bDraw.getBounds().contains(x, y)) {
            bDraw.setMouseHover(true);
        } else {
            for (CustomButton b : cardButtonList) {
                if (b.getBounds().contains(x, y)) {
                    b.setMouseHover(true);
                    return;
                }
            }
        }

    }

    public void mouseReleased(int x, int y) {
        this.bDraw.resetStates();
        for (CustomButton b : cardButtonList) {
            if (b.getBounds().contains(x, y)) {
                b.resetStates();
            }
        }
    }
}
