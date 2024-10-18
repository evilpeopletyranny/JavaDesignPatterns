package pattern3_behavior.behavior5_memento.code.example2_game_state;

// Класс - игра, состояние которой мсы будем сохранять
public class Game {
    protected int playerPosition;
    protected int score;

    public void movePlayer(int newPosition) {
        playerPosition = newPosition;
        System.out.println("Player moved to position: " + playerPosition);
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Score increased by " + points + ". Current score: " + score);
    }

    public GameState save() {
        System.out.println("Saving game state: Position=" + playerPosition + ", Score=" + score);
        return new GameState(playerPosition, score);
    }

    public void restore(GameState state) {
        playerPosition = state.getPlayerPosition();
        score = state.getScore();
        System.out.println("Game state restored: Position=" + playerPosition + ", Score=" + score);
    }
}
