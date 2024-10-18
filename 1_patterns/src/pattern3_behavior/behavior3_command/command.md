# Command

## Команда

**Команда** — это поведенческий паттерн проектирования, который превращает запросы в объекты, позволяя передавать их как
аргументы при вызове методов, ставить запросы в очередь, логировать их, а также поддерживать отмену операций.

#### Основная идея

Паттерн "Команда" разделяет объект, инициирующий запрос, от объектов, которые его выполняют. Это достигается путем
создания отдельных объектов-команд, каждая из которых реализует определенное действие.

#### Применение

Паттерн "Команда" рекомендуется использовать в следующих случаях:

- **Необходимо параметризовать объекты с операциями:** Когда объекты должны быть настроены с разными действиями.
- **Требуется поддержка отмены и повторного выполнения операций:** Когда нужно иметь возможность отменить или повторить
  выполненные действия.
- **Необходимо организовать очередь запросов или логи действий:** Для управления запросами в очереди или записи действий
  для аудита.
- **Требуется разделить инициирующий объект и объект, выполняющий действие:** Для уменьшения связанности между
  компонентами системы.

### Реализация

1. Создайте общий интерфейс команд и определите в нём метод запуска.
2. Один за другим создайте классы конкретных команд. В каждом классе должно быть поле для хранения ссылки на один или
   несколько объектов-получателей, которым команда будет перенаправлять основную работу.

   Кроме этого, команда должна иметь поля для хранения параметров, которые нужны при вызове методов получателя. Значения
   всех этих полей команда должна получать через конструктор.

   И наконец, реализуйте основной метод команды, вызывая в нём те или иные методы получателя.
3. Добавьте в классы отправителей поля для хранения команд. Объект-отправитель должен принимать готовый объект команды
   извне через конструктор, либо через сеттер команды.
4. Измените основной код отправителей так, чтобы они делегировали выполнение действия команде.
5. Порядок инициализации объектов должен выглядеть так:
    - Создаём объекты получателей.
    - Создаём объекты команд, связав их с получателями.
    - Создаём объекты отправителей, связав их с командами.

### Примеры

#### Примеры стандартной библиотеки Java

- Интерфейс ```Runnable``` можно рассматривать как реализацию паттерна "Команда". Он инкапсулирует задачу, которую можно
  выполнить в отдельном потоке.

```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Task is running in a separate thread.");
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

- Интерфейс ```Action``` в пакете ```javax.swing``` реализует паттерн "Команда". Он инкапсулирует действие, которое
  может быть выполнено, например, при нажатии кнопки.

#### [Пример](code%2Fexample2_new_texteditor%2FMain.java) с текстовым редактором

Создадим простую текстовую редакторскую систему, которая позволяет выполнять операции вставки и удаления текста с
возможностью отмены и повтора этих операций.

_Дополнительно: в данном примере также присутсвует паттерн **Снимок**._

---

Интерфейс ```Command``` - команда, определяет методы ```execute()``` и ```undo()```.

```java
// Команда
public interface Command {
    void execute();

    void undo();
}
```

---

Класс ```TextEditor``` - получатель. Класс над которым выполняются команды (получает команды).

```java
// Получатель
public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void insert(int position, String content) {
        if (position < 0 || position > text.length()) throw new IllegalArgumentException("Invalid position");

        text.insert(position, content);
        System.out.println("Inserted \"" + content + "\" at position " + position);
    }

    public void delete(int position, int length) {
        if (position < 0 || position + length > text.length())
            throw new IllegalArgumentException("Invalid position or length");

        String removed = text.substring(position, position + length);
        text.delete(position, position + length);
        System.out.println("Deleted \"" + removed + "\" from position " + position);
    }

    public String getText() {
        return text.toString();
    }
}
```

---

Конкретная команда - вставка - ```InsertCommand```.

```java
// Конкретная команда - вставка
public class InsertCommand implements Command {
    private TextEditor editor;
    private int position;
    private String content;

    public InsertCommand(TextEditor editor, int position, String content) {
        this.editor = editor;
        this.position = position;
        this.content = content;
    }

