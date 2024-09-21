package pattern1_creation.create2_factory_method.code.example1_restaurant;

/**
 * Бургерная.
 */
public class BurgerHouse extends Restaurant {
    @Override
    protected String takeOrder() {
        return "Принят заказ на бургер!";
    }

    /**
     * Реализация фабричного метода для создания бургера.
     * @return бургер
     */
    @Override
    protected Meal prepareMeal() {
        return new Burger();
    }
}
