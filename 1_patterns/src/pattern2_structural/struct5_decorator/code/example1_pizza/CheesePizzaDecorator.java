package pattern2_structural.struct5_decorator.code.example1_pizza;

/**
 * Конкретный пример декоратора.
 * Декоратор, добавляющий сыр к нашей пицце.
 */
public class CheesePizzaDecorator extends PizzaDecorator {

    /**
     * Вызов конструктора абстрактного класса.
     */
    public CheesePizzaDecorator(Pizza pizza) {
        super(pizza);
    }

    /**
     * Расширили метод описания.
     * Указали что пицца содержит ещё и сыр.
     *
     * @return расширенное описание.
     */
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese";
    }

    /**
     * Расширение метода подсчета цены.
     * С сыром пицца дороже :(
     *
     * @return расширеная цена
     */
    @Override
    public Double getCost() {
        return pizza.getCost() + 2.00;
    }
}
