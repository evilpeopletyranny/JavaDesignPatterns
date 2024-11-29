package concurrency5_wait_notify.code.notify_all_example;

// Класс производителя
class Producer implements Runnable {
    private SharedResource shared;

    public Producer(SharedResource shared) {
        this.shared = shared;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            shared.produce(i);
            try {
                Thread.sleep(1000); // Имитация времени производства
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        shared.setFinished(); // Устанавливаем флаг завершения после производства всех данных
        System.out.println(Thread.currentThread().getName() + " завершил производство.");
    }
}
