package towerDefense.ui;

import towerDefense.controllers.CardController;
import towerDefense.helper.Constants;
import towerDefense.maps.MapTile;
import towerDefense.scenes.Playing;
import towerDefense.towers.BaseTower;
import towerDefense.towers.Card;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static towerDefense.GameStates.GAME_OVER;
import static towerDefense.GameStates.SetGameState;

public class BottomBar {
    private int x, y, width, height;

    private ArrayList<CustomButton> cardButtonList = new ArrayList<>();
    private CustomButton bDraw;
    private Playing playing;
    private BaseTower selectedTower;
    private BaseTower infoBoxTower;
    private DecimalFormat formatter;
    private int lives = 25;
    private int gold = 100;

    public BottomBar(int x, int y, int width, int height, Playing playing) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.playing = playing;
        formatter = new DecimalFormat("0.0");

        initButtons();
    }

    public void removeLife() {
        lives--;
        if (lives <= 0) {
            SetGameState(GAME_OVER);
        }
    }

    private void initButtons() {
        bDraw = new CustomButton("Draw", 2, 490, 80, 40);

        drawHand();
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, width, height);

        drawButtons(g);

        // Wave info
        drawWaveInfo(g);

        // Lives
        g.setColor(Color.black);
        g.drawString("Lives: " + lives, 425, 550);
    }

    private void drawWaveInfo(Graphics g) {
        g.setColor(Color.black);
        g.setFont(new Font("LucidaSans", Font.BOLD, 20));
        drawWaveTimerInfo(g);
        drawDrawTimerInfo(g);
        drawEnemiesLeftInfo(g);
        drawWavesLeftInfo(g);
    }

    private void drawWavesLeftInfo(Graphics g) {
        int current = playing.getWaveController().getWaveIndex();
        int size = playing.getWaveController().getWaves().size();
        g.drawString("Wave " + (current + 1) + " / " + size, 425, 510);

    }

    private void drawEnemiesLeftInfo(Graphics g) {
        int remaining = playing.getEnemyController().getAmountOfAliveEnemies();
        g.drawString("Enemies Left: " + remaining, 425, 530);
    }

    private void drawWaveTimerInfo(Graphics g) {
        if (playing.getWaveController().isWaveTimerStarted()) {

            float timeLeft = playing.getWaveController().getTimeLeft();
            String formattedText = formatter.format(timeLeft);
            g.drawString("Time Left: " + formattedText, 425, 570);
        }
    }

    private void drawDrawTimerInfo(Graphics g) {
        if (playing.getCardController().isDrawTimerStarted()) {
            float timeLeft = playing.getCardController().getDrawTimeLeft();
            String formattedText = formatter.format(timeLeft);
            g.drawString("Draw Time Left: " + formattedText, 2, 570);
        } else {
            bDraw.setDisabled(false);
        }
    }

    private void drawHand() {
        int cardOffset = 20;
        int x = 100;
        cardButtonList = new ArrayList<>();
        int cardIndex = 0;

        for (int cardId : playing.getCardController().cardHand) {
            cardButtonList.add(new CustomButton("", x + cardOffset, 490, 50, 50, cardId, cardIndex));
            x = x + 50 + cardOffset;
            cardIndex++;
        }

        playing.getCardController().startDrawTimer();
        bDraw.setDisabled(true);
    }

    private void drawButtons(Graphics g) {
        bDraw.draw(g);
        drawCardButtons(g);
        drawInfoBoxTowerTower(g);
    }

    public void resetEverything() {
        lives = 25;
        selectedTower = null;
        infoBoxTower = null;
    }

    private void drawInfoBoxTowerTower(Graphics g) {
        if (this.infoBoxTower != null) {
            g.setColor(Color.gray);
            g.fillRect(2, 540, 140, 85);
            g.setColor(Color.black);
            g.drawRect(2, 540, 140, 85);
            g.drawRect(12, 545, 40, 40);
            g.drawImage(this.playing.getTowerController().getTowerImgs()[this.infoBoxTower.getTowerType()], 12, 545, 40, 40, (ImageObserver) null);
            g.setFont(new Font("LucidaSans", 1, 15));
            g.drawString(Constants.Towers.GetName(this.infoBoxTower.getTowerType()), 72, 560);
            g.drawString("ID: " + this.infoBoxTower.getId(), 72, 575);
            drawInfoBoxTowerBorder(g);
            drawInfoBoxTowerRange(g);
        }
    }

    private void drawInfoBoxTowerBorder(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawRect(this.infoBoxTower.getX(), this.infoBoxTower.getY(), 32, 32);
    }

    private void drawInfoBoxTowerRange(Graphics g) {
        g.setColor(Color.white);
        g.drawOval(
                infoBoxTower.getX() + 16 - (int) (infoBoxTower.getRange() * 2) / 2,
                infoBoxTower.getY() + 16 - (int) (infoBoxTower.getRange() * 2) / 2,
                (int) infoBoxTower.getRange() * 2,
                (int) infoBoxTower.getRange() * 2);

    }

    private void drawCardButtons(Graphics g) {
        for (CustomButton button : cardButtonList) {
            g.setColor(Color.gray);
            g.fillRect(button.x, button.y, button.width, button.height);


            if(button.getDisabled() == false) {
                g.drawImage(playing.getTowerController().getTowerImgs()[button.getTowerId()], button.x, button.y, button.width, button.height, null);
            }

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

    public void displayTower(BaseTower t) {
        this.infoBoxTower = t;
    }

    public void setTowerButtonDisabled(BaseTower t) {
        cardButtonList.stream().filter(x -> x.id == t.getCardIndex()).findFirst().get().setDisabled(true);
    }

    public void mouseClicked(int x, int y) {
        if (bDraw.getBounds().contains(x, y) && playing.getCardController().getDrawEnabled()) {
            playing.getCardController().createHand();
            drawHand();
        } else {
            for (CustomButton button : cardButtonList) {
                if (button.getBounds().contains(x, y) && button.getDisabled() == false) {
                    selectedTower = new BaseTower(0, 0, -1, button.getTowerId(), button.id);
                    playing.setSelectedTower(selectedTower);
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
