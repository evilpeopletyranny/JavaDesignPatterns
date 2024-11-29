# Decorator

## Декоратор

**Декоратор** — это структурный паттерн проектирования, который позволяет динамически менять функциональность объектов,
оборачивая их в полезные «обёртки».

Паттерн декоратор является лучшим примером когда использование композиции превосходит наследование.

В разработке программного обеспечения часто возникает необходимость динамически добавлять объектам новые функциональные
возможности без изменения их структуры. Паттерн проектирования **Декоратор** (Decorator) предоставляет гибкое решение
этой задачи, позволяя расширять поведение объектов путем оборачивания их в дополнительные компоненты.

#### Основная идея

Основная идея паттерна Декоратор заключается в том, чтобы предоставить способ оборачивания объектов для добавления новых
функций, сохраняя при этом интерфейс исходного объекта. Это позволяет клиентам взаимодействовать с декорированными
объектами так же, как с оригинальными, не зная о дополнительном функционале.

#### Применение

Примеры, когда можно использовать паттерн декоратор:

1. Когда вы хотите добавить, улучшить или, возможно, удалить поведение или состояние объекта.
2. Когда вам нужно изменять обязанности объектам на лету, незаметно для кода, который их использует.
3. Когда нельзя расширить обязанности объекта с помощью наследования.
4. Когда вы просто хотите изменить функциональность одного конкретного объекта класса, а остальные оставить без
   изменений

### Реализация

1. Убедитесь, что в вашей задаче есть один основной компонент и несколько опциональных дополнений или надстроек над ним.
2. Создайте интерфейс компонента, который описывал бы все общие методы как для основного компонента, так и для его
   дополнений.
3. Создайте класс конкретного компонента и поместите в него основную бизнес-логику
4. Создайте базовый класс декораторов. Он должен иметь поле для хранения ссылки на вложенный объект-компонент. Все
   методы базового декоратора должны делегировать действие вложенному объекту.
5. И конкретный компонент, и базовый декоратор должны следовать одному и тому же интерфейсу компонента.
6. Теперь создайте классы конкретных декораторов, наследуя их от базового декоратора. Конкретный декоратор должен
   выполнять свою добавочную функциональность, а затем   (или перед этим) вызывать эту же операцию обёрнутого объекта.
7. Клиент берёт на себя ответственность за конфигурацию и порядок обёртывания объектов.

### Примеры

#### [Пример](code%2Fexample2_message%2FMessageMain.java) работы с сообщениями

Базовый интерфейс ```Message```

```java
public interface Message {
    String getContent();
}
```

Конкретный компонент ```SimpleMessage```

```java
public class SimpleMessage implements Message {
    private String content;

    public SimpleMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
}
```

Абстрактный декоратор ```MessageDecorator```

```java
public abstract class MessageDecorator implements Message {
    protected Message message;

    public MessageDecorator(Message message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return message.getContent();
    }
}
```

Декоратор для шифрования сообщения

```java
public class EncryptedMessageDecorator extends MessageDecorator {

    public EncryptedMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return encrypt(message.getContent());
    }

    private String encrypt(String content) {
        // Простая симуляция шифрования: разворот строки
        return new StringBuilder(content).reverse().toString();
    }
}
```

```java
public class TimestampedMessageDecorator extends MessageDecorator {

    public TimestampedMessageDecorator(Message message) {
        super(message);
    }

    @Override
    public String getContent() {
        return addTimestamp(message.getContent());
    }

    private String addTimestamp(String content) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);
        return "[" + timestamp + "] " + content;
    }
}
```

```java
public class MessageMain {
    public static void main(String[] args) {
        // Создание простого сообщения
        Message simpleMessage = new SimpleMessage("Hello, World!");
        System.out.println("Simple Message: " + simpleMessage.getContent());

        // Добавление шифрования
        Message encryptedMessage = new EncryptedMessageDecorator(simpleMessage);
        System.out.println("Encrypted Message: " + encryptedMessage.getContent());

        // Добавление временной метки
        Message timestampedMessage = new TimestampedMessageDecorator(simpleMessage);
        System.out.println("Timestamped Message: " + timestampedMessage.getContent());

        // Комбинирование декораторов: сначала шифрование, затем добавление метки
        Message encryptedTimestampedMessage = new TimestampedMessageDecorator(encryptedMessage);
        System.out.println("Encrypted & Timestamped Message: " + encryptedTimestampedMessage.getContent());
    }
}
```

### Плюсы данного паттерна

- **Гибкость:** Позволяет динамически добавлять функциональность объектам без изменения их структуры.
- **Повторное использование кода:** Позволяет комбинировать различные декораторы для создания сложного поведения.
- **Снижение связанности:** Клиентский код взаимодействует с объектами через общий интерфейс, не зная о конкретных
  декораторах.
- **Прозрачность для клиента:** Клиент не осознает, что объект был декорирован, взаимодействуя с ним как с обычным
  компонентом.

### Недостатки данного паттерна

- **Увеличение числа классов:** Каждый новый декоратор требует создания отдельного класса, что может привести к росту
  количества классов в проекте.
- **Сложность отладки:** Множественные обертки могут усложнить процесс отладки и отслеживания поведения объектов.
- **Потенциальные конфликты:** Некорректное использование декораторов может привести к конфликтам в функциональности или
  порядку вызовов методов.

### Заключение

Паттерн проектирования Декоратор является мощным инструментом для динамического расширения функциональности объектов без
изменения их структуры. Он широко применяется в стандартной библиотеке Java, особенно в области ввода-вывода и
графического интерфейса, обеспечивая гибкость и модульность систем.

Правильное применение паттерна Декоратор способствует созданию более гибких и расширяемых систем, облегчая добавление
новых функциональностей и поддержание кода. Однако, необходимо учитывать возможные недостатки, такие как увеличение
числа классов и усложнение отладки, чтобы эффективно использовать этот паттерн в своих проектах.

### Источники

- Design Patterns with Java: Decorator
- Введение в паттерны проектирования: Декоратор