package pattern1_creation.create6_multiton.code.factory;

import pattern1_creation.create6_multiton.code.shape.Shape;

public interface ShapeFactory {
    Shape createShape(String name);
}
