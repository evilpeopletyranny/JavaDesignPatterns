package concurrency7_template_tasks.barber.code;

public class Main {
    public static void main(String[] args) {
        BarberShop shop = new BarberShop(3); // Барбершоп с 3 креслами для ожидания
        Thread barberThread = new Thread(new Barber(shop), "Парикмахер");
        barberThread.start();

        // Создаём и запускаем клиентов
        for (int i = 1; i <= 10; i++) {
            Customer customer = new Customer("Клиент-" + i, shop);
            Thread customerThread = new Thread(customer, "Клиент-" + i);
            customerThread.start();

            try {
                Thread.sleep(1000); // Интервал между приходами клиентов
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
