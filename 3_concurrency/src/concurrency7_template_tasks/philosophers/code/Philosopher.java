package concurrency7_template_tasks.philosophers.code;

import java.util.Random;

// Класс, представляющий философа
class Philosopher implements Runnable {
    private final int id;
    private final Fork firstFork;
    private final Fork secondFork;
    private final Random random;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        // Упорядоченный захват вилок
        if (leftFork.getId() < rightFork.getId()) {
            this.firstFork = leftFork;
            this.secondFork = rightFork;
        } else {
            this.firstFork = rightFork;
            this.secondFork = leftFork;
        }
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Философ " + (id + 1) + " завершил работу.");
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + (id + 1) + " размышляет.");
        Thread.sleep(random.nextInt(8000)); // Философ размышляет некоторое время
    }

    private void eat() throws InterruptedException {
        // Захват первой вилки
        synchronized (firstFork) {
            System.out.println("Философ " + (id + 1) + " взял вилку " + firstFork.getId() + ".");

            // Захват второй вилки
            synchronized (secondFork) {
                System.out.println("Философ " + (id + 1) + " взял вилку " + secondFork.getId() + ".");
                System.out.println("Философ " + (id + 1) + " начинает есть.");
                Thread.sleep(random.nextInt(8000)); // Философ ест некоторое время
                System.out.println("Философ " + (id + 1) + " закончил есть.");
            }
            System.out.println("Философ " + (id + 1) + " положил вилку " + secondFork.getId() + ".");
        }
        System.out.println("Философ " + (id + 1) + " положил вилку " + firstFork.getId() + ".");
    }
}
