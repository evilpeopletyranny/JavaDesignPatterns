package pattern3_behavior.behavior4_state.code.example2_game;

public class JumpingState implements State {
    @Override
    public void pressRun(Player player) {
        System.out.println("Player cannot run while jumping.");
    }

    @Override
    public void pressJump(Player player) {
        System.out.println("Player is already jumping.");
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Player lands and stands.");
        player.setState(new StandingState());
    }
}
