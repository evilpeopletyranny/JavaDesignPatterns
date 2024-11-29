package concurrency5_wait_notify.code.notify_all_example;

public class Main {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        // Создаем одного производителя
        Thread producer = new Thread(new Producer(shared), "Производитель");

        // Создаем двух потребителей
        Thread consumer1 = new Thread(new Consumer(shared), "Потребитель-1");
        Thread consumer2 = new Thread(new Consumer(shared), "Потребитель-2");

        producer.start();
        consumer1.start();
        consumer2.start();

        try {
            producer.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Все потоки завершены. Программа завершена.");
    }
}
