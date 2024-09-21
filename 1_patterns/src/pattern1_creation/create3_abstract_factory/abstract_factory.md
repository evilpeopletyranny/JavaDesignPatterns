# Abstract Factory

## Абстрактная фабрика

**Абстрактная фабрика** — это порождающий паттерн проектирования, который позволяет создавать семейства связанных
объектов, не привязываясь к конкретным классам создаваемых объектов.

Зачастую асбтрактная фабрика рождается из фабричного метода, когда необходимо добавить новыый продукт. В хорошей
программе, каждый класс отвечает только за одну вещь. Если класс имеет слишком много фабричных методов, они способны
затуманить его основную функцию. Поэтому имеет смысл вынести всю логику создания продуктов в отдельную иерархию классов,
применив абстрактную фабрику.

Абстрактная фабрика скрывает от клиентского кода подробности того, как и какие конкретно объекты будут созданы. Но при
этом клиентский код может работать со всеми типами создаваемых продуктов, так как их общий интерфейс был заранее
определён.

#### Основная идея

Основная цель паттерна Абстрактная Фабрика — **изолировать создание объектов от их использования**, обеспечивая таким
образом независимость клиентского кода от конкретных классов продуктов. Это позволяет легко добавлять новые семейства
продуктов без изменения существующего кода.

#### Применение

Паттерн Абстрактная Фабрика рекомендуется использовать в следующих случаях:

- Когда система должна быть независимой от способа создания, композиции и представления её объектов.
- Когда система должна работать с различными семействами взаимосвязанных объектов, не завися от их конкретных классов.
- Когда необходимо обеспечить согласованность создаваемых объектов (например, все элементы интерфейса принадлежат к
  одному стилю).
- Когда нужно добавить новые семейства продуктов без изменения существующего кода.

### Реализация

1. Абстрактные продукты объявляют интерфейсы продуктов, которые связаны друг с другом по смыслу, но выполняют разные
   функции.
2. Конкретные продукты — большой набор классов, которые относятся к различным абстрактным продуктам (кресло/ столик), но
   имеют одни и те же вариации (Барокко/Модерн).
3. Абстрактная фабрика объявляет методы создания различных абстрактных продуктов (кресло/столик).
4. Конкретные фабрики относятся каждая к своей вариации
   продуктов (Барокко/Модерн) и реализуют методы абстрактной фабрики, позволяя создавать все продукты определённой
   вариации.
5. Несмотря на то, что конкретные фабрики порождают конкретные продукты, сигнатуры их методов должны возвращать
   соответствующие абстрактные продукты. Это позволит клиентскому коду, использующему фабрику, не привязываться к
   конкретным классам продуктов. Клиент сможет работать с любыми вариациями продуктов через абстрактные интерфейсы.

### Примеры

#### Пример [FurnitureMain](code%2FFurnitureMain.java)

Создадим систему, которая может создавать кресла, столы и диваны в разных стилях: Барокко, Готика, Модерн.

##### AbstractProduct: Интерфейсы для продуктов

Определим интерфейсы производимых продуктов.

```java
/**
 * Общий интерфейс кресел
 */
public interface Chair {
}

/**
 * Общий интерфейс диванов
 */
public interface Sofa {
}

/**
 * Общий интерфейс столов
 */
public interface Table {
}
```

##### ConcreteProduct: Конкретные реализации продуктов для разных стилей

**Барокко**

```java
/**
 * Кресло в стиле барокко
 */
public record BaroqueChair() implements Chair {
}

/**
 * Диван в стиле барокко
 */
public record BaroqueSofa() implements Sofa {
}

/**
 * Стол в стиле барокко
 */
public record BaroqueTable() implements Table {
}
```

**Готика**

```java
/**
 * Кресло в стиле готика
 */
public record GoticChair() implements Chair {
}

/**
 * Диван в стиле готика
 */
public record GoticSofa() implements Sofa {
}

/**
 * Стол в стиле готика
 */
public record GoticTable() implements Table {
}
```

**Модерн**

```java
/**
 * Кресло в стиле модерн
 */
public record ModernChair() implements Chair {
}

/**
 * Диван в стиле модерн
 */
public record ModernSofa() implements Sofa {
}

/**
 * Стол в стиле модерн
 */
public record ModernTable() implements Table {
}
```

##### AbstractFactory: Интерфейс Абстрактной Фабрики

```java
/**
 * Интерфейс асбтрактной фабрики мебели.
 * В методах используются общие типы, что позволяет достичь слабойсвязанности
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
```

##### ConcreteFactory: Конкретные фабрики для разных стилей

**Барокко**

```java
import pattern1_creation.create3_abstract_factory.code.AbstractFurnitureFactory;
import pattern1_creation.create3_abstract_factory.code.Chair;
import pattern1_creation.create3_abstract_factory.code.Sofa;
import pattern1_creation.create3_abstract_factory.code.Table;

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
```

**Готика**

```java
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
```

**Модерн**

```java
import pattern1_creation.create3_abstract_factory.code.AbstractFurnitureFactory;
import pattern1_creation.create3_abstract_factory.code.Chair;
import pattern1_creation.create3_abstract_factory.code.Sofa;
import pattern1_creation.create3_abstract_factory.code.Table;

/**
 * Фабрика мебели в стиле модерн.
 * Сигнатура методов должна также работать с общими типами,
 * но при этом возвращаем мы уже элементы мебели в стиле модерн.
 */
public class ModernFurnitureFactory implements AbstractFurnitureFactory {
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
```

##### Класс для тестирования

```java
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
```

### Плюсы данного паттерна

- **Согласованность семейства продуктов**: Паттерн обеспечивает создание совместимых объектов из одного семейства, что
  предотвращает ошибки, связанные с несовместимостью компонентов.
- **Гибкость и расширяемость**: Позволяет легко добавлять новые семейства продуктов без изменения существующего
  клиентского кода.
- **Снижение связанности**: Клиентский код зависит только от абстракций, а не от конкретных реализаций продуктов, что
  упрощает поддержку и модификацию кода.
- **Изоляция от конкретных классов**: Клиентский код не знает о конкретных классах создаваемых объектов, что позволяет
  изменять реализации без влияния на клиента.

### Недостатки данного паттерна

- **Увеличение количества классов**: Для каждого нового семейства продуктов необходимо создавать новую фабрику, что
  может привести к увеличению числа классов в проекте.
- **Сложность понимания**: Для новичков паттерн может показаться сложным из-за использования абстрактных классов и
  интерфейсов.
- **Необходимость знания всех продуктов**: Все продукты, которые могут быть созданы фабрикой, должны быть известны
  заранее, что ограничивает динамическое добавление новых продуктов.

### Источники

- Design Patterns with Java: [Olaf Musch EN.pdf](books%2FOlaf%20Musch%20EN.pdf)
- Введение в паттерны проектирования: [Абстрактная фабрика](books%2FAlexander%20Shvets%20RU.pdf)