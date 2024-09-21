package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Конкретный продукт - Car
 */
public class Car implements Transport {
    @Override
    public void drive() {
        System.out.println("Вождение автомобиля.");
    }
}
