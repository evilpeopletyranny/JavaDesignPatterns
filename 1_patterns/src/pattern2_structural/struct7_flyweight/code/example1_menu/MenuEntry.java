package pattern2_structural.struct7_flyweight.code.example1_menu;

/**
 * Позиция меню
 */
public interface MenuEntry {
    /**
     * Сервировка на стол
     *
     * @param tableNumber номер стола.
     */
    void serve(Integer tableNumber);
}
