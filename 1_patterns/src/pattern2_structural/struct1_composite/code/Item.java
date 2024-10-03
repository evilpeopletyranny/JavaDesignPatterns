package pattern2_structural.struct1_composite.code;

import java.util.Objects;

/**
 * Товар - конечный элемент
 */
public class Item implements Leaf {
    private Node parent;        //родитель
    private Integer cost;       //цена товара

    /**
     * All parameters constructor
     * @param parent родительский элемент
     * @param cost цена товара
     */
    public Item(Node parent, Integer cost) {
        this.parent = parent;
        this.cost = cost;
    }

    public Item(Integer cost) {
        this.cost = cost;
    }

    @Override
    public Integer calcCost() {
        return cost;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(parent, item.parent) && Objects.equals(cost, item.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "parent=" + parent +
                ", cost=" + cost +
                '}';
    }
}
