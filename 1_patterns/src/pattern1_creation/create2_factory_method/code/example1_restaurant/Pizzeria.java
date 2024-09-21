package pattern1_creation.create2_factory_method.code.example1_restaurant;

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
