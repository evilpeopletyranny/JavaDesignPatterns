package pattern1_creation.create2_factory_method.code.example3_documents;

/**
 * Конкретный создатель для конкретного продуква - WordDocument
 */
public class WordDocumentFactory implements DocumentFactory {
    /**
     * Переобпределнный фабричный метод.
     *
     * @return объект WordDocument
     */
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
