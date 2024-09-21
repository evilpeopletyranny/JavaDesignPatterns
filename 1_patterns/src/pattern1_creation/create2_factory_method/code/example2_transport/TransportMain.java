package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Пример с подменной фабрик.
 */
public class TransportMain {
    public static void main(String[] args) {
        // Созданили фабрику
        TransportFactory factory = new CarFactory();
        // Создали конкретный продукт - автомобиль
        Transport car = factory.createTransport();

        // Сменили фабрику
        factory = new BikeFactory();
        // Создали конкретный продукт - байк
        Transport bike = factory.createTransport();

        car.drive();
        bike.drive();
    }
}
