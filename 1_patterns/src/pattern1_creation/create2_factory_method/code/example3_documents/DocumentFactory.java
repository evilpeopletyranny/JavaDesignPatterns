package pattern1_creation.create2_factory_method.code.example3_documents;

/**
 * Интерфейс абстрактного создателя.
 */
public interface DocumentFactory {
    /**
     * Фабричный метод.
     * Его переопределение будет отвечать за создание разных продуктов.
     *
     * @return созданный продукт
     */
    Document createDocument();
}