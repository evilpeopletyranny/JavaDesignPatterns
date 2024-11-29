package concurrency7_template_tasks.barber.code;

import java.util.LinkedList;
import java.util.Queue;

public class BarberShop {
    private final int numSeats;
    private final Queue<Customer> waitingCustomers;
    private boolean isBarberSleeping;

    public BarberShop(int numSeats) {
        this.numSeats = numSeats;
        this.waitingCustomers = new LinkedList<>();
        this.isBarberSleeping = true;
    }

    // Метод, вызываемый клиентом при входе в Барбершоп
    public synchronized void enterShop(Customer customer) {
        System.out.println(customer.getName() + " вошёл в барбершоп.");

        if (waitingCustomers.size() == numSeats) {
            // Нет свободных кресел для ожидания
            System.out.println(customer.getName() + " не нашёл свободных мест и ушёл.");
            return;
        } else {
            // Есть место для ожидания
            waitingCustomers.add(customer);
            System.out.println(customer.getName() + " сел в кресло для ожидания.");

            // Если парикмахер спит, разбудить его
            if (isBarberSleeping) {
                System.out.println(customer.getName() + " разбудил парикмахера.");
                notify(); // Уведомляем парикмахера о приходе клиента
            }
        }
    }

    // Метод, вызываемый парикмахером для выполнения стрижки
    public synchronized Customer nextCustomer() {
        while (waitingCustomers.isEmpty()) {
            try {
                System.out.println("Парикмахер спит, ожидает клиентов...");
                isBarberSleeping = true;
                wait(); // Парикмахер засыпает и ждёт клиентов
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Парикмахер прерван.");
                return null;
            }
        }
        isBarberSleeping = false;
        return waitingCustomers.poll();
    }
}
