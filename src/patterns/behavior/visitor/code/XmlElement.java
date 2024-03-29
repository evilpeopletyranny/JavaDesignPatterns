package patterns.behavior.visitor.code;

import java.util.HashMap;
import java.util.Map;

/**
 * XML-узел
 */
public class XmlElement implements Element {
    private final Map<String, String> xmlTree = new HashMap<>();

    public XmlElement() {
    }

    void addData(String key, String data) {
        xmlTree.put(key, data);
    }

    public void printXmlTree() {
        xmlTree.forEach((k, v) -> {
            System.out.println("<" + k + ">");
            System.out.println("\t" + v);
            System.out.println("</" + k + ">");
        });
    }

    /**
     * Принятие узла
     *
     * @param visitor посетитель
     */
    @Override
    public void accept(DocVisitor visitor) {
        visitor.doForXmlElement(this);
    }
}
