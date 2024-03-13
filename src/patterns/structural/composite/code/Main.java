package patterns.structural.composite.code;

/**
 * Просто пример импользования дерева для обсчета товаров,
 * вложенных в коробки.
 * <p>
 * Самое главное что это дерево, а как оно реализовано это уже вторично.
 * Компоновщик это и есть дерево.
 */
public class Main {
    public static void main(String[] args) {
        Container root = new Box(null);
        Container secondBox = new Box(root);
        root.add(secondBox);

        secondBox.add(new Item(50));
        secondBox.add(new Item(100));
        secondBox.add(new Item(150));

        root.add(new Item(3));
        root.add(new Item(7));

        System.out.println(root.calcCost());
    }
}
