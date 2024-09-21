package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Конкретный продукт - Bike
 */
public class Bike implements Transport {
    @Override
    public void drive() {
        System.out.println("Вождение велосипеда.");
    }
}
