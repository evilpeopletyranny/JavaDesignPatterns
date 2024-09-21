package pattern1_creation.create6_multiton.code;

import pattern1_creation.create6_multiton.code.factory.*;

import java.util.EnumMap;
import java.util.Map;

import static pattern1_creation.create6_multiton.code.ShapeType.*;

public class ShapeFactoryMultiton {
    private static final Map<ShapeType, ShapeFactory> instance = new EnumMap<>(ShapeType.class);

    static {
        instance.put(CIRCLE, new CircleFactory());
        instance.put(RECTANGLE, new RectangleFactory());
        instance.put(TRIANGLE, new TriangleFactory());
    }

    // Приватный конструктор для предотвращения создания экземпляров
    private ShapeFactoryMultiton() {
    }

    // Статический метод доступа
    public static synchronized ShapeFactory getInstance(ShapeType type) {
        return instance.get(type);
    }
}
