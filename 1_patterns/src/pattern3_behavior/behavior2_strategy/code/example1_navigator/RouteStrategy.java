package pattern3_behavior.behavior2_strategy.code.example1_navigator;

/**
 * общий интерфейс стратегий маршрута.
 */
public interface RouteStrategy {
    /**
     * Метод построение маршрута
     *
     * @param start начальная точка
     * @param end   конечная точка
     */
    String buildRoute(String start, String end);
}