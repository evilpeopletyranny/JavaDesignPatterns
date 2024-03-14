package patterns.structural.flyweight.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Меню
 */
public class MenuFactory {
    private final Map<String, MenuEntry> menu = new HashMap<>();

    public MenuFactory() {
        menu.put("Pizza Hawaii", new Pizza("Pizza Hawaii"));
        menu.put("Pizza Funghi", new Pizza("Pizza Funghi"));
        menu.put("Pizza Carbonara", new Pizza("Pizza Carbonara"));
        menu.put("Pizza Calzone", new Pizza("Pizza Calzone"));
        menu.put("Salad Caesar", new Salad("Salad Caesar"));
        menu.put("Salad Greek", new Salad("Salad Greek"));
    }

    public MenuEntry getPosition(String position) {
        return menu.get(position);
    }
}
