import javax.swing.*;

public class Game extends JFrame {
    private GamePanel gamePanel;

    public Game() {
        setSize(640,640);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gamePanel = new GamePanel();
        add(gamePanel);
    }
    public static void main(String[] args) {
        Game game = new Game();
    }
}