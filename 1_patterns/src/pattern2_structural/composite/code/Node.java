package pattern2_structural.composite.code;

/**
 * Общий интерфейс элементов дерева.
 */
public interface Node {
    /**
     * Каждый элемент должен уметь посчитать свою цену.
     * Некоторое общее дейсвтие для всех компонентов, в диаграмме эта функция
     * называется execute()
     *
     * @return цена
     */
    Integer calcCost();

    /**
     * Пусть каждый элемент может возвращать родителя
     *
     * @return родитель
     */
    Node getParent();

    /**
     * Имеем возможность задать родителя
     *
     * @param parent родитель
     */
    void setParent(Node parent);
}
