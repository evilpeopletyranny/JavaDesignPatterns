package concurrency5_wait_notify.code.notify_example;

// Класс потребителя
class Consumer implements Runnable {
    private SharedResource shared;

    public Consumer(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            shared.consume();
            try {
                Thread.sleep(1500); // Имитация времени потребления
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
