package DocVers.synchronization;

public class SimpleLock {
    //Захвачен ли мьютекс прямо сейчас
    volatile boolean isLocked = false;

    //должен блокировать все входящие потоки, кроме одного.
    public synchronized void lock() {
        //Если мьютекс захачен - ждём.
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //Соответственно, если мьютекс освобождается - захватываем
        isLocked = true;
    }

    //Должен высвобождать один поток.
    public synchronized void unlock() {
        //снимаем захват мьютекса
        isLocked = false;
        //будим один поток из числа ожидающих.
        notify();
    }
}
