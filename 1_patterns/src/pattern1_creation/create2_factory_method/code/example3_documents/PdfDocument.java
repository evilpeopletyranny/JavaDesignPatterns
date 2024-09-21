package pattern1_creation.create2_factory_method.code.example3_documents;

/**
 * Конкретный продукт - PdfDocument
 */
public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Открытие PDF документа.");
    }

    @Override
    public void save() {
        System.out.println("Сохранение PDF документа.");
    }
}
