package DocVers.synchronization;

import java.util.Vector;

public class NotFixedRace {
    //Пусть будет у нас некоторая разделяемая переменная
    volatile static int counter = 0;
    //статически метод, добавляющий к нашей переменной 10000 раз по единице в цикле.
    public static void cyclicAdd(){
        for (int j = 0; j < 10000; j++)
            counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        //Вектор с потоками
        Vector<Thread> threads = new Vector<>();
        //Создаём 10 потоков, каждый из которых вызывает метод cyclicAdd()
        for (int i = 0; i < 10; i++)
            threads.add(new Thread(NotFixedRace::cyclicAdd));
        //запускаем все потоки
        for (var t:threads) t.start();
        //ждём, пока все потоки исполнятся
        for (var t:threads) t.join();
        //выводим, то, что оказалось в нашей переменной
        System.out.println(counter);
    }
}
