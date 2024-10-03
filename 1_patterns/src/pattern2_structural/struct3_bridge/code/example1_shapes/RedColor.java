package pattern2_structural.struct3_bridge.code.example1_shapes;

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
