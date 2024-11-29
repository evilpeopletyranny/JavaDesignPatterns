package concurrency7_template_tasks.barber.code;

public class Barber implements Runnable {
    private final BarberShop shop;

    public Barber(BarberShop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            Customer customer = shop.nextCustomer();
            if (customer != null) {
                cutHair(customer);
            }
        }
    }

    private void cutHair(Customer customer) {
        System.out.println("Парикмахер начинает стричь " + customer.getName() + ".");
        try {
            Thread.sleep(2000); // Имитация времени стрижки
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Стрижка прервана.");
        }
        System.out.println("Парикмахер закончил стричь " + customer.getName() + ".");
    }
}
