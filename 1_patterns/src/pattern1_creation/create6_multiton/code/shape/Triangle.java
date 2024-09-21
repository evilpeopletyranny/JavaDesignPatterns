package pattern1_creation.create6_multiton.code.shape;

public class Triangle implements Shape {
    private String name;

    public Triangle(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Рисование треугольника: " + name);
    }
}
