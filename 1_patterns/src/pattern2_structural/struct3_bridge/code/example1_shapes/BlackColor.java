package pattern2_structural.struct3_bridge.code.example1_shapes;

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
