# Visitor

## Посетитель

**Посетитель** — это поведенческий паттерн проектирования, который позволяет создавать новые операции, не меняя классы
объектов, над которыми эти операции могут выполняться.

*Паттерн хороший, но имеет неприятный краевой случай про который буде описано далее.*

#### Основная идея

Паттерн Посетитель позволяет определить новую операцию без изменения классов объектов, над которыми эта операция будет
выполняться. Это достигается путем добавления метода accept в иерархию объектов, который принимает посетителя и вызывает
соответствующий метод у него.

#### Применение

- Когда вам нужно выполнить операцию над всеми элементами сложной структуры объектов (например, деревом).
- Когда над объектами сложной структуры объектов надо выполнять некоторые, не связанные между собой операций, но вы не
  хотите «засорять» классы такими операциями.
- Когда новое поведение имеет смысл только для некоторых классов из существующей иерархии.

### Реализация

1. Создайте интерфейс посетителя и объявите в нём методы «посещения» для каждого класса компонента, который необходимо
   посетить.
2. Опишите интерфейс компонентов. Если вы работаете с уже существующими классами, то объявите абстрактный метод принятия
   посетителей в базовом классе иерархии компонентов.
3. Если есть возможность: Реализуйте методы принятия во всех конкретных компонентах. Они должны переадресовывать вызовы
   тому методу посетителя, в котором класс параметра совпадает с текущим классом компонента - метод двойной
   диспетчеризации.
4. Иерархия компонентов должна знать только о базовом интерфейсе посетителей. С другой стороны, посетители будут знать
   обо всех классах компонентов.
5. Для каждого нового поведения создайте свой конкретный класс. Приспособьте это поведение для всех посещаемых
   компонентов, реализовав все методы интерфейса посетителей.
6. Клиент будет создавать объекты посетителей, а затем передавать их компонентам, используя метод принятия.

### Механизм двойной диспетчеризации

*Кратко, как это имеется в виду в данном паттерне:*

В класс, который мы посещаем добавляться метод принятия посетителя ```accept(Visitor visitor)```, внутри которого
происходит передача данного элемента в посетитель:

```
foreach (Node node : graph)
    node.accept(exportVisitor);
    
class Type1:
    method accept(Visitor v) is
        v.doForType1(this);
```

### Краевой случай - классы недоступные для изменения

Проблема с данным паттерном начинаются когда классы, которые мы хотим посещать не доступны для изменения и не имеет в
себе методов для принятия посетителя. В таком случае мы не можем воспользоваться/реализовать метод двойной
диспетчеризации и код превращается в большой набор условных операторов проверки типа:

```
foreach (Node node : graph)
    if (node instanceof Type1)
        exportVisitor.doForType1((Type1) node);
    if (node instanceof Type2)
        exportVisitor.doForType2((Type2) node);
```

### Примеры

#### Примеры стандртной Java библиотеки

- В библиотеке ```javax.swing``` некоторые компоненты используют концепцию посетителя для обработки событий или обхода
  компонентов. Например, методы обхода иерархии компонентов могут напоминать паттерн Посетитель.

#### [Пример](code%2Fexample2_figure%2FMain.java) с обходом фигур

**Цель:** Создать структуру, содержащую различные геометрические фигуры (```Circle```, ```Rectangle```), и реализовать
посетителя, который выполняет операцию печати информации о каждой фигуре.

--- 

**Интерфейсы ```Visitor``` и ```Element```:** Определяют контракт для посетителей и элементов фигур.

```java
public interface Visitor {
    void visitCircle(Circle circle);

    void visitRectangle(Rectangle rectangle);
}
```

```java
public interface Element {
    void accept(Visitor visitor);
}
```

---

**Классы ```Circle``` и ```Rectangle```:** Реализуют интерфейс ```Element``` и предоставляют метод ```accept```, который
принимает посетителя

```java
public class Circle implements Element {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}
```

```java
public class Rectangle implements Element {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}
```

--- 

**Класс ```PrintVisitor```:** Реализует интерфейс ```Visitor``` и выполняет конкретную операцию — печать информации о
фигуре.

```java
public class PrintVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("Circle with radius: " + circle.getRadius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("Rectangle with width: " + rectangle.getWidth() +
                " and height: " + rectangle.getHeight());
    }
}
```

---

```java
public class Main {
    public static void main(String[] args) {
        List<Element> shapes = List.of(
                new Circle(5.0),
                new Rectangle(4.0, 6.0),
                new Circle(3.5),
                new Rectangle(2.0, 3.0)
        );

        PrintVisitor printer = new PrintVisitor();

        for (Element shape : shapes) {
            shape.accept(printer);
        }
    }
}
```

---

### Плюсы данного паттерна

- Упрощает добавление новых операций над всей связанной структурой объектов.
- Объединяет родственные операции в одном классе.
- Посетитель может накоплять состояние при обходе структуры компонентов.

### Недостатки данного паттерна

- Паттерн неоправдан, если иерархия компонентов часто меняется.
- Может привести к нарушению инкапсуляции компонентов.
- Сложная реализация если классы компонентов не доступны для изменения.

### Сравнение с другими паттернами

Конечно паттерн **Посетитель** с первого взгляда может быть поход на **Итератор** - и там и там мы обходим элементы, но
на самом деле они имеют принципальные отличия:

**Итератор** задает порядок обхода элемента и предоставляет клиентскому коду возможность воспользоваться этим
обходом - ```иетратором```.

**Посетитель** никак не связан с порядком обхода. Суть посетителя это выполнение действий с/над данными элементам.

Паттерны хорошо синергируют, когда при помощи **Итератора** мы задаем порядок обхода. Используя **Итератор** для обхода
**Посетитель** выполняет действия над данными.

### Заключение

**Паттерн Посетитель (Visitor)** предоставляет мощный способ разделения алгоритмов и объектов, над которыми они
выполняются. Он особенно полезен при работе со сложными структурами объектов, позволяя легко добавлять новые операции
без изменения их классов. Однако, как и любой паттерн, он имеет свои преимущества и недостатки, и его применение должно
быть обосновано конкретными требованиями проекта.

### Источники

- [Wikipedia: Двойная диспетчеризация.](https://en.wikipedia.org/wiki/Double_dispatch)
- Design Patterns with Java: Visitor
- Введение в паттерны проектирования: Посетитель