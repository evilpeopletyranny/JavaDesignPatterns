package concurrency4_synchronization.syn1_join.code;

public class SimpleJoin {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task(), "Рабочий поток");
        thread.start();

        try {
            System.out.println("Главный поток ждет завершения рабочего потока...");
            thread.join();
            System.out.println("Рабочий поток завершен. Продолжение работы главного потока.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        System.out.println("Рабочий поток выполняется...");
        try {
            Thread.sleep(2000); // Симулируем работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Рабочий поток завершен.");
    }
}
