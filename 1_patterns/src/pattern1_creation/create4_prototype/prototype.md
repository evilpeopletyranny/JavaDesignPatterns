# Prototype

## Прототип

**Прототип** — это порождающий паттерн проектирования, который позволяет копировать объекты, не вдаваясь в подробности
их реализации.

Прототип особенно полезен при создании сложных или ресурсоемких объектов. Чтобы не создавать индетичный/схожий сложный
объект с нуля, мы просто копируем объект, а затем меняем нужные параметры.

#### Основная идея

Основная идея паттерна Прототип заключается в том, чтобы определить виды объектов, которые могут быть клонированы, и
создать копии этих объектов без привязки к их конкретным классам.

#### Применение

Паттерн Прототип рекомендуется использовать в следующих случаях:

- **Когда создание объекта напрямую является ресурсоёмким**: Если создание объекта требует значительных затрат времени
  или ресурсов, клонирование существующего объекта может быть более эффективным.
- **Когда требуется создать объект, соответствующий определённому состоянию**: Если требуется создать объект с
  определённым состоянием, который уже существует, прототип может служить шаблоном.
- **Когда системы должны быть независимыми от классов создаваемых объектов**: Паттерн Прототип позволяет системе
  создавать объекты без знания о конкретных классах.
- **Когда необходимо динамически добавлять новые виды объектов**: Паттерн позволяет легко расширять систему новыми
  типами объектов путем добавления новых прототипов.

### Реализация

1. Интерфейс прототипов описывает операции клонирования. В большинстве случаев — это единственный метод ```clone```.
2. Конкретный прототип реализует операцию клонирования самого себя. Помимо банального копирования значений всех полей,
   здесь могут быть спрятаны различные сложности, о которых не нужно знать клиенту. Например, клонирование связанных
   объектов, распутывание рекурсивных зависимостей и прочее.
3. Клиент создаёт копию объекта, обращаясь к нему через общий интерфейс прототипов.

#### Реализация в Java

В ЯП **Java** паттерн прототип применяется реализацией интерфейса ```Cloneable``` классом и перегрузкой метода clone().
Отдельное внимание стоит обратить на проблему поверхностого-глубокого копирования.

Конструктор копирования в Java не любят. К тому же добавление в конструктор дополнительных действий по глубокому
копированию не приветсвуется, такие особенности лучше вынести в метод ```clone()```.

**Важно!!!**

1. Метод клон относится к классу ```Object```, также как например ```hashCode()```.
2. Метод клон по умолчанию наследованный от класса ```Object``` выполняет **поверхностное копирование**.
3. Классы, которые поддерживают копирование должны быть помечены маркерным интерфейсом ```Cloneable```.

#### Особенности реализации

1. Операция копирования является потенциально опасной и требует обратки. Метод ```clone()``` наследуется от
   класса ```Object``` и поэтому вроде как поддерживается всеми классами и объектами. Точнее он у них доступен, но по
   умолчанию нереализован.
2. Проверка того что объект может быть клонирован работает за счет маркерного интерфейса ```Cloneable```. Класс, который
   должен копироваться должен реализовывать данный интерфейс иначе вызов метода ```clone()``` вызовет исключение.
3. Для правильного копирования сложных объектов необходимо грамотно работать с глубоким копированием - копированием
   вложенных объектов. Для этого необходимо соблюсти _матрёшку_ правильного определние методов ```clone()```.

### Примеры

#### Проблема с примером из книги Швеца

В книге *Александра Швеца* рассказывается про прототип с общим хранилищем:

1. Это уже частная реализация. Сам паттерн ограничивается только клонированием на самом деле.
2. Это сложно и запутывает для начала.
3. Такую вещь мы рассмотрим в ЛР2, где в Spring такой механизм используется по умолчанию.

#### Пример [AutoMain.java](code%2FAutoMain.java)

Допустим у нас есть относительно сложный объект ```Auto``` и нам необходимо создать идентичный объект, который
отличается лишь одним полем - ```color```.

В таких ситуациях если объект сложный или тяжелый для создания можно воспользоваться паттерном **Прототип** вместо
создания объекта с нуля.

##### Класс ```Auto``` реализующий паттерн Прототип

