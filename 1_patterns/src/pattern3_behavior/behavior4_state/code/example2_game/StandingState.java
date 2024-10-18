package pattern3_behavior.behavior4_state.code.example2_game;

public class StandingState implements State {
    @Override
    public void pressRun(Player player) {
        System.out.println("Player starts running.");
        player.setState(new RunningState());
    }

    @Override
    public void pressJump(Player player) {
        System.out.println("Player jumps.");
        player.setState(new JumpingState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Player is already standing.");
    }
}
