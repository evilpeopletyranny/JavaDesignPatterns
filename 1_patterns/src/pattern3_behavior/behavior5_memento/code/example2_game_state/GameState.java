package pattern3_behavior.behavior5_memento.code.example2_game_state;

// Снимок состояния игры
public class GameState {
    private final int playerPosition;
    private final int score;

    public GameState(int playerPosition, int score) {
        this.playerPosition = playerPosition;
        this.score = score;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public int getScore() {
        return score;
    }
}
