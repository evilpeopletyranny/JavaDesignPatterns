package pattern1_creation.create2_factory_method.code.example3_documents;

/**
 * Конкретный создатель для конкретного продуква - PdfDocument
 */
public class PdfDocumentFactory implements DocumentFactory {
    /**
     * Переобпределнный фабричный метод.
     *
     * @return объект PdfDocument
     */
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
