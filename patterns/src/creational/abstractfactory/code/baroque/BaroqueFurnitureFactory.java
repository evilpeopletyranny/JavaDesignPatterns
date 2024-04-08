package creational.abstractfactory.code.baroque;

import creational.abstractfactory.code.AbstractFurnitureFactory;
import creational.abstractfactory.code.Chair;
import creational.abstractfactory.code.Sofa;
import creational.abstractfactory.code.Table;

/**
 * Фабрика мебели в стиле барокко.
 * Сигнатура методов должна также работать с общими типами,
 * но при этом возвращаем мы уже элементы мебели в стиле барокко.
 */
public class BaroqueFurnitureFactory implements AbstractFurnitureFactory {
    /**
     * Создание дивана в стиле барокко
     *
     * @return диван в стиле барокко
     */
    @Override
    public Sofa createSofa() {
        return new BaroqueSofa();
    }

    /**
     * Создание кресла в стиле барокко
     *
     * @return кресло в стиле барокко
     */
    @Override
    public Chair createChair() {
        return new BaroqueChair();
    }

    /**
     * Создание стола в стиле барокко
     *
     * @return стол в стиле барокко
     */
    @Override
    public Table createTable() {
        return new BaroqueTable();
    }
}
