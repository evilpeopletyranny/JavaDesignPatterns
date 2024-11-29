package concurrency5_wait_notify.code.notify_all_example;

/**
 * Общий ресурс
 */
class SharedResource {
    private int data;
    private boolean available = false;
    private boolean finished = false; // Флаг завершения производства

    // Метод для производителя
    public synchronized void produce(int value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        available = true;
        System.out.println(Thread.currentThread().getName() + " произвел: " + value);
        notifyAll(); // Уведомляем всех ожидающих потребителей
    }

    // Метод для потребителя
    public synchronized Integer consume() {
        while (!available) {
            if (finished) { // Если производство завершено и данных больше нет
                return null; // Возвращаем null для завершения потребителя
            }
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        available = false;
        System.out.println(Thread.currentThread().getName() + " потребил: " + data);
        notifyAll(); // Уведомляем производителя о потреблении данных
        return data;
    }

    // Метод для установки флага завершения производства
    public synchronized void setFinished() {
        finished = true;
        notifyAll(); // Уведомляем всех потребителей о завершении
    }
}
