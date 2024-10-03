package pattern2_structural.struct3_bridge.code.example1_shapes;

/**
 * Уточненная абстракция - прямоугольник
 */
public class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle");
        color.fillColor();
    }
}
