package DocVers.synchronization;

public class DaemonsDemo {
    public static void main(String[] args) {
        Thread userModeThread = new Thread(()->{
            System.out.println("user thread has printed this");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("user thread has ended it's work");
        });
        Thread daemonModeThread = new Thread(()->{
            while (true){
                System.out.println("daemon has printed this");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        userModeThread.start();
        daemonModeThread.setDaemon(true);
        daemonModeThread.start();
    }
}
