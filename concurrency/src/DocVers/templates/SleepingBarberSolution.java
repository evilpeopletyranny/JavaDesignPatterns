package DocVers.templates;

import java.util.Vector;

public class SleepingBarberSolution {

    public static final int WORK_DELAY = 1000;
    public static final int CLIENTS_DELAY = 5000;

    public static class Barbershop{
        Barber barber;
        Vector<Client> clients = new Vector<>();

        public Barbershop() {
            barber = new Barber(this);
            new Thread(barber).start();
        }

        public synchronized void addClient(Client client){
            clients.add(client);
        }
        public synchronized boolean hasClients(){
            return !clients.isEmpty();
        }

        public synchronized void doBarberWork(){
            while (hasClients()){
                Client client = clients.get(0);
                System.out.println("Barber is shaving");
                try {
                    Thread.sleep(WORK_DELAY);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                clients.remove(client);
                System.out.println(clients.size() + " clients left");
            }
            System.out.println("barber goes asleep");
            try { wait(); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        public synchronized void clientArrived(Client client){
            if(hasClients()) addClient(client);
            else {
                addClient(client);
                notify();
            }
        }
    }

    public static class Client implements Runnable{
        final Barbershop barbershop;

        public Client(Barbershop barbershop) {
            this.barbershop = barbershop;
        }

        @Override
        public void run() {
            barbershop.clientArrived(this);
        }
    }

    public static class Barber implements Runnable {

        final Barbershop barbershop;
        public Barber(Barbershop barbershop) {
            this.barbershop = barbershop;
        }

        @Override
        public void run() {
            while (true){
                barbershop.doBarberWork();
            }
        }
    }
    public static class ClientProducer implements Runnable{
        public final Barbershop barbershop;

        public ClientProducer(Barbershop barbershop) {
            this.barbershop = barbershop;
        }

        @Override
        public void run() {
            while (true){
                for (int i = 0; i < 3; i++) {
                    new Thread(new Client(barbershop)).start();
                }
                try {
                    Thread.sleep(CLIENTS_DELAY);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        Barbershop barbershop = new Barbershop();
        new Thread(new ClientProducer(barbershop)).start();
    }
}
