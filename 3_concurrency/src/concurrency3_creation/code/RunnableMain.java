package concurrency3_creation.code;

class MyRunnable implements Runnable {
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

public class RunnableMain {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable(); // Создание экземпляра Runnable

        Thread thread1 = new Thread(runnable, "МойПоток-1"); // Создание потока с именем
        Thread thread2 = new Thread(runnable, "МойПоток-2");

        thread1.start(); // Запуск потока
        thread2.start();
    }
}
