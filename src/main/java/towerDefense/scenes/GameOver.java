package towerDefense.scenes;

import towerDefense.Game;
import towerDefense.ui.CustomButton;

import java.awt.*;

import static towerDefense.GameStates.*;

public class GameOver extends GameScene implements SceneMethods {

	private CustomButton bReplay, bMenu;

	public GameOver(Game game) {
		super(game);
		initButtons();
	}

	private void initButtons() {

		int w = 150;
		int h = w / 3;
		int x = 640 / 2 - w / 2;
		int y = 150;
		int yOffset = 100;

		bMenu = new CustomButton("Menu", x, y, w, h);
		bReplay = new CustomButton("Replay", x, y + yOffset, w, h);

	}

	@Override
	public void Render(Graphics g) {
		// game over text
		g.setFont(new Font("LucidaSans", Font.BOLD, 50));
		g.setColor(Color.red);
		g.drawString("Game Over!", 160, 80);

		// buttons
		g.setFont(new Font("LucidaSans", Font.BOLD, 20));
		bMenu.draw(g);
		bReplay.draw(g);
	}

	private void replayGame() {
		// reset everything
		resetAll();

		// change state to playing
		SetGameState(PLAYING);

	}

	private void resetAll() {
		game.getPlaying().resetEverything();
	}

	@Override
	public void mouseClicked(int x, int y) {
		if (bMenu.getBounds().contains(x, y)) {
			SetGameState(MENU);
			resetAll();
		} else if (bReplay.getBounds().contains(x, y))
			replayGame();
	}

	@Override
	public void mouseMoved(int x, int y) {
		bMenu.setMouseHover(false);
		bReplay.setMouseHover(false);

		if (bMenu.getBounds().contains(x, y))
			bMenu.setMouseHover(true);
		else if (bReplay.getBounds().contains(x, y))
			bReplay.setMouseHover(true);
	}

	@Override
	public void mousePressed(int x, int y) {
		if (bMenu.getBounds().contains(x, y))
			bMenu.setMousePressed(true);
		else if (bReplay.getBounds().contains(x, y))
			bReplay.setMousePressed(true);

	}

	@Override
	public void mouseReleased(int x, int y) {
		bMenu.resetStates();
		bReplay.resetStates();

	}

	@Override
	public void mouseDragged(int x, int y) {
		// TODO Auto-generated method stub

	}

}
