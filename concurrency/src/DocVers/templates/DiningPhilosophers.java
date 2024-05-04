package DocVers.templates;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    public static final int timeout = 300;

    public static class Fork{
        public final int number;
        Lock lock = new ReentrantLock();

        public Fork(int number) { this.number = number; }
        public void take(){ lock.lock(); }
        public void put(){ lock.unlock(); }
    }

    public static class Philosopher implements Runnable {
        Fork leftFork;
        Fork rightFork;
        String name;

        public Philosopher(Fork leftFork, Fork rightFork, String name) {
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.name = name;
        }

        void eat(){
            //здесь будет описан некоторый алгоритм, по которому философ берёт вилки
            System.out.println(name + " started eating");
            try { Thread.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(name + " has done eating");
            //и после этого, он должен в каком-то порядке их освободить.
        }
        void speculate(){
            System.out.println(name + " started speculating");
            try { Thread.sleep(timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(name + " got hungry");
        }
        @Override
        public void run() {
            while (true){
                eat();
                speculate();
            }
        }
    }

    public static void main(String[] args) {
        //вилки
        Fork f0 = new Fork(0);
        Fork f1 = new Fork(1);
        Fork f2 = new Fork(2);
        Fork f3 = new Fork(3);
        Fork f4 = new Fork(4);

        //запуск философов
        new Thread(new Philosopher(f0, f1, "Сократ")).start();
        new Thread(new Philosopher(f1, f2, "Демокрит")).start();
        new Thread(new Philosopher(f2, f3, "Гераклит")).start();
        new Thread(new Philosopher(f3, f4, "Пифагор")).start();
        new Thread(new Philosopher(f4, f0, "Аристотель")).start();
    }
}
