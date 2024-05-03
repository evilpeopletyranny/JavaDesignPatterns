package DocVers.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockSolution {
    public static void main(String[] args) throws InterruptedException {
        //хлеб
        Lock bread = new ReentrantLock();
        //варенье
        Lock jam = new ReentrantLock();
        //вы
        Thread you = new Thread(()-> {
            System.out.println("you have started eating attempt");
            jam.lock();
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            bread.lock();
            System.out.println("You are eating bread with jam");
            bread.unlock();
            jam.unlock();
        });
        //ваш друг
        Thread yourFriend = new Thread(()-> {
            System.out.println("your friend has started eating attempt");
            jam.lock();
            try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            bread.lock();
            System.out.println("YourFriend is eating bread with jam");
            bread.unlock();
            jam.unlock();
        });
        //запускаем
        you.start();
        yourFriend.start();
        //ждём пока все закончат
        you.join();
        yourFriend.join();
        //Говорим, что всё хорошо.
        System.out.println("if this message appeared, you and your friend have done eating");
        //Но здесь мы скорее всего не окажемся.
    }
}
