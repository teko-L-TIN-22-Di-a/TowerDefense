package towerDefense;

public enum GameStates {
    PLAYING, MENU, GAME_OVER;

    public static GameStates gameState = MENU;

    public static void SetGameState(GameStates state) {
        gameState = state;
    }
}
