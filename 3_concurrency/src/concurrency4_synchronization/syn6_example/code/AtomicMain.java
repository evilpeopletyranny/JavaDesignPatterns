package concurrency4_synchronization.syn6_example.code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicMain {
    static AtomicInteger counter = new AtomicInteger(0);     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd(){
        for (int j = 0; j < 100000; j++)
            counter.incrementAndGet();
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

        for (var t:threads) t.start();
        for (var t:threads) t.join();

        System.out.println(counter);
    }
}
