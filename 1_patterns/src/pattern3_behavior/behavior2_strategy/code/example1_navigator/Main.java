package pattern3_behavior.behavior2_strategy.code.example1_navigator;

/**
 * Простой пример с навигатором и
 * стратегиями построения маршрута.
 */
public class Main {
    public static void main(String[] args) {
        //навигатор со стратегией автомобильного маршурта
        Navigator navigator = new Navigator(new RoadStrategy());
        navigator.buildRoute("A", "B");

        //сменили стратегию на общественный транспорт
        navigator.setRouteStrategy(new PublicTransportStrategy());
        navigator.buildRoute("A", "B");

        //сменили стратегию на пеший ход
        navigator.setRouteStrategy(new WalkingStrategy());
        navigator.buildRoute("A", "B");
    }
}
