# Template Method

## Шаблонный метод

**Паттерн Шаблонный Метод (Template Method)** относится к поведенческим паттернам и определяет общий алгоритм выполнения
задачи, делегируя реализацию некоторых его шагов подклассам. Это позволяет изменять определённые этапы алгоритма без
изменения его общей структуры.

#### Основная идея

Создать абстрактный класс с шаблонным методом, который определяет порядок выполнения шагов алгоритма. Некоторые из этих
шагов реализованы в абстрактном классе, а другие — объявлены как абстрактные методы, которые должны быть реализованы в
подклассах.

#### Применение

- **Повторяющиеся алгоритмы с вариациями:** Когда несколько классов используют один и тот же алгоритм, но с небольшими
  изменениями в его отдельных шагах.
- **Контроль над наследованием:** Когда нужно контролировать порядок выполнения шагов алгоритма и обеспечить
  последовательность их вызова.
- **Расширяемость алгоритмов:** Когда необходимо добавить новые шаги или изменить существующие без изменения общего
  алгоритма.
- **Сокрытие деталей реализации:** Когда требуется скрыть детали реализации некоторых шагов алгоритма от клиентов.

### Реализация

1. Изучите алгоритм и подумайте, можно ли его разбить на шаги. Прикиньте, какие шаги будут стандартными для всех
   вариаций алгоритма, а какие — изменчивыми.
2. Создайте абстрактный базовый класс. Определите в нём шаблонный метод. Этот метод должен состоять из вызовов шагов
   алгоритма. Имеет смысл сделать шаблонный метод финальным, чтобы подклассы не могли переопределить его   (если ваш
   язык программирования это позволяет).
3. Добавьте в абстрактный класс методы для каждого из шагов алгоритма. Вы можете сделать эти методы абстрактными или
   добавить какую-то реализацию по умолчанию. В первом случае, все подклассы должны будут реализовать эти методы, а во
   втором — только если реализация шага в подклассе отличается от стандартной версии.
4. Подумайте о введении в алгоритм хуков. Чаще всего, хуки располагают между основными шагами алгоритма, а также до и
   после всех шагов.
5. Создайте конкретные классы, унаследовав их от абстрактного класса. Реализуйте в них все недостающие шаги и хуки.

### Примеры

#### [Пример](code%2Fexample2_drinks%2FMain.java) шаблонного метода приготовления Чая и Кофе

**Beverage** содержит общий алгоритм приготовления напитка в методе ```prepareRecipe()```.

Шаблонный метод ```prepareRecipe()``` управляет порядком выполнения шагов, обеспечивая последовательность приготовления.

```java
// Абстрактный класс с шаблонным методом
abstract class Beverage {

    // Шаблонный метод
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Общие шаги
    private void boilWater() {
        System.out.println("Кипячение воды");
    }

    private void pourInCup() {
        System.out.println("Наливание в чашку");
    }

    // Шаги, которые должны быть реализованы в подклассах
    protected abstract void brew();

    protected abstract void addCondiments();
}
```

---

```Tea``` и ```Coffee``` реализуют конкретные шаги ```brew()``` и ```addCondiments()```.

```java
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Заваривание чая");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавление лимона");
    }
}
```

```java
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Заваривание кофе");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавление сахара и молока");
    }
}
```

### Плюсы данного паттерна

- **Повторное использование кода:** Общие шаги алгоритма реализованы в абстрактном классе, что позволяет избежать
  дублирования кода в подклассах.
- **Контроль над порядком выполнения шагов:** Шаблонный метод определяет последовательность выполнения шагов,
  обеспечивая правильный порядок действий.
- **Гибкость и расширяемость:** Подклассы могут переопределять только необходимые шаги алгоритма, не затрагивая его
  общую структуру.
- **Сокрытие деталей реализации:** Клиентский код взаимодействует с абстрактным классом, не зная о конкретных
  реализациях шагов алгоритма.

### Недостатки данного паттерна

- **Жесткая структура алгоритма:** Алгоритм задан в шаблонном методе и может быть сложно изменить его структуру, если
  это потребуется.
- **Увеличение числа классов:** Для каждой новой вариации алгоритма необходимо создавать новый подкласс.
- **Сложность понимания:** Разделение алгоритма на абстрактный класс и подклассы может затруднить понимание общего
  алгоритма.
- **Ограниченная гибкость при использовании композиции:** Паттерн ориентирован на наследование, что может привести к
  проблемам при необходимости использования композиции вместо наследования.

### Заключение

**Паттерн Шаблонный Метод (Template Method)** является мощным инструментом для определения общего алгоритма с
возможностью изменения отдельных шагов в подклассах. Он способствует повторному использованию кода, снижает дублирование
и обеспечивает контроль над порядком выполнения шагов алгоритма.

Однако, при использовании паттерна Шаблонный Метод важно учитывать его ограничения, такие как жесткая структура
алгоритма и увеличение числа классов, и применять его осознанно в контексте конкретных задач и требований проекта.

### Источники

- Design Patterns with Java: Template Method
- Введение в паттерны проектирования: Шаблонный метод
- [Baeuldung: Implementing the Template Method Pattern in Java](https://www.baeldung.com/java-template-method-pattern)