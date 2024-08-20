package ui;

import maps.MapTile;
import scenes.Playing;
import towers.Card;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BottomBar {
    private int x, y, width, height;

    private ArrayList<CustomButton> cardButtonList = new ArrayList<>();
    private CustomButton bDraw;
    private Playing playing;
    private MapTile selectedTile;

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
        int id = 0;

        for (Card card : playing.getCardController().cardHand) {
            cardButtonList.add(new CustomButton(card.getLabel(), x + cardOffset, 490, 100, 135, id));
            x = x + 100 + cardOffset;
            id++;
        }
    }

    private void drawButtons(Graphics g) {
        bDraw.draw(g);
        drawCardButtons(g);
        drawSelectedTower(g);

    }

    private void drawSelectedTower(Graphics g) {
        if (selectedTile != null) {
            g.drawImage(selectedTile.getSprite(), 500, 500, 50, 50, null);
        }
    }

    private void drawCardButtons(Graphics g) {
        for (CustomButton button : cardButtonList) {
            g.setColor(Color.gray);
            g.fillRect(button.x, button.y, button.width, button.height);

            g.drawImage(playing.getTowerController().getTowerImgs()[button.getId()], button.x, button.y, button.width, button.height, null);

            if (button.isMouseOver()) {
                g.setColor(Color.white);
            } else {
                g.setColor(Color.black);
            }

            g.drawRect(button.x, button.y, button.width, button.height);

            if (button.isMousePressed()) {
                g.drawRect(button.x + 1, button.y + 1, button.width - 2, button.height - 2);
                g.drawRect(button.x + 2, button.y + 2, button.width - 4, button.height - 4);
            }
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
        } else {
            for (CustomButton button : cardButtonList) {
                if (button.getBounds().contains(x, y)) {
                    selectedTile = playing.getTileController().getTile(button.id);
                    playing.setSelectedTile(selectedTile);
                    return;
                }
            }
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
