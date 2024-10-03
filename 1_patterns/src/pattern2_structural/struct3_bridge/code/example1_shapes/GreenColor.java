package pattern2_structural.struct3_bridge.code.example1_shapes;

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
