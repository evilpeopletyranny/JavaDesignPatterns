package DocVers.creation;

import java.time.Duration;

public class ThreadCreation {
    //Наследование от Thread
    static class MyThread extends Thread{
        //Ждём секунду, после чего выводим сообщение
        @Override
        public void run(){
            try { Thread.sleep(Duration.ofSeconds(1).toMillis());
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("MyThread has printed this");
        }
    }

    //Реализация интерфейса Runnable
    static class MyRunnable implements Runnable {
        //Ждём секунду, после чего выводим сообщение
        @Override
        public void run() {
            try { Thread.sleep(Duration.ofSeconds(1).toMillis());
            } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("MyRunnable has printed this");
        }
    }
    //Создание и запуск на исполнение
    public static void main(String[] args) {
        //Класс, наследующий Thread не нуждается в дополнительном потоке.
        MyThread myThread = new MyThread();
        //Поскольку интерфейс Runnable представляет собой "задачку для исполнения",
        //то для её запуска требуется дополнительный поток.
        MyRunnable myRunnable = new MyRunnable();
        Thread threadForRunnable = new Thread(myRunnable);

        //Вне зависимости от используемого метода создания, для исполнения поток необходимо запустить.
        myThread.start();
        threadForRunnable.start();
    }
}
