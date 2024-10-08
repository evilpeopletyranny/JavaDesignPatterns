package pattern2_structural.struct7_flyweight.code.example1_menu;

/**
 * Класс салата.
 * Пицца является позицией меню.
 */
public class Salad implements MenuEntry {
    private final String name;

    public Salad(String name) {
        this.name = name;
    }

    @Override
    public void serve(Integer tableNumber) {
        System.out.println("Salad " + name + " is served to table " + tableNumber + ".");
    }
}
