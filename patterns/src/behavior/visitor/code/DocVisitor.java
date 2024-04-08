package behavior.visitor.code;

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
