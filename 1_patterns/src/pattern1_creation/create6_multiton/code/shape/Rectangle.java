package pattern1_creation.create6_multiton.code.shape;

public class Rectangle implements Shape {
    private String name;

    public Rectangle(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Рисование прямоугольника: " + name);
    }
}
