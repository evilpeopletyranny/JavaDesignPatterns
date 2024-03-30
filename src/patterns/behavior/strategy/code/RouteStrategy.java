package patterns.behavior.strategy.code;

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