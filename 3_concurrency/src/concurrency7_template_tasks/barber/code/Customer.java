package concurrency7_template_tasks.barber.code;

public class Customer implements Runnable {
    private final String name;
    private final BarberShop shop;

    public Customer(String name, BarberShop shop) {
        this.name = name;
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        shop.enterShop(this);
    }
}
