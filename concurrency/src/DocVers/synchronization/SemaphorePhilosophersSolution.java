package DocVers.synchronization;

import java.time.Duration;
import java.util.concurrent.Semaphore;

public class SemaphorePhilosophersSolution {
    /* Решаемая задача - это одна из вариаций на тему задачи об обедающих философах. Звучит она так:
    *  Есть стол, за которым могут сидеть не более 2-х человек.
    *  Есть некоторое количество философов. Нужно организовать доступ к столу таким образом, чтобы все философы по
    *  очереди садились за стол и обедали.
    * */
    public static class Philosopher implements Runnable {
        Semaphore sem;
        String name;
        public Philosopher(Semaphore sem, String name) {
            this.sem = sem;
            this.name = name;
        }
        @Override
        public void run(){
            while (true){
                try {
                    sem.acquire();
                    System.out.println(name + " just has started eating.");
                    Thread.sleep(Duration.ofSeconds(1).toMillis());
                    System.out.println(name + " just has ended eating.");
                    sem.release();
                } catch (InterruptedException e) {
                    System.out.println("Something has gone wrong");
                }
            }
        }
    }
    public static void main(String[] args) {
        //создаём семафор
        Semaphore table = new Semaphore(2, true);
        //создаём философов и запускаем их в потоках
        new Thread(new Philosopher(table, "Сократ")).start();
        new Thread(new Philosopher(table, "Демокрит")).start();
        new Thread(new Philosopher(table, "Гераклит")).start();
        new Thread(new Philosopher(table, "Пифагор")).start();
        new Thread(new Philosopher(table, "Аристотель")).start();
    }
}
