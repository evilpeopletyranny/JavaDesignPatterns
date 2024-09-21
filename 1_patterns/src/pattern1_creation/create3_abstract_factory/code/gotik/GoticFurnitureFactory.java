package pattern1_creation.create3_abstract_factory.code.gotik;

import pattern1_creation.create3_abstract_factory.code.AbstractFurnitureFactory;
import pattern1_creation.create3_abstract_factory.code.Chair;
import pattern1_creation.create3_abstract_factory.code.Sofa;
import pattern1_creation.create3_abstract_factory.code.Table;

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