```java
import java.util.Objects;

/**
 * Класс автомобиля.
 * 10 параметров нужны для иллюстрации удобства использования
 * паттерна Прототип (метод clone и интерфейс Cloneable)
 * <p>
 * При переопределении метода clone важно чтобы соблюдалось следующее:
 * - У объектов разные ссылки prototype != clone
 * - Классы у объектов индетичны prototype.getClass() == clone.getClass()
 * - Объекты индетичны после копирования (для этого надо правильно переопределить equals())
 */
public class Auto implements Cloneable {
    String owner;               //хозяин
    String brand;               //бренд авто
    Engine engine;              //тип двигателя
    Gearbox gearbox;            //тип коробки передач
    Color color;                //цвет автомобиля
    Integer mileage;            //пробег
    Integer seatCapacity;       //кол-во посадочных мест
    Integer wheelCount;         //кол-во колес
    Integer accidentsNumber;    //кол-во аварий
    Long price;                 //стоимость

    public Auto(String owner,
                String brand,
                Engine engine,
                Gearbox gearbox,
                Color color,
                Integer mileage,
                Integer seatCapacity,
                Integer wheelCount,
                Integer accidentsNumber,
                Long price) {
        this.owner = owner;
        this.brand = brand;
        this.engine = engine;
        this.gearbox = gearbox;
        this.color = color;
        this.mileage = mileage;
        this.seatCapacity = seatCapacity;
        this.wheelCount = wheelCount;
        this.accidentsNumber = accidentsNumber;
        this.price = price;
    }

    /**
     * Для проверки правильности копирования переопределим
     * метод equals
     * @param otherObject объект для сравнения
     * @return true если объекты индентичны
     */
    @Override
    public boolean equals(Object otherObject) {
        if (Objects.isNull(otherObject)) return false;
        if (this == otherObject) return true;
        if (getClass() != otherObject.getClass()) return false;

        Auto other = (Auto) otherObject;

        return owner.equals(other.owner) &&
                brand.equals(other.brand) &&
                engine.equals(other.engine) &&
                gearbox.equals(other.gearbox) &&
                color.equals(other.color) &&
                mileage.equals(other.mileage) &&
                seatCapacity.equals(other.seatCapacity) &&
                wheelCount.equals(other.wheelCount) &&
                accidentsNumber.equals(other.accidentsNumber) &&
                price.equals(other.price);
    }

    /**
     * Метод копирования.
     * Сначала см. Engine
     * <p>
     * Поскольку класс Auto в качестве поля содержит класс Engine,
     * то "поверхностного" копирования недостаточно.
     * Такая же проблема может быть при создании конструктора копирования в лоб.
     * Обычно в Java для создания копий предпочитают всё же clone, а не конструктор копирования.
     *
     * @return копию автомобиля
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Auto copy = (Auto) super.clone();           //поверхностно скопировали что можно
        copy.engine = (Engine) this.engine.clone(); //докопировали вложенные объекты
        return copy;
    }

    @Override
    public String toString() {
        return this.getClass() +
                "[owner=" + owner +
                ",brand=" + brand +
                ",engine=" + engine +
                ",gearbox=" + gearbox +
                ",color=" + color +
                ",mileage=" + mileage +
                ",seatCapacity=" + seatCapacity +
                ",wheelCount=" + wheelCount +
                ",accidentsNumber=" + accidentsNumber +
                ",price=" + price +
                "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                owner,
                brand,
                engine,
                gearbox,
                color,
                mileage,
                seatCapacity,
                wheelCount,
                accidentsNumber,
                price
        );
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Gearbox getGearbox() {
        return gearbox;
    }

    public void setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public Integer getWheelCount() {
        return wheelCount;
    }

    public void setWheelCount(Integer wheelCount) {
        this.wheelCount = wheelCount;
    }

    public Integer getAccidentsNumber() {
        return accidentsNumber;
    }

    public void setAccidentsNumber(Integer accidentsNumber) {
        this.accidentsNumber = accidentsNumber;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
```

##### Перечисления ```Color``` и ```GearBox```

Для перечислений паттерн **Прототип** не применим, поскольку каждое значение перечисления имеет только единсвтенный
экземпляр.

```java
public enum Color {
    BLACK,
    GRAY,
    RED
}

public enum Gearbox {
    MANUAL,
    AUTOMATIC
}
```

##### Вложенный класс ```Engine``` - второй уровень матрешки

Чтобы правильно работать с глубоким копированием в собственных классах мы должны правильно переопределить копирование во
вложенных классах.

```java
/**
 * Класс двигателя
 * Обратите внимание, что раз данный класс - record, то
 * методы toString, equals и hashCode для него по умолчанию переопределяются
 * правильно.
 * Это пригодиться при реализации данных методов в классе Auto
 *
 * @param hp     лошадиные силы
 * @param volume объекм
 */
public record Engine(Integer hp,
                     Integer volume) implements Cloneable {
    /**
     * Метод копирования.
     * <p>
     * super.clone(); - выполянет поверхностное копирование.
     * И поскольку в классе двигателя все поля являются примитивами
     * поверхностного копирования достаточно.
     *
     * @return копия двигателя
     * @throws CloneNotSupportedException копируемые объекты не поддерживают Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

### Плюсы данного паттерна

- **Повышение производительности**: Создание копий объектов может быть быстрее, чем их создание с нуля, особенно если
  объект сложный.
- **Гибкость и расширяемость**: Легко добавлять новые типы прототипов без изменения клиентского кода.
- **Изоляция процессов создания**: Клиентский код не зависит от конкретных классов создаваемых объектов.
- **Упрощение кода**: Избегание использования длинных цепочек конструкторов для создания объектов с множеством
  параметров.

### Недостатки данного паттерна

- **Сложность реализации**: Необходимо правильно реализовать метод ```clone()```, особенно для глубокого клонирования.
- **Проблемы с наследованием**: Клонирование может стать сложным, если классы имеют сложную иерархию наследования.
- **Слабая совместимость с языком**: В Java механизм клонирования с использованием ```Cloneable``` и
  метода ```clone()``` считается несколько устаревшим и неудобным по сравнению с альтернативными методами копирования.
- **Проблемы с безопасностью**: Некорректное клонирование может привести к нарушению инвариантов объекта или к утечкам
  данных.

### Источники

- Design Patterns with Java: [Factory Method](books%2FOlaf%20Musch%20EN.pdf)
- Введение в паттерны проектирования: [Фабричный метод](books%2FAlexander%20Shvets%20RU.pdf)
- [JavaRush: Шаблон проектирования Prototype: реализация на Java.](https://javarush.com/groups/posts/6488-kofe-breyk-259-shablon-proektirovanija-prototype-realizacija-na-java-funkcionaljhnihe-interfeys)
