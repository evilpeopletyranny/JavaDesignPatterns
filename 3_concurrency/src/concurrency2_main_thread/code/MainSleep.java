package concurrency2_main_thread.code;

public class MainSleep {
    public static void main(String[] args) throws InterruptedException {
            System.out.println("Главный поток спит 2 секунды.");
            Thread.sleep(2000); // Приостановка главного потока на 2 секунды
    }
}
