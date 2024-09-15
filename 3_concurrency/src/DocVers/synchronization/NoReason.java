package DocVers.synchronization;

import java.util.Vector;

public class NoReason {
    public static void main(String[] args) {
        //Вектор с нашими потоками
        Vector<Thread> threads = new Vector<>();
        //Каждый поток будет выводить в консоль номер итерации, на которой создан
        for (int i = 0; i < 5; i++) {
            //для корректной работы лямбд.
            final int j = i;
            //Создаём поток. Перед выполнением ожидаем завершения предыдущего потока для всех после первого.
            Thread thread;
            if(i<1)
                thread = new Thread(()-> System.out.println(j));
            else
                thread = new Thread(()-> {
                    try { threads.get(j-1).join(); }
                    catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(j);
                });
            //Добавляем поток к вектору
            threads.add(thread);
        }
        //Запускаем все потоки на исполнение.
        for(var t: threads) t.start();
    }
}
