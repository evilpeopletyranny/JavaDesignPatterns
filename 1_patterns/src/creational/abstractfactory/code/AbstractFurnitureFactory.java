package creational.abstractfactory.code;

/**
 * Интерфейс асбтрактной фабрики мебели.
 * В методаз используются общие типы, что позволяет достичь слабойсвязанности
 * (не привязываться к определенным реализациям классов)
 */
public interface AbstractFurnitureFactory {
    /**
     * Метод создания какого-то дивана
     *
     * @return диван
     */
    Sofa createSofa();

    /**
     * Метод создания какого-то кресла
     *
     * @return кресло
     */
    Chair createChair();

    /**
     * Метод создания какого-то стола
     *
     * @return стол
     */
    Table createTable();
}
