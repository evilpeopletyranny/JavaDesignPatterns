package DocVers.synchronization;

import java.time.Duration;

public class JoinDemo {
    //выводит название потока
    public static void printThread(){
        System.out.println("This message has printed by thread [" + Thread.currentThread().getName() + "]");
    }

    //описание нашего потока
    public static class MyThread extends Thread{
        public MyThread() {
            setName("MyThread");
        }
        @Override
        public void run(){
            try { Thread.sleep(Duration.ofSeconds(1).toMillis()); }
            catch (InterruptedException e) { e.printStackTrace(); }
            printThread();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //создаём и запускаем параллельный поток
        Thread myThread = new MyThread();
        myThread.start();

        printThread();
        System.out.println("This must be happening before join and now we are waiting...");
        //после того, как мы вызываем join(), текущий поток ожидает завершения присоединённого.
        myThread.join();
        printThread();
        System.out.println("This must be happening joined thread has done it's work");
    }
}
