package pattern3_behavior.behavior7_visitor.code.example1_document;

import java.util.ArrayList;
import java.util.List;

/**
 * Сам документ, который мы будем обходить.
 */
public class Document implements Element {
    //Элементы документа
    List<Element> elements = new ArrayList<>();

    public Document() {
    }

    /**
     * Добавление элемента в документ
     */
    void add(Element element) {
        elements.add(element);
    }

    /**
     * Принятие посетителя документом.
     * Применение посетителя на каждый узел
     *
     * @param visitor посетитель
     */
    @Override
    public void accept(DocVisitor visitor) {
        elements.forEach(el -> el.accept(visitor));
    }
}
