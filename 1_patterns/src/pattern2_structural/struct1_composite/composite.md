# Composite

## Компоновщик

**Компоновщик** — это структурный паттерн проектирования, который позволяет сгруппировать объекты в древовидную
структуру, а затем работать с ними так, если бы это был единичный объект.

В разработке программного обеспечения часто необходимо представлять иерархические структуры объектов, где отдельные
элементы и их композиции должны обрабатываться единообразно. Паттерн проектирования Компоновщик (Composite)
предоставляет решение этой задачи, позволяя клиентам работать с отдельными объектами и их композициями одинаково. Это
повышает гибкость и упрощает управление сложными структурами.

Паттерн Компоновщик имеет смысл только тогда, когда основная модель вашей программы может быть структурирована в виде
дерева.

#### Основная идея

Основная идея паттерна Компоновщик заключается в том, чтобы создать единый интерфейс для работы как с простыми, так и с
составными объектами. Это достигается путем определения общего интерфейса или абстрактного класса для всех элементов
иерархии, включая как "листья" (простые объекты), так и "композиты" (составные объекты, содержащие другие элементы).

#### Применение

Паттерн Компоновщик рекомендуется использовать в следующих случаях:

- Необходимо представить иерархическую структуру объектов.
- Хочется, чтобы клиенты могли одинаково обращаться к отдельным объектам и их композициям.
- Необходимо добавить новые виды объектов, не изменяя существующий код.
- Структура иерархии должна быть гибкой и расширяемой.

### Реализация

1. Убедитесь, что вашу бизнес-логику можно представить как древовидную структуру. Попытайтесь разбить её на простые
   элементы и контейнеры. Помните, что контейнеры могут содержать как простые элементы, так и другие контейнеры.
2. Создайте общий интерфейс компонентов, который объединит операции контейнеров и простых элементов дерева. Интерфейс
   будет удачным, если вы сможете взаимозаменять простые и составные компоненты без потери смысла.
3. Создайте класс компонентов-листьев, не имеющих дальнейших ответвлений. Имейте в виду, что программа может содержать
   несколько видов таких классов.
4. Создайте класс компонентов-контейнеров, и добавьте в него массив для хранения ссылок на вложенные компоненты. Этот
   массив должен быть способен содержать как простые, так и составные компоненты, поэтому убедитесь, что он объявлен с
   типом интерфейса компонентов. Реализуйте в контейнере методы интерфейса компонентов, помня о том, что контейнеры
   должны делегировать основную работу своим дочерним компонентам.
5. Добавьте операции добавления и удаления дочерних элементов в класс контейнеров. Имейте в виду, что методы
   добавления/удаления дочерних элементов можно поместить и в интерфейс компонентов. Да, это нарушит принцип разделения
   интерфейса, так как реализации методов будут пустыми в компонентах-листьях. Но зато все компоненты дерева станут
   действительно одинаковыми для клиента.

### Примеры

#### ```javax.swing``` (Swing)

**Swing** — это библиотека для создания графических пользовательских интерфейсов (GUI) в Java. Она широко использует
паттерн Компоновщик для организации компонентов интерфейса. (На самом деле любая библиотека для создания GUI построена
по такому же принципу)

- **Component (Компонент)**: Абстрактный класс ```JComponent```.
- **Leaf (Лист)**: Конкретные компоненты, такие как ```JButton```, ```JLabel```, ```JTextField```.
- **Composite (Композит)**: Контейнеры, такие как ```JPanel```, ```JFrame```, которые могут содержать другие компоненты.

#### [Пример](code%2FMain.java) иерархии упаковок товаров

Преположим нам неоьходимо создать систему для обсчета стоиомсти товаров. Товары могут храниться как в шутчном виде, так
и несколько разных товаров в коробке. Ценой коробки считается сумма всех товаров внутри коробки.

```java
/**
 * Общий интерфейс элементов дерева.
 */
public interface Node {
    /**
     * Каждый элемент должен уметь посчитать свою цену.
     * Некоторое общее дейсвтие для всех компонентов, в диаграмме эта функция
     * называется execute()
     *
     * @return цена
     */
    Integer calcCost();

    /**
     * Пусть каждый элемент может возвращать родителя
     *
     * @return родитель
     */
    Node getParent();

    /**
     * Имеем возможность задать родителя
     *
     * @param parent родитель
     */
    void setParent(Node parent);
}
```

