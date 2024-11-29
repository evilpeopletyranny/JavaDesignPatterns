package concurrency5_wait_notify.code.notify_all_example;

// Класс потребителя
class Consumer implements Runnable {
    private SharedResource shared;

    public Consumer(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        while (true) {
            Integer value = shared.consume();
            if (value == null) { // Проверяем, завершено ли производство
                break; // Выходим из цикла и завершаем поток
            }
            try {
                Thread.sleep(1500); // Имитация времени потребления
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(Thread.currentThread().getName() + " завершил потребление.");
    }
}
