package DocVers.synchronization;

import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OwnLockRaceSolution {
    //Пусть будет у нас некоторая разделяемая переменная
    static volatile int counter = 0;
    //Создадим также наш аналог мьютекса
    static SimpleLock lock = new SimpleLock();
    //статически метод, добавляющий к нашей переменной 10000 раз по единице в цикле.
    public static void cyclicAdd(){
        lock.lock();
        for (int j = 0; j < 10000000; j++) {
            counter++;
        }
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        //Вектор с потоками
        Vector<Thread> threads = new Vector<>();
        //Создаём 10 потоков, каждый из которых вызывает метод cyclicAdd()
        for (int i = 0; i < 10; i++)
            threads.add(new Thread(OwnLockRaceSolution::cyclicAdd));
        //запускаем все потоки
        for (var t:threads) t.start();
        //ждём, пока все потоки исполнятся
        for (var t:threads) t.join();
        //выводим, то, что оказалось в нашей переменной
        System.out.println(counter);
    }
}
