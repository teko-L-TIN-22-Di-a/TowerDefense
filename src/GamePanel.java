import maps.MapTile;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

public class GamePanel extends JPanel {
    Random random;
    MapTile[][] mapGrid = new MapTile[20][15];

    public GamePanel() {
        random = new Random();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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
                    g.setColor(getRndColor());
                }
                previousY = posY;
            } else if (previousY > posY) {
                for (int currY = previousY; currY >= posY; currY--) {
                    g.fillRect(x * 32, currY * 32, 32, 32);
                    g.setColor(getRndColor());
                }
                previousY = posY;
            } else {
                g.fillRect(x * 32, posY * 32, 32, 32);
                g.setColor(getRndColor());
            }


            if (x == lengthX) {
                posY = random.nextInt(15);
                lengthX = random.nextInt(x, x + 4);
            }
        }
    }

    private Color getRndColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }
}
