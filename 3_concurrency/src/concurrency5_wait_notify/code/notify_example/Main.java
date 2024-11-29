package concurrency5_wait_notify.code.notify_example;

public class Main {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        // Поток производителя
        Thread producer = new Thread(new Producer(shared), "Производитель");
        // Поток потребителя
        Thread consumer = new Thread(new Consumer(shared), "Потребитель");

        producer.start();
        consumer.start();
    }
}
