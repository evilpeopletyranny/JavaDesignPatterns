package pattern3_behavior.behavior5_memento.code.example2_game_state;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameSaveManager saveManager = new GameSaveManager();

        game.movePlayer(10);
        game.addScore(50);
        saveManager.saveState(game);

        game.movePlayer(20);
        game.addScore(30);
        saveManager.saveState(game);

        game.movePlayer(30);
        game.addScore(20);
        System.out.println("Current Game State: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nRestoring to last saved state:");
        saveManager.restoreState(game);
        System.out.println("Game State after restoration: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nRestoring to previous saved state:");
        saveManager.restoreState(game);
        System.out.println("Game State after restoration: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nAttempting to restore beyond history:");
        saveManager.restoreState(game);
    }
}
