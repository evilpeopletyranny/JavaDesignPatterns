package pattern3_behavior.strategy.code;

public class Navigator {
    private RouteStrategy routeStrategy;

    public Navigator(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public RouteStrategy getRouteStrategy() {
        return routeStrategy;
    }

    public void setRouteStrategy(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void buildRoute(String start, String end) {
        System.out.println(routeStrategy.buildRoute(start, end));
    }
}
