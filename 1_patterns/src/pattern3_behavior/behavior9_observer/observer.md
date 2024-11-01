# Observer

## Наблюдатель

Паттерн **Observer (Наблюдатель)** — это поведенческий паттерн проектирования, который используется, когда один объект
должен автоматически уведомлять другой объект о любых изменениях его состояния. Этот паттерн реализует принцип "один ко
многим" и позволяет объекту (называемому наблюдаемый или subject) уведомлять подписанные на него объекты (наблюдатели)
об изменениях, не раскрывая своей внутренней структуры.

#### Основная идея

Паттерн Наблюдатель разделяет объекты на **наблюдаемые** (subjects) и **наблюдатели** (observers). Наблюдаемые объекты
управляют списком наблюдателей и уведомляют их об изменениях своего состояния. Наблюдатели реализуют интерфейс, который
позволяет им реагировать на эти уведомления.

#### Применение

Паттерн Наблюдатель используется в следующих случаях:

- Необходимо обеспечить автоматическое обновление множества объектов при изменении состояния одного объекта.
- Хочется поддерживать слабую связанность между объектами, чтобы изменения в одном объекте не требовали изменений в
  других.
- Необходимо поддерживать одну из архитектурных моделей типа MVC (Model-View-Controller), где модель должна уведомлять
  виды об изменениях.
- Когда количество наблюдателей может динамически изменяться во время выполнения программы.

### Реализация

1. Разбейте вашу функциональность на две части:   независимое ядро и опциональные зависимые части. Независимое ядро
   станет издателем. Зависимые части станут подписчиками.
2. Создайте интерфейс подписчиков. Обычно, в нём достаточно определить единственный метод оповещения.
3. Создайте интерфейс издателей и опишите в нём операции управления подпиской. Помните, что издатель должен работать
   только с общим интерфейсом подписчиков.
4. Вам нужно решить, куда поместить код ведения подписки, ведь он обычно бывает одинаков для всех типов издателей. Самый
   очевидный способ — вынести этот код в промежуточный абстрактный класс, от которого будут наследоваться все издатели.
5. Создайте классы конкретных издателей. Реализуйте их так, чтобы при каждом изменении состояния, они слали оповещения
   всем своим подписчикам.
6. Реализуйте метод оповещения в конкретных подписчиках. Издатель может отправлять какие-то данные вместе с
   оповещением (например, в параметрах). Возможен и другой вариант, когда подписчик, получив оповещение, сам берёт из
   объекта издателя нужные данные. Но при этом подписчик привяжет себя к конкретному классу издателя.
7. Клиент должен создавать необходимое количество объектов подписчиков и подписывать их у издателей.

### Примеры

#### Примеры стандартной Java библиотеки

