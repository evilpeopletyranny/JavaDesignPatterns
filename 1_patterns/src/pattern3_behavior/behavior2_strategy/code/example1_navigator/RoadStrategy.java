package pattern3_behavior.behavior2_strategy.code.example1_navigator;

/**
 * Конкретная стратегия - автомобильный маршрут.
 */
public class RoadStrategy implements RouteStrategy {

    /**
     * Построение автомобильного маршрута.
     *
     * @param start начальная точка
     * @param end   конечная точка
     */
    @Override
    public String buildRoute(String start, String end) {
        return "От точки " + start + " построен автомобильный маршрут до точки " + end;
    }
}
