package patterns.structural.composite.code;

import java.util.List;

/**
 * Интерфейс узла контейнера.
 * Может содержать как листы, так и другие контейнеры.
 */
public interface Container extends Node {
    /**
     * Добавление элемента в контейнер
     * @param node элемент, который будет добавлен
     */
    void add(Node node);

    /**
     * Удалить элемент из контейнера
     * @param node элемент для удаления
     */
    void remove(Node node);

    /**
     * @return список детей
     */
    List<Node> getChildren();
}
