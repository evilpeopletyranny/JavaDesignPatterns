package concurrency4_synchronization.syn1_join.code;

import java.util.ArrayList;
import java.util.List;

public class ParallelComputation {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        // Создаем и запускаем несколько потоков
        for (int i = 0; i < 5; i++) {
            int index = i;
            Thread thread = new Thread(() -> {
                int result = compute(index);
                synchronized (results) {
                    results.add(result);
                }
            });
            threads.add(thread);
            thread.start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Обрабатываем результаты
        int total = results.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Общий результат: " + total);
    }

    public static int compute(int value) {
        // Симулируем сложное вычисление
        try {
            Thread.sleep(1000 * value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * value;
    }
}

