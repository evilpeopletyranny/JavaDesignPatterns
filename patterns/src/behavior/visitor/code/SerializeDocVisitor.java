package behavior.visitor.code;

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
