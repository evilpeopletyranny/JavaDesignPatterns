package patterns.structural.composite.code;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Коробка, которая содержит товары.
 * Сама по себе коробка не имеет цены.
 * Цена коробки складывается из цены товаров в ней
 */
public class Box implements Container {
    private Node parent;                //родитель
    private List<Node> children;  //список детей

    /**
     * Создание пустой коробки
     *
     * @param parent родитель
     */
    public Box(Node parent) {
        this.parent = parent;
        children = new LinkedList<>();
    }

    /**
     * Добавление узла
     *
     * @param node элемент, который будет добавлен
     */
    @Override
    public void add(Node node) {
        children.add(node);
    }

    /**
     * Удаление узла
     *
     * @param node элемент для удаления
     */
    @Override
    public void remove(Node node) {
        children.remove(node);
    }

    /**
     * Получение родителя
     *
     * @return children
     */
    @Override
    public List<Node> getChildren() {
        return children;
    }

    /**
     * Подсчет стоимости товаров в коробке.
     * Если в коробке в меньшая коробка, то происходит обсчет
     * меньшей коробки и тд
     *
     * @return цена
     */
    @Override
    public Integer calcCost() {
        int res = 0;
        for (var item : children) res += item.calcCost();
        return res;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(parent, box.parent) && Objects.equals(children, box.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, children);
    }

    @Override
    public String toString() {
        return "Box{" +
                "parent=" + parent +
                ", children=" + children +
                '}';
    }
}
