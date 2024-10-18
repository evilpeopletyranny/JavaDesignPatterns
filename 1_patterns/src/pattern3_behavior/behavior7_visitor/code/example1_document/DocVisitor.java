package pattern3_behavior.behavior7_visitor.code.example1_document;

/**
 * Посетитель документов
 */
public interface DocVisitor {
    /**
     * @param element xml узел
     */
    void doForXmlElement(XmlElement element);

    /**
     * @param element json узел
     */
    void doForJSONElement(JsonElement element);
}
