package DocVers.templates;

import java.util.Random;

public class ReadersWriters {
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

        @Override
        public String toString() {
            return "Data{" +
                    "currentReaders=" + currentReaders +
                    ", currentWriters=" + currentWriters +
                    '}';
        }

        void readOperation(int readerNumber){

            //Тут будет некоторый механизм блокировки

            currentReaders++;

            //Эмулируем операцию
            System.out.println("Reader " + readerNumber + " has started reading " + this);
            try { Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Reader " + readerNumber + " has ended reading");

            currentReaders--;

            //Снимаем блокировку
        }

        void writeOperation(int writerNumber){

            //Тут будет некоторый механизм блокировки

            currentWriters++;

            //Эмулируем операцию
            System.out.println("Writer " + writerNumber + " has started writing" + this);
            try { Thread.sleep(r.nextInt(randomTimeoutUpperBound) + timeout); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("Writer " + writerNumber + " has ended writing");

            currentWriters--;

            //Снимаем блокировку
        }

    }

    public static void main(String[] args) {
        //создаём дату
        Data data = new Data();

        //создаём и запускаем читателей и писателей
        Thread writer1 = new Thread(new Writer(data, 0));
        Thread writer2 = new Thread(new Writer(data, 1));

        Thread reader1 = new Thread(new Reader(data, 0));
        Thread reader2 = new Thread(new Reader(data, 1));

        writer1.start();
        writer2.start();

        reader1.start();
        reader2.start();
    }
}
