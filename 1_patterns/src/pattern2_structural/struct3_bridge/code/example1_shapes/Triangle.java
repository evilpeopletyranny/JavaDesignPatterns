package pattern2_structural.struct3_bridge.code.example1_shapes;

/**
 * Уточненная абстракция - треугольник
 */
public class Triangle extends Shape {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
        color.fillColor();
    }
}
