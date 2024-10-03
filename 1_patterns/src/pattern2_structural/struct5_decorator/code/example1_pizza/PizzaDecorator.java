package pattern2_structural.struct5_decorator.code.example1_pizza;

/**
 * Асбтрактный класс деокартор, через который будут создваться конкретные
 * декораторы.
 * Декоратор должен:
 * 1. Реализовывать тот же интерфейс, что и оборачиваемые классы.
 * 2. Содержать поле с классом, который будет обарачиваться.
 */
public abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}
