package pattern3_behavior.behavior7_visitor.code.example2_figure;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Element> shapes = List.of(
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Circle(3.5),
                new Rectangle(2.0, 3.0)
        );

        PrintVisitor printer = new PrintVisitor();

        for(Element shape : shapes) {
            shape.accept(printer);
        }
    }
}
