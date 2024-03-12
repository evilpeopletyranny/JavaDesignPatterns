package patterns.structural.bridge.code.shapes;

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