- **Swing**: В графическом интерфейсе Java (Swing) паттерн Observer широко используется. Например, элементы управления (
  кнопки, текстовые поля) уведомляют слушателей (event listeners) об изменениях состояния (например, нажатие кнопки,
  ввод текста
- **JavaBeans**: Здесь используются события изменения свойств (property change events), где один объект может
  подписаться на уведомление об изменении свойств другого объекта.
- **Устаревшая реализация в Java**: в Java сохранились устаревшие интерфейсы ```Observable``` и  ```Observer```. Однако
  данный подход является устаревшим с **java 9**.
- **Современные реализации в Java**: ```JavaBeans PropertyChangeSupport``` — для отслеживания изменений свойств
  объектов.
- **Паттерны реактивного программирования**: такие как **Reactor** или **RxJava**, которые широко используются для
  обработки асинхронных потоков данных, предоставляя мощные возможности для наблюдения и управления изменениями в
  состояниях объектов.

#### [Пример](code%2Fexample3_alarm%2FMain.java) реализации наблюделя

**Интерфейсы** ```Observer``` и ```Subject```: Определяют контракт для наблюдателей и наблюдаемого объекта.

```java
interface Observer {
    void update(float temperature);
}
```

```java
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
```

---

**Класс** ```TemperatureSensor```: Реализует Subject, хранит текущую температуру и уведомляет наблюдателей при ее
изменении.

```java
class TemperatureSensor implements Subject {
    private float temperature;
    private List<Observer> observers;

    public TemperatureSensor() {
        observers = new ArrayList<>();
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
```

--- 

**Классы** ```Display``` и ```Alarm```: Реализуют ```Observer```, реагируют на обновления температуры. ```Alarm```
срабатывает только при превышении определенного порога.

```java
class Display implements Observer {
    private String name;

    public Display(String name) {
        this.name = name;
    }

    @Override
    public void update(float temperature) {
        System.out.println("Дисплей " + name + " отображает температуру: " + temperature + "°C");
    }
}
```

```java
class Alarm implements Observer {
    @Override
    public void update(float temperature) {
        if (temperature > 30.0f) {
            System.out.println("Сигнал тревоги! Высокая температура: " + temperature + "°C");
        }
    }
}
```

---

Создает экземпляр ```TemperatureSensor```, подписывает дисплеи и сигнал тревоги, изменяет температуру, что приводит к
уведомлениям.

```java
public class Main {
    public static void main(String[] args) {
        // Создаем наблюдаемый объект
        TemperatureSensor sensor = new TemperatureSensor();

        // Создаем наблюдателей
        Display display1 = new Display("1");
        Display display2 = new Display("2");
        Alarm alarm = new Alarm();

        // Подписываем наблюдателей на объект
        sensor.addObserver(display1);
        sensor.addObserver(display2);
        sensor.addObserver(alarm);

        // Изменяем состояние объекта
        sensor.setTemperature(25.0f);
        sensor.setTemperature(28.5f);
        sensor.setTemperature(32.0f);
    }
}
```

#### Ещё один пример реализации наблюделя

```java
// Интерфейс Observer
interface Observer {
    void update(String message);
}
```

```java
// Класс Subject (наблюдаемый)
class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Добавляем нового наблюдателя
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    // Удаляем наблюдателя
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    // Уведомляем всех наблюдателей о изменении состояния
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    // Метод изменения состояния
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }
}
```

```java
// Конкретный наблюдатель
class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " получил сообщение: " + message);
    }
}
```

```java
// Демонстрация работы паттерна Observer
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        // Создаем наблюдателей
        Observer observer1 = new ConcreteObserver("Наблюдатель 1");
        Observer observer2 = new ConcreteObserver("Наблюдатель 2");

        // Подписываем наблюдателей на объект
        subject.addObserver(observer1);
        subject.addObserver(observer2);

        // Меняем состояние объекта, что приводит к уведомлению наблюдателей
        subject.setState("Изменение состояния!");
    }
}
```

### Плюсы данного паттерна

- **Снижение связанности между объектами:** Наблюдатели и наблюдаемый не зависят напрямую друг от друга, взаимодействуя
  через интерфейсы. Это облегчает изменение и расширение системы.
- **Удобство добавления новых наблюдателей:** Новые типы наблюдателей могут быть добавлены без изменения кода
  наблюдаемого объекта.
- **Поддержка динамического взаимодействия:** Наблюдатели могут добавляться и удаляться во время выполнения программы.
- **Повторное использование кода:** Один и тот же наблюдаемый объект может иметь множество наблюдателей с различным
  поведением.

### Недостатки данного паттерна

- **Неопределенность порядка уведомлений:** Порядок, в котором наблюдатели получают уведомления, может быть
  неопределенным, что может привести к непредсказуемому поведению.
- **Потенциальные проблемы с производительностью:** Если наблюдаемых много, а их обновления часты, это может привести к
  ухудшению производительности.
- **Риск утечек памяти:** Неправильное управление подписками (например, не удаление наблюдателей) может привести к
  утечкам памяти.
- **Сложность отладки:** Множество наблюдателей может усложнить отслеживание источников проблем при изменениях
  состояний.

### Заключение

**Паттерн Наблюдатель (Observer)** является мощным инструментом для создания гибких и расширяемых систем, позволяя
объектам взаимодействовать между собой без жесткой связанности. Он широко используется в различных областях разработки,
таких как пользовательские интерфейсы, системы уведомлений и реактивное программирование.

Однако, как и любой паттерн, **Observer** имеет свои ограничения и должен использоваться осознанно, учитывая особенности
конкретного проекта и его требований.

### Источники

- Design Patterns with Java: Observer
- Введение в паттерны проектирования: Наблюдатель