package pattern1_creation.create6_multiton.code.factory;

import pattern1_creation.create6_multiton.code.shape.Shape;
import pattern1_creation.create6_multiton.code.shape.Triangle;

public class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(String name) {
        return new Triangle(name);
    }
}
