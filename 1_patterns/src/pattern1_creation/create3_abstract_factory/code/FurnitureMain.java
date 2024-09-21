package pattern1_creation.create3_abstract_factory.code;

import pattern1_creation.create3_abstract_factory.code.baroque.BaroqueFurnitureFactory;
import pattern1_creation.create3_abstract_factory.code.gotik.GoticFurnitureFactory;
import pattern1_creation.create3_abstract_factory.code.modern.ModernFurnitureFactory;

public class FurnitureMain {
    public static void main(String[] args) {
        //Под тип абстрактной фабрики засунули фабрику мебели в стиле модерн
        AbstractFurnitureFactory factory = new ModernFurnitureFactory();
        Chair moderChair = factory.createChair();
        Sofa modernSofa = factory.createSofa();
        Table modernTable = factory.createTable();
        System.out.println("Мебель в стиле модерн: " + moderChair + modernSofa + modernTable);

        //Под тип абстрактной фабрики засунули фабрику мебели в стиле готика
        factory = new GoticFurnitureFactory();
        Chair goticChair = factory.createChair();
        Sofa goticSofa = factory.createSofa();
        Table goticTable = factory.createTable();
        System.out.println("Мебель в стиле готика: " + goticChair + goticSofa + goticTable);

        //Под тип абстрактной фабрики засунули фабрику мебели в стиле барокко
        factory = new BaroqueFurnitureFactory();
        Chair baroqueChair = factory.createChair();
        Sofa baroqueSofa = factory.createSofa();
        Table baroqueTable = factory.createTable();
        System.out.println("Мебель в стиле барокко: " + baroqueChair + baroqueSofa + baroqueTable);
    }
}
