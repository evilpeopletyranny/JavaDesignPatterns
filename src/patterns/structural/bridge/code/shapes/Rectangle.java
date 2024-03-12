package patterns.structural.bridge.code.shapes;

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