    @Override
    public void execute() {
        editor.insert(position, content);
    }

    @Override
    public void undo() {
        editor.delete(position, content.length());
    }
}
```

---

Конкретная команда - удаление - ```DeleteCommand```.

```java
public class DeleteCommand implements Command {
    private TextEditor editor;
    private int position;
    private int length;
    private String removedText;

    public DeleteCommand(TextEditor editor, int position, int length) {
        this.editor = editor;
        this.position = position;
        this.length = length;
    }

    @Override
    public void execute() {
        removedText = editor.getText().substring(position, position + length);
        editor.delete(position, length);
    }

    @Override
    public void undo() {
        editor.insert(position, removedText);
    }
}
```

---

История ```History``` - паттерн Снимок. Позволяет перемещаться по истории команд.

```java
// История изменений
// Паттерн снимок через Стек
public class History {
    private Deque<Command> commandHistory = new ArrayDeque<>();

    public void push(Command cmd) {
        commandHistory.push(cmd);
    }

    public Command pop() {
        if (!commandHistory.isEmpty()) return commandHistory.pop();
        return null;
    }

    public boolean isEmpty() {
        return commandHistory.isEmpty();
    }
}
```

---

```java
public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        // Вставка текста
        Command insertHello = new InsertCommand(editor.textEditor, 0, "Hello ");
        editor.executeCommand(insertHello);
        editor.printText(); // Output: "Hello "

        Command insertWorld = new InsertCommand(editor.textEditor, editor.textEditor.getText().length(), "World!");
        editor.executeCommand(insertWorld);
        editor.printText(); // Output: "Hello World!"

        // Удаление текста
        Command deleteWorld = new DeleteCommand(editor.textEditor, 6, 6);
        editor.executeCommand(deleteWorld);
        editor.printText(); // Output: "Hello "

        // Отмена последних операций
        editor.undo(); // Отмена удаления "World!"
        editor.printText(); // Output: "Hello World!"

        editor.undo(); // Отмена вставки "World!"
        editor.printText(); // Output: "Hello "

        editor.undo(); // Отмена вставки "Hello "
        editor.printText(); // Output: ""

        editor.undo(); // Нет команд для отмены
    }
}
```

### Плюсы данного паттерна

- **Снижение связанности:** Отправитель запроса (```Invoker```) не зависит от получателя (```Receiver```) и конкретных
  команд. Это облегчает изменение и расширение системы.
- **Гибкость и расширяемость:** Легко добавлять новые команды без изменения существующих классов.
- **Поддержка отмены операций:** Возможность реализации методов ```undo()``` для отмены выполненных команд.
- **Организация запросов:** Позволяет хранить, передавать и управлять запросами как объектами.
- **Реализация макрокоманд:** Возможность объединения нескольких команд в одну.

### Недостатки данного паттерна

- **Увеличение числа классов:** Каждая новая команда требует создания нового класса, что может привести к увеличению
  сложности проекта.
- **Сложность отладки:** Из-за большого количества классов может быть сложнее отслеживать и понимать поток выполнения
  программы.
- **Небольшие преимущества для простых систем:** В простых приложениях использование паттерна может быть избыточным и
  усложнять код.

### Заключение

Паттерн Команда (Command) является мощным инструментом для инкапсуляции запросов как объектов, что обеспечивает
гибкость, расширяемость и упрощает управление действиями в системе. Он широко применяется в различных областях, таких
как системы управления устройствами, GUI-приложения, системы логирования и многие другие.

Паттерн "Команда" широко используется в графических интерфейсах (например, обработка событий кнопок), системах
управления устройствами (умный дом), системах логирования, системах транзакций и многих других областях, где требуется
гибкое управление действиями и их отмена.

Однако, при использовании паттерна "Команда" важно учитывать его преимущества и недостатки, чтобы не создавать
избыточную структуру классов в простых системах.

### Источники

- Design Patterns with Java: Command
- Введение в паттерны проектирования: Команда
- [Baeldung](https://www.baeldung.com/java-command-pattern)