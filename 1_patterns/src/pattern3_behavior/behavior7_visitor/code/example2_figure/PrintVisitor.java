package pattern3_behavior.behavior7_visitor.code.example2_figure;

public class PrintVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Rectangle with width: " + rectangle.getWidth() +
                " and height: " + rectangle.getHeight());
    }
}
