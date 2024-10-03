package pattern2_structural.struct3_bridge.code.example1_shapes;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(new RedColor());
        rect.draw();

        System.out.println("---------------");

        Shape triangle = new Triangle(new GreenColor());
        triangle.draw();
    }
}
