package patterns.behavior.visitor.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Элемент типа JSON
 */
public class JsonElement implements Element {
    private final Map<String, String> jsonTree = new HashMap<>();

    public JsonElement() {
    }

    void addData(String key, String data) {
        jsonTree.put(key, data);
    }

    public void printJsonTree() {
        jsonTree.forEach((k, v) -> {
            System.out.println("{");
            System.out.println("\t" + k + ": " + v);
            System.out.println("}");
        });
    }

    /**
     * Принятие посетителя
     *
     * @param visitor посетитель
     */
    @Override
    public void accept(DocVisitor visitor) {
        visitor.doForJSONElement(this);
    }
}
