package behavior.visitor.code;

/**
 * Пример Посетителя на обходе документа, где элементы
 * в разных нотациях: JSON и XML
 */
public class Main {
    public static void main(String[] args) {
        DocVisitor visitor = new SerializeDocVisitor();

        Document doc = new Document();

        var jsonNode = new JsonElement();
        jsonNode.addData("text", "Ура, последний паттерн!");
        jsonNode.addData("weekNumber", "8");
        doc.add(jsonNode);

        var xmlNode = new XmlElement();
        xmlNode.addData("text", "Но это только начало. Надо еще сдать все лабы.");
        doc.add(xmlNode);

        doc.accept(visitor);
    }
}