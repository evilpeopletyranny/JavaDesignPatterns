package pattern1_creation.create6_multiton.code.shape;

public class Circle implements Shape {
    private String name;

    public Circle(String name) {
        this.name = name;
    }

    @Override
    public void draw() {
        System.out.println("Рисование круга: " + name);
    }
}
