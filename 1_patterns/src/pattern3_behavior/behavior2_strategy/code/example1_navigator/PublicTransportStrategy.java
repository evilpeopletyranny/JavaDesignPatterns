package pattern3_behavior.behavior2_strategy.code.example1_navigator;

/**
 * Конкретная стратегия - маршрут на общественном траснпорте
 */
public class PublicTransportStrategy implements RouteStrategy {

    /**
     * Построение маршрута на общественном транспорте
     *
     * @param start начальная точка
     * @param end   конечная точка
     */
    @Override
    public String buildRoute(String start, String end) {
        return "От точки " + start + " построен маршрут с использованием общественного транспорта до точки " + end;
    }
}
