package concurrency3_creation.code;

class MyThread extends Thread {
    @Override
    public void run() {
        // Код, который будет выполняться в новом потоке
        System.out.println("Поток " + Thread.currentThread().getName() + " выполняется.");
        // Например, выполнить какую-то задачу
        for (int i = 1; i <= 5; i++) {
            System.out.println("Поток " + Thread.currentThread().getName() + ": значение i = " + i);
            try {
                Thread.sleep(500); // Приостановка потока на 500 миллисекунд
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " завершён.");
    }
}

public class ThreadMain {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread(); // Создание экземпляра потока
        thread1.setName("МойПоток-1");     // Установка имени потока

        MyThread thread2 = new MyThread();
        thread2.setName("МойПоток-2");

        thread1.start(); // Запуск потока
        thread2.start();
    }
}
