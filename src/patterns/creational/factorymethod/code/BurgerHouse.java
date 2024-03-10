package patterns.creational.factorymethod.code;

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
