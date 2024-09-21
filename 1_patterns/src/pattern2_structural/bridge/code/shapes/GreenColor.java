package pattern2_structural.bridge.code.shapes;

/**
 * Конкретная реализация.
 * Зеленый цвет
 */
public class GreenColor implements Color {
    @Override
    public void fillColor() {
        System.out.println("Filling in green color");
    }
}
