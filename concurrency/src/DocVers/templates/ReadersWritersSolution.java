package DocVers.templates;

import DocVers.synchronization.SimpleLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

public class ReadersWritersSolution {

    final public static Random r = new Random();
    final public static int timeout = 100;
    final public static int randomTimeoutUpperBound = 900;
    public static class Reader implements Runnable{
        Data data;
        final int number;

        public Reader(Data data, int number) {
            this.data = data;
            this.number = number;
        }

        @Override
        public void run() {
            while (true) {
                data.readOperation(number);
                try {
                    Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Writer implements Runnable{
        Data data;
        final int number;

        public Writer(Data data, int number) {
            this.data = data;
            this.number = number;
        }

        @Override
        public void run() {
            while (true) {
                data.writeOperation(number);
                try {
                    Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class Data{
        volatile int currentReaders = 0;
        volatile int currentWriters = 0;

        SimpleLock read = new SimpleLock();
        SimpleLock write = new SimpleLock();
        SimpleLock readCount = new SimpleLock();
        SimpleLock writeCount = new SimpleLock();

        @Override
        public String toString() {
            return "Data{" +
                    "currentReaders=" + currentReaders +
                    ", currentWriters=" + currentWriters +
                    '}';
        }

        void readOperation(int readerNumber){

            //изменение количества читателей и блокировка писателей, пока читатели читают
            read.lock();
            readCount.lock();
            currentReaders++;
            if (currentReaders == 1) write.lock();
            readCount.unlock();
            read.unlock();

            //Здесь может находиться любое число читателей!

            //Эмулируем операцию
            System.out.println("Reader " + readerNumber + " has started reading " + this);
            try { Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Reader " + readerNumber + " has ended reading");

            //изменение количества читателей и разблокировка писателей, если все читатели покинули секцию
            readCount.lock();
            currentReaders--;
            if (currentReaders == 0) write.unlock();
            readCount.unlock();
        }

        void writeOperation(int writerNumber){
            //Изменение количества писателей и блокировка читателей
            writeCount.lock();
            currentWriters++;
            if(currentWriters == 1) read.lock();
            writeCount.unlock();

            //Несколько писателей могут дойти до сюда!

            //блокиреум писателей перед записью
            write.lock();

            //Эмулируем операцию
            System.out.println("Writer " + writerNumber + " has started writing " + this);
            try { Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Writer " + writerNumber + " has ended writing");

            //как только операция записи выполнена - разблокируем писателей.
            write.unlock();

            //Если писателей больше нет - разблокируем читателей
            writeCount.lock();
            currentWriters--;
            if(currentWriters == 0) read.unlock();
            writeCount.unlock();
        }

    }

    public static void main(String[] args) {
        //создаём дату
        Data data = new Data();

        //создаём и запускаем читателей и писателей
        Thread writer1 = new Thread(new Writer(data, 0),"writer 1");
        Thread writer2 = new Thread(new Writer(data, 1), "writer 2");

        Thread reader1 = new Thread(new Reader(data, 0), "reader 1");
        Thread reader2 = new Thread(new Reader(data, 1), "reader 2");

        reader1.start();
        reader2.start();

        writer1.start();
        writer2.start();
    }
}
