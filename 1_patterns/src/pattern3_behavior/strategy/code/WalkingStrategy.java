package pattern3_behavior.strategy.code;

/**
 * Конкретная стратегия - пеший маршрут.
 */
public class WalkingStrategy implements RouteStrategy {

    /**
     * Построение пешего маршрута
     *
     * @param start начальная точка
     * @param end   конечная точка
     */
    @Override
    public String buildRoute(String start, String end) {
        return "От точки " + start + " построен пеший маршрут до точки " + end;
    }
}
