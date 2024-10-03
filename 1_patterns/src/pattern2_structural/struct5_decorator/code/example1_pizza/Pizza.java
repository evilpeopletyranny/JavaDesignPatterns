package pattern2_structural.struct5_decorator.code.example1_pizza;

/**
 * Базовое описание для разных типов пиццы.
 * Общий интерфейс оберток и оборачиваемых объектов.
 */
public interface Pizza {
    /**
     * @return описание пиццы
     */
    String getDescription();

    /**
     * @return стоимость пиццы
     */
    Double getCost();
}
