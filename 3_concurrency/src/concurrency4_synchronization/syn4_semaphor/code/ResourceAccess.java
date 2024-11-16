package concurrency4_synchronization.syn4_semaphor.code;

import java.util.concurrent.Semaphore;

public class ResourceAccess {
    private static final int MAX_CONCURRENT_THREADS = 3;
    private final Semaphore semaphore = new Semaphore(MAX_CONCURRENT_THREADS);

    public void useResource() {
        try {
            semaphore.acquire();
            // Критическая секция: доступ к ресурсу
            System.out.println(Thread.currentThread().getName() + " использует ресурс");
            Thread.sleep(2000); // Симуляция работы с ресурсом
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
            System.out.println(Thread.currentThread().getName() + " освободил ресурс");
        }
    }

    public static void main(String[] args) {
        ResourceAccess example = new ResourceAccess();

        for (int i = 0; i < 10; i++)
            new Thread(example::useResource, "Поток " + i).start();
    }
}
