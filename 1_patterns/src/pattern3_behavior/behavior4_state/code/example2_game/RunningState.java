package pattern3_behavior.behavior4_state.code.example2_game;

public class RunningState implements State {
    @Override
    public void pressRun(Player player) {
        System.out.println("Player is already running.");
    }

    @Override
    public void pressJump(Player player) {
        System.out.println("Player jumps while running.");
        player.setState(new JumpingState());
    }

    @Override
    public void pressStop(Player player) {
        System.out.println("Player stops running.");
        player.setState(new StandingState());
    }
}
