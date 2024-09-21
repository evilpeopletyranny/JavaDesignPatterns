package pattern2_structural.flyweight.code;

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
