package pattern2_structural.struct3_bridge.code.example1_shapes;

/**
 * Класс Shape представляет собой Абстракцию — механизм управления раскраской фигур в различные цвета, который
 * делегирует Реализацию интерфейсу Color.
 * "Абстракция"
 * <p>
 * Отдается предпочтение абстрактному классу вместо интерфейса из-за возможности
 * указания полей.
 */
public abstract class Shape {
    protected Color color;      //реализация цвета

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}