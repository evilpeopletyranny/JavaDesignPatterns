package pattern1_creation.create6_multiton.code.factory;

import pattern1_creation.create6_multiton.code.shape.Rectangle;
import pattern1_creation.create6_multiton.code.shape.Shape;

public class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape(String name) {
        return new Rectangle(name);
    }
}
