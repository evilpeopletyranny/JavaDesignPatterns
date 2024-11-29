package concurrency7_template_tasks.philosophers.code;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfPhilosophers = 5;
        List<Philosopher> philosophers = new ArrayList<>(numberOfPhilosophers);
        List<Fork> forks = new ArrayList<>(numberOfPhilosophers);

        // Инициализация вилок
        for (int i = 0; i < numberOfPhilosophers; i++) forks.add(new Fork(i));

        // Инициализация философов и запуск потоков
        for (int i = 0; i < numberOfPhilosophers; i++) {
            Fork leftFork = forks.get(i);
            Fork rightFork = forks.get((i + 1) % numberOfPhilosophers);

            // Чтобы избежать симметрии, последний философ меняет порядок захвата вилок
            if (i == numberOfPhilosophers - 1) philosophers.add(new Philosopher(i, rightFork, leftFork));
            else philosophers.add(new Philosopher(i, leftFork, rightFork));

            //Запуск потоков с философами
            new Thread(philosophers.get(i), "Философ " + (i + 1)).start();
        }
    }
}
