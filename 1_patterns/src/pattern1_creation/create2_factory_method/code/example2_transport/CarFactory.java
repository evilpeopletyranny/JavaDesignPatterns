package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Конкретный создатель для конкретного продуква - Car
 */
public class CarFactory extends TransportFactory {
    /**
     * Переобпределнный фабричный метод.
     *
     * @return объект Car
     */
    @Override
    public Transport createTransport() {
        return new Car();
    }
}
