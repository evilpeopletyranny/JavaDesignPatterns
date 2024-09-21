package pattern1_creation.create2_factory_method.code.example3_documents;

/**
 * Конкретный продукт - WordDocument
 */
public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Открытие Word документа.");
    }

    @Override
    public void save() {
        System.out.println("Сохранение Word документа.");
    }
}
