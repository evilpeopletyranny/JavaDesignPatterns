package pattern1_creation.create2_factory_method.code.example3_documents;

public class DocumentMain {
    public static void main(String[] args) {
        // Создание фабрик
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();

        // Использование фабрик для создания документов
        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();

        // Вызов методов документов
        wordDoc.open();
        wordDoc.save();

        pdfDoc.open();
        pdfDoc.save();
    }
}
