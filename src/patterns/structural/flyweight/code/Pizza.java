package patterns.structural.flyweight.code;

/**
 * Класс пиццы.
 * Пицца является позицией меню.
 */
public class Pizza implements MenuEntry {
    private final String name;

    public Pizza(String name) {
        this.name = name;
    }

    @Override
    public void serve(Integer tableNumber) {
        System.out.println("Pizza " + name + " is served to table " + tableNumber + ".");
    }
}
