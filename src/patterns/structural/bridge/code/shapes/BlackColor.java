package patterns.structural.bridge.code.shapes;

/**
 * Конкретная реализация.
 * Черный цвет
 */
public class BlackColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in black color");
    }
}
