package pattern2_structural.struct7_flyweight.code.example1_menu;

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
