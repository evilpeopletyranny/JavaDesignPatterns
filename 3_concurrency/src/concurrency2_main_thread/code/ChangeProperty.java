package concurrency2_main_thread.code;

public class ChangeProperty {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("MyMainThread");
        mainThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Новое имя главного потока: " + mainThread.getName());
    }
}
