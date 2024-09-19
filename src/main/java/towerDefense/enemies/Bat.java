package towerDefense.enemies;


import static towerDefense.helper.Constants.Enemies.BAT;

public class Bat extends towerDefense.enemies.BaseEnemy {

	public Bat(float x, float y, int ID) {
		super(x, y, ID, BAT);
		health = 50;
	}

}
