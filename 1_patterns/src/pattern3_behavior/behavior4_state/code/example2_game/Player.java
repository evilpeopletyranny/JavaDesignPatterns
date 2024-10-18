package pattern3_behavior.behavior4_state.code.example2_game;

public class Player {
    private State currentState;

    public Player() {
        // Начальное состояние — стоя
        currentState = new StandingState();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    // Делегирование действий текущему состоянию
    public void pressRun() {
        currentState.pressRun(this);
    }

    public void pressJump() {
        currentState.pressJump(this);
    }

    public void pressStop() {
        currentState.pressStop(this);
    }

    public String getStateName() {
        return currentState.getClass().getSimpleName();
    }
}
