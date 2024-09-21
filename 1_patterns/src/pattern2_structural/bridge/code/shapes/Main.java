package pattern2_structural.bridge.code.shapes;

public class Main {
    public static void main(String[] args) {
        Shape rect = new Rectangle(new RedColor());
        rect.draw();

        System.out.println("---------------");

        Shape triangle = new Triangle(new GreenColor());
        triangle.draw();
    }
}
