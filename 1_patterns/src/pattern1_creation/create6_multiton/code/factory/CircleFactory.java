package pattern1_creation.create6_multiton.code.factory;

import pattern1_creation.create6_multiton.code.shape.Circle;
import pattern1_creation.create6_multiton.code.shape.Shape;

public class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape(String name) {
        return new Circle(name);
    }
}

