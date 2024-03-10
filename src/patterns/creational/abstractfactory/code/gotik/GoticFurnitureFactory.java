package patterns.creational.abstractfactory.code.gotik;

import patterns.creational.abstractfactory.code.AbstractFurnitureFactory;
import patterns.creational.abstractfactory.code.Chair;
import patterns.creational.abstractfactory.code.Sofa;
import patterns.creational.abstractfactory.code.Table;

/**
 * Фабрика мебели в стиле готика.
 * Сигнатура методов должна также работать с общими типами,
 * но при этом возвращаем мы уже элементы мебели в стиле готика.
 */
public class GoticFurnitureFactory implements AbstractFurnitureFactory {
    /**
     * Создание дивана в стиле готика
     *
     * @return диван в стиле готика
     */
    @Override
    public Sofa createSofa() {
        return new GoticSofa();
    }

    /**
     * Создание кресла в стиле готика
     *
     * @return кресло в стиле готика
     */
    @Override
    public Chair createChair() {
        return new GoticChair();
    }

    /**
     * Создание стола в стиле готика
     *
     * @return стол в стиле готика
     */
    @Override
    public Table createTable() {
        return new GoticTable();
    }
}
