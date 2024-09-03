package towerDefense.helper;

import com.sun.tools.javac.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SpriteHelper {
    public static BufferedImage getSpriteAtlas() {
        BufferedImage img = null;
//        InputStream is = SpriteHelper.class.getClassLoader().getResourceAsStream("src/main/java/towerDefense/res/spriteatlas.png");
        InputStream is = SpriteHelper.class.getResourceAsStream("/spritesheet/spriteatlas.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
