package pattern3_behavior.behavior4_state.code.example2_game;

public interface State {
    void pressRun(Player player);
    void pressJump(Player player);
    void pressStop(Player player);
}
