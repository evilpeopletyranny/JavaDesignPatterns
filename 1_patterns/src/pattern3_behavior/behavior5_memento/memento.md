# Memento

## Снимок

**Снимок** — это поведенческий паттерн проектирования, который позволяет делать снимки состояния объектов, не раскрывая
подробностей их реализации. Затем снимки можно использовать, чтобы восстановить прошлое состояние объектов.

#### Основная идея

Паттерн Снимок отделяет объект, сохраняющий состояние (Снимок), от объекта, чей статус сохраняется (Происхождение).
Таким образом, Происхождение может создавать Снимки, чтобы сохранить свое состояние, а затем использовать их для
восстановления этого состояния без раскрытия внутренней структуры.

#### Применение

Паттерн Снимок рекомендуется использовать в следующих случаях:

- **Необходимо сохранить предыдущее состояние объекта:** Когда требуется иметь возможность вернуть объект к предыдущему
  состоянию (например, в редакторах с функцией отмены).
- **Хранение истории изменений:** Для реализации журналов или историй изменений.
- **Избегание нарушения инкапсуляции:** Когда необходимо сохранять состояние объекта без раскрытия его внутренней
  структуры.

### Реализация

1. Определите класс создателя, объекты которого должны создавать снимки своего состояния.
2. Создайте класс снимка и опишите в нём все те же поля, которые имеются в оригинальном классе-создателе.
3. Сделайте объекты снимков неизменяемыми. Они должны получать начальные значения только один раз, через свой
   конструктор.
4. Если ваш язык программирования это позволяет, сделайте класс снимка вложенным в класс создателя.
5. Добавьте в класс создателя метод получения снимков. Создатель должен создавать новые объекты снимков, передавая
   значения своих полей через конструктор.
6. Добавьте в класс создателя метод восстановления из снимка.
7. Опекуны, будь то история операций, объекты команд или нечто иное, должны знать о том, когда запрашивать снимки у
   создателя, где их хранить, и когда восстанавливать.
8. Связь опекунов с создателями можно перенести внутрь снимков. В этом случае каждый снимок будет привязан к своему
   создателю и должен будет сам восстанавливать его состояние. Но это будет работать либо если классы снимков вложены в
   классы создателей, либо если создатели имеют сеттеры для установки значений своих полей.

### Примеры

#### [Пример](code%2Fexample2_game_state%2FMain.java) с сохранением состояния игры

```Game``` - объект состояние которого необходимо сохранять.

```java
public class Game {
    protected int playerPosition;
    protected int score;

    public void movePlayer(int newPosition) {
        playerPosition = newPosition;
        System.out.println("Player moved to position: " + playerPosition);
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Score increased by " + points + ". Current score: " + score);
    }

    public GameState save() {
        System.out.println("Saving game state: Position=" + playerPosition + ", Score=" + score);
        return new GameState(playerPosition, score);
    }

    public void restore(GameState state) {
        playerPosition = state.getPlayerPosition();
        score = state.getScore();
        System.out.println("Game state restored: Position=" + playerPosition + ", Score=" + score);
    }
}
```

---

```GameState``` - снимок объекта ```Game```.

```java
public class GameState {
    private final int playerPosition;
    private final int score;

    public GameState(int playerPosition, int score) {
        this.playerPosition = playerPosition;
        this.score = score;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public int getScore() {
        return score;
    }
}
```

---

```GameSaveManager ``` - класс отвечающий за управление снимками. История игры. Реализация через стек.

```java
import java.util.ArrayDeque;
import java.util.Deque;

public class GameSaveManager {
    private Deque<GameState> saveStack = new ArrayDeque<>();

    public void saveState(Game game) {
        saveStack.push(game.save());
    }

    public void restoreState(Game game) {
        if (!saveStack.isEmpty()) {
            GameState state = saveStack.pop();
            game.restore(state);
        } else {
            System.out.println("No saved states to restore.");
        }
    }
}
```

---

```java
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        GameSaveManager saveManager = new GameSaveManager();

        game.movePlayer(10);
        game.addScore(50);
        saveManager.saveState(game);

        game.movePlayer(20);
        game.addScore(30);
        saveManager.saveState(game);

        game.movePlayer(30);
        game.addScore(20);
        System.out.println("Current Game State: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nRestoring to last saved state:");
        saveManager.restoreState(game);
        System.out.println("Game State after restoration: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nRestoring to previous saved state:");
        saveManager.restoreState(game);
        System.out.println("Game State after restoration: Position=" + game.playerPosition + ", Score=" + game.score);

        System.out.println("\nAttempting to restore beyond history:");
        saveManager.restoreState(game);
    }
}
```

### Плюсы данного паттерна

- **Легкость реализации механизмов отмены и повторения:** Обеспечивает простой способ отката к предыдущим состояниям.
- **Гибкость управления историей состояний:** Можно реализовать сложные механизмы истории, такие как множественные
  уровни отмены или линейное и ветвящееся восстановление.
- **Повторное использование объектов Memento:** Один и тот же объект снимка может использоваться разными объектами (
  например перенос сохранений с одной машины на другую).

### Недостатки данного паттерна

- **Увеличение использования памяти:** Хранение многочисленных состояний может потребовать значительного объема памяти.
- **Сложность реализации:** Требует дополнительного проектирования и создания дополнительных классов (Memento).
- **Управление жизненным циклом состояний:** Необходимо контролировать сохранение и удаление состояний, чтобы избежать
  утечек памяти.

### Заключение

Паттерн Снимок (Memento) является мощным инструментом для управления состоянием объектов, особенно когда требуется
реализовать механизмы отмены и восстановления. Он позволяет сохранять состояние объекта без раскрытия его внутренней
структуры, обеспечивая при этом гибкость и расширяемость системы.

Однако, при использовании паттерна Снимок важно учитывать потенциальные недостатки, такие как увеличение использования
памяти и сложность реализации. Правильное управление жизненным циклом состояний и минимизация объема сохраняемых данных
помогут эффективно использовать этот паттерн в ваших проектах.

### Источники

- [Baeldung: Memento Design Pattern in Java](https://www.baeldung.com/java-memento-design-pattern)
- Design Patterns with Java: Memento
- Введение в паттерны проектирования: Снимок