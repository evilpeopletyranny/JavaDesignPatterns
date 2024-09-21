package pattern1_creation.create2_factory_method.code.example2_transport;

/**
 * Абстрактный создатель TransportFactory
 */
public abstract class TransportFactory {
    /**
     * Фабричный метод.
     * Его переопределение будет отвечать за создание разных продуктов.
     *
     * @return созданный продукт
     */
    public abstract Transport createTransport();
}
