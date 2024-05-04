package DocVers.synchronization;

public class NoRace {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            final int j = i;
            new Thread(()-> System.out.println(j)).start();
        }
    }
}
