package concurrency4_synchronization.syn1_join.code;

public class TimeOut {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongTask(), "Долгий поток");
        thread.start();

        try {
            System.out.println("Главный поток ждет не более 1 секунды...");
            thread.join(1000); // Ждем не более 1 секунды
            if (thread.isAlive()) {
                System.out.println("Долгий поток все еще работает после 1 секунды.");
            } else {
                System.out.println("Долгий поток завершен до истечения 1 секунды.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный потокз завершен.");
    }
}

class LongTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Долгий поток выполняется...");
        try {
            Thread.sleep(3000); // Симулируем долгую работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Долгий поток завершен.");
    }
}
