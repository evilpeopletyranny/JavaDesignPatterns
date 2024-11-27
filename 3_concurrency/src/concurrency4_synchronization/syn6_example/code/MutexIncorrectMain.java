package concurrency4_synchronization.syn6_example.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexIncorrectMain {
    static int counter = 0;     // разделяемая переменная
    static Lock lock = new ReentrantLock();

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            counter++;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();
        System.out.println(counter);
    }
}
