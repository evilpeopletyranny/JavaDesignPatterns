package DocVers.synchronization;

public class MonitorUsageDemo {
    //Это объект, мьютекс которого мы будем захватывать.
    public static final Object obj = new Object();
    //2 разных метода, использующих мьютекс одного объекта.
    //Соответственно, вне зависимости от того, какой метод исполняется потоком, он не сможет захватить уже захваченый
    //мьютекс и как следствие - одновременно может выполняться не больше одного synchronized блока.
    public static void someMethod1() throws InterruptedException {
        System.out.println("In safe section of method 1");
        synchronized (obj){
            System.out.println("Entered critical section of method 1");
            Thread.sleep(300);
            System.out.println("Critical section of method 1 is about to end");
        }
    }
    public static void someMethod2() throws InterruptedException {
        System.out.println("In safe section of method 2");
        synchronized (obj){
            System.out.println("Entered critical section of method 2");
            Thread.sleep(300);
            System.out.println("Critical section of method 2 is about to end");
        }
    }
    public static void main(String[] args) {
        new Thread(()-> {
            while (true) try { someMethod1();
                } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(()-> {
            while (true) try { someMethod1();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(()-> {
            while (true) try { someMethod2();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(()-> {
            while (true) try { someMethod2();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
    }
}
