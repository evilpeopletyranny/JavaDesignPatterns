package pattern2_structural.decorator.code;

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
