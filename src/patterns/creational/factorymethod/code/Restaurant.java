package patterns.creational.factorymethod.code;

/**
 * Абстрактный клласс ресторана
 * Нас интересует метод prepareMeal()
 */
public abstract class Restaurant {

    /**
     * Уведомление о принятии заказа.
     */
    protected abstract String takeOrder();

    /**
     * Фабричный метод!
     * В завивисимости от реализации будет возвращать разные типы
     * еды.
     * @return конкретная реализация еды.
     */
    protected abstract Meal prepareMeal();

    /**
     * Подача блюда
     * @param meal блюдо
     */
    private void serveMeal(Meal meal) {
        System.out.println("Еда готова! Ваш: " + meal);
    }

    /**
     * Обработка заказа
     * @return блюдо
     */
    public final Meal order() {
        var order = takeOrder();
        var meal = prepareMeal();
        serveMeal(meal);
        return meal;
    }
}
