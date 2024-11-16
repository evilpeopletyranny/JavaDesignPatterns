package concurrency2_main_thread.code;

public class GetLink {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Имя главного потока: " + mainThread.getName());
    }
}