```java
/**
 * Интерфейс узла контейнера.
 * Может содержать как листы, так и другие контейнеры.
 */
public interface Container extends Node {
    /**
     * Добавление элемента в контейнер
     * @param node элемент, который будет добавлен
     */
    void add(Node node);

    /**
     * Удалить элемент из контейнера
     * @param node элемент для удаления
     */
    void remove(Node node);

    /**
     * @return список детей
     */
    List<Node> getChildren();
}
```

```java
/**
 * Коробка, которая содержит товары.
 * Сама по себе коробка не имеет цены.
 * Цена коробки складывается из цены товаров в ней
 */
public class Box implements Container {
    private Node parent;                //родитель
    private List<Node> children;  //список детей

    /**
     * Создание пустой коробки
     *
     * @param parent родитель
     */
    public Box(Node parent) {
        this.parent = parent;
        children = new LinkedList<>();
    }

    /**
     * Добавление узла
     *
     * @param node элемент, который будет добавлен
     */
    @Override
    public void add(Node node) {
        children.add(node);
    }

    /**
     * Удаление узла
     *
     * @param node элемент для удаления
     */
    @Override
    public void remove(Node node) {
        children.remove(node);
    }

    /**
     * Получение родителя
     *
     * @return children
     */
    @Override
    public List<Node> getChildren() {
        return children;
    }

    /**
     * Подсчет стоимости товаров в коробке.
     * Если в коробке в меньшая коробка, то происходит обсчет
     * меньшей коробки и тд
     *
     * @return цена
     */
    @Override
    public Integer calcCost() {
        int res = 0;
        for (var item : children) res += item.calcCost();
        return res;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(parent, box.parent) && Objects.equals(children, box.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, children);
    }

    @Override
    public String toString() {
        return "Box{" +
                "parent=" + parent +
                ", children=" + children +
                '}';
    }
}
```

```java
/**
 * Конечный элемент иерархии - лист.
 */
public interface Leaf extends Node {
}
```

```java
/**
 * Товар - конечный элемент
 */
public class Item implements Leaf {
    private Node parent;        //родитель
    private Integer cost;       //цена товара

    /**
     * All parameters constructor
     * @param parent родительский элемент
     * @param cost цена товара
     */
    public Item(Node parent, Integer cost) {
        this.parent = parent;
        this.cost = cost;
    }

    public Item(Integer cost) {
        this.cost = cost;
    }

    @Override
    public Integer calcCost() {
        return cost;
    }

    @Override
    public Node getParent() {
        return parent;
    }

    @Override
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(parent, item.parent) && Objects.equals(cost, item.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, cost);
    }

    @Override
    public String toString() {
        return "Item{" +
                "parent=" + parent +
                ", cost=" + cost +
                '}';
    }
}
```

### Плюсы данного паттерна

- **Простота использования:** Клиенты могут взаимодействовать с отдельными объектами и их композициями одинаково,
  упрощая код.
- **Гибкость структуры:** Легко добавлять новые виды компонентов и композитов без изменения существующего кода.
- **Повторное использование кода:** Общие операции могут быть реализованы в базовом компоненте, уменьшая дублирование.
- **Упрощение кода клиента:** Клиенты не нуждаются в проверке типа объекта; они работают через общий интерфейс.

### Недостатки данного паттерна

- **Сложность реализации:** Для небольших систем использование паттерна Компоновщик может быть избыточным.
- **Производительность:** Рекурсивные вызовы могут влиять на производительность при работе с большими иерархиями.
- **Ограниченная функциональность:** Некоторые специфические операции могут требовать дополнительной обработки или
  обхода иерархии.

### Заключение

Паттерн проектирования **Компоновщик** предоставляет мощный механизм для организации иерархических структур объектов,
обеспечивая единообразное взаимодействие с ними. Он широко применяется в различных областях разработки, включая
графические интерфейсы, файловые системы и коллекции.

Понимание и правильное применение паттерна Компоновщик способствует созданию гибких, расширяемых и легко поддерживаемых
систем. Однако, как и любой паттерн, его следует применять осознанно, учитывая требования и особенности конкретного
проекта.

### Источники

- Design Patterns with
  Java: Composite
- Введение в паттерны
  проектирования: Компоновщик