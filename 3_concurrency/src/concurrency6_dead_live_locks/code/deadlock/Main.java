package concurrency6_dead_live_locks.code.deadlock;

public class Main {
    public static void main(String[] args) {
        final Object resourceA = "Resource A";
        final Object resourceB = "Resource B";

        // Поток 1 пытается захватить ресурс A, затем ресурс B
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("Поток 1 захватил Resource A");
                try {
                    // Задержка для увеличения вероятности Deadlock
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resourceB) {
                    System.out.println("Поток 1 захватил Resource B");
                }
            }
        });

        // Поток 2 пытается захватить ресурс B, затем ресурс A
        Thread thread2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("Поток 2 захватил Resource B");
                try {
                    // Задержка для увеличения вероятности Deadlock
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (resourceA) {
                    System.out.println("Поток 2 захватил Resource A");
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
