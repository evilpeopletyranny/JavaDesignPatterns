package pattern2_structural.struct5_decorator.code.example1_pizza;

/**
 * Пример того, что при помощи декоратора можно не только добавлять и
 * расширять функционал, но и обрезать/уменьшать его.
 * Декоратор, убирающий сыр из нашей пиццы.
 */
public class NonCheeseDecorator extends PizzaDecorator {

    public NonCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    /**
     * Убираем сыр из описания пиццы.
     *
     * @return описание без сыра.
     */
    @Override
    public String getDescription() {
        return pizza.getDescription().replace(", Cheese", "");
    }

    /**
     * Пицца без сыра дешевле.
     *
     * @return цена пиццы без сыра.
     */
    @Override
    public Double getCost() {
        return pizza.getCost() - 2.00;
    }
}
