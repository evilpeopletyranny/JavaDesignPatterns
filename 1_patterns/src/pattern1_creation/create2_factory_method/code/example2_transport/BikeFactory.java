package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Конкретный создатель для конкретного продуква - Bike
 */
public class BikeFactory extends TransportFactory {
    /**
     * Переобпределнный фабричный метод.
     *
     * @return объект Bike
     */
    @Override
    public Transport createTransport() {
        return new Bike();
    }
}