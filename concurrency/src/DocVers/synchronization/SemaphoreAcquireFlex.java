package DocVers.synchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreAcquireFlex {
    public static void main(String[] args) throws InterruptedException {
        Semaphore sem = new Semaphore(3);
        Thread t1 = new Thread(()-> {
            try {
                sem.acquire(12);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I HAVE ACQUIRED A LOT, HAHAHAHA");
            sem.release(12);
        });

        Thread t2 = new Thread(()->{
            try {
                sem.acquire(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I have acquired just enough.");
            sem.release(11);
        });
        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}
