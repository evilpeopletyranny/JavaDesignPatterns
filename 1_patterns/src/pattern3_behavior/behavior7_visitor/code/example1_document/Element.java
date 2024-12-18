package pattern3_behavior.behavior7_visitor.code.example1_document;

/**
 * Интерфейс узлов, которые мы обходим Посетителем.
 */
public interface Element {
    /**
     * Метод принятия посетиля.
     * Выполнение действий определенных в посетителе.
     *
     * @param visitor посетитель
     */
    void accept(DocVisitor visitor);
}
