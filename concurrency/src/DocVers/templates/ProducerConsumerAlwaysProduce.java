package DocVers.templates;

import java.util.Arrays;

public class ProducerConsumerAlwaysProduce {

    public static class ObjProducer implements Runnable{
        public final Buffer buffer;
        public final int producingDelay;
        private volatile static int counter = 0;

        public ObjProducer(Buffer buffer, int producingDelay) {
            this.buffer = buffer;
            this.producingDelay = producingDelay;
        }

        @Override
        public void run() {
            while (true){
                synchronized (ObjProducer.class){
                    buffer.append(counter);
                    counter++;
                }
                try { Thread.sleep(producingDelay); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public static class ObjConsumer implements Runnable{
        public final Buffer buffer;
        public final int consumingDelay;

        public ObjConsumer(Buffer buffer, int consumingDelay) {
            this.buffer = buffer;
            this.consumingDelay = consumingDelay;
        }

        @Override
        public void run() {
            while (true) {
                int x = buffer.pop();
                try { Thread.sleep(consumingDelay); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
    public static class Buffer{
        public final int maxSize;
        public final int[] buffer;
        private volatile int pointer = -1;
        public Buffer(int maxSize) {
            this.maxSize = maxSize;
            buffer = new int[maxSize];
        }

        synchronized void append(int x)  {
            while (pointer == maxSize-1) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            pointer++;
            buffer[pointer] = x;
            System.out.println(x + " placed into the buffer");
            System.out.println(this);
            notifyAll();
        }

        synchronized int pop(){
            while (pointer == -1) {
                try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            int result = buffer[pointer];
            buffer[pointer] = 0;
            System.out.println(result + " poped out of the buffer");
            System.out.println(this);
            pointer--;
            notifyAll();
            return result;
        }

        @Override
        public String toString() {
            return "Buffer{" +
                    "buffer=" + Arrays.toString(buffer) +
                    '}';
        }
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        new Thread(new ObjConsumer(buffer, 1000)).start();
        new Thread(new ObjConsumer(buffer, 1000)).start();
        new Thread(new ObjConsumer(buffer, 1000)).start();
        new Thread(new ObjProducer(buffer, 100)).start();
        new Thread(new ObjProducer(buffer, 1000)).start();
        new Thread(new ObjProducer(buffer, 1000)).start();
    }
}
