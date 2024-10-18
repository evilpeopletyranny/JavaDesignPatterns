package pattern3_behavior.behavior7_visitor.code.example1_document;

public class SerializeDocVisitor implements DocVisitor {

    @Override
    public void doForXmlElement(XmlElement element) {
        element.printXmlTree();
    }

    @Override
    public void doForJSONElement(JsonElement element) {
        element.printJsonTree();
    }
}
