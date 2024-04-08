package structural.bridge.code.shapes;

/**
 * Конкретная реализация.
 * Красный цвет
 */
public class RedColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in red color");
    }
}
