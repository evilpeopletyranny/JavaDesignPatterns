package patterns.creational.factorymethod.code;

/**
 * Пиццерия
 */
public class Pizzeria extends Restaurant {
    @Override
    protected String takeOrder() {
        return "Принят заказ на пиццу!";
    }

    @Override
    protected Meal prepareMeal() {
        return new Pizza();
    }
}
