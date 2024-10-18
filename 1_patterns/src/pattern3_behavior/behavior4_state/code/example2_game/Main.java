package pattern3_behavior.behavior4_state.code.example2_game;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println("Initial State: " + player.getStateName());

        player.pressRun();
        System.out.println("Current State: " + player.getStateName());

        player.pressJump();
        System.out.println("Current State: " + player.getStateName());

        player.pressRun(); // Попытка бегать во время прыжка
        System.out.println("Current State: " + player.getStateName());

        player.pressStop();
        System.out.println("Current State: " + player.getStateName());

        player.pressStop(); // Попытка остановиться, когда уже стоишь
    }
}
