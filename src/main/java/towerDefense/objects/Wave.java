package towerDefense.objects;

import java.util.ArrayList;

public class Wave {
    private ArrayList<Integer> enemyList;

    //List of enemyTypes
    public Wave(ArrayList<Integer> enemyList) {
        this.enemyList = enemyList;
    }

    public ArrayList<Integer> getEnemyList() {
        return enemyList;
    }

}
