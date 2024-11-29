package concurrency5_wait_notify.code.notify_example;

/**
 * Общий ресурс
 */
public class SharedResource {
    private int data;
    private boolean available = false;

    // Метод для производителя
    public synchronized void produce(int value) {
        while (available) { // Ждём, пока ресурс будет свободен
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        System.out.println(Thread.currentThread().getName() + " произвел: " + value);
        notify(); // Уведомляем потребителя о доступности данных
    }

    // Метод для потребителя
    public synchronized int consume() {
        while (!available) { // Ждём, пока данные будут доступны
            try {
                wait(); // Поток потребитель засыпает
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println(Thread.currentThread().getName() + " потребил: " + data);
        notify(); // Уведомляем производителя о том, что ресурс свободен
        return data;
    }
}
