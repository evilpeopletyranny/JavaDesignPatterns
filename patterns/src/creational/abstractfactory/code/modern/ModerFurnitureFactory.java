package creational.abstractfactory.code.modern;

import creational.abstractfactory.code.AbstractFurnitureFactory;
import creational.abstractfactory.code.Chair;
import creational.abstractfactory.code.Sofa;
import creational.abstractfactory.code.Table;

/**
 * Фабрика мебели в стиле модерн.
 * Сигнатура методов должна также работать с общими типами,
 * но при этом возвращаем мы уже элементы мебели в стиле модерн.
 */
public class ModerFurnitureFactory implements AbstractFurnitureFactory {
    /**
     * Создание дивана в стиле модерн
     *
     * @return диван в стиле модерн
     */
    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    /**
     * Создание кресла в стиле модерн
     *
     * @return кресло в стиле модерн
     */
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    /**
     * Создание стола в стиле модерн
     *
     * @return стол в стиле модерн
     */
    @Override
    public Table createTable() {
        return new ModernTable();
    }
}