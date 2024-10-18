package pattern3_behavior.behavior5_memento.code.example2_game_state;

import java.util.ArrayDeque;
import java.util.Deque;

// Класс который управляет состояниями
// История игры
public class GameSaveManager {
    private Deque<GameState> saveStack = new ArrayDeque<>();

    public void saveState(Game game) {
        saveStack.push(game.save());
    }

    public void restoreState(Game game) {
        if (!saveStack.isEmpty()) {
            GameState state = saveStack.pop();
            game.restore(state);
        } else {
            System.out.println("No saved states to restore.");
        }
    }
}
