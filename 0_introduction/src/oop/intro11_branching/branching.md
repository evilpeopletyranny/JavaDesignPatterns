# Ветвление

**Конструкции ветвления** — это элементы программирования, которые позволяют изменять поток выполнения программы в
зависимости от условий. Они дают возможность программе принимать решения и выполнять различные блоки кода на основе
значений переменных или результатов логических выражений. Ветвления используются для управления логикой программы,
позволяя ей реагировать на различные ситуации и ввод пользователя.

## Функции конструкций ветвления

1. **Принятие решений**: позволяют программе выполнять определенные действия в зависимости от условий.
2. **Управление потоком выполнения**: изменяют последовательность выполнения команд в программе.
3. **Гибкость и адаптация**: помогают программам адаптироваться к различным входным данным и условиям.

## if-else

Конструкции ```if```, ```else if```, и ```else``` — это ключевые элементы управления потоком выполнения программы. Они
позволяют выполнять
блоки кода в зависимости от истинности заданных условий.

- ```if``` выполняет блок кода, если условие истинно (```true```).
- ```else if```: используется для проверки дополнительных условий, если предыдущее условие ложно.
- ```else```: выполняется, если все предыдущие условия ложны.

```
if(условие){
        // Блок кода, выполняемый, если условие истинно
        }else if(другое условие){
        // Блок кода, выполняемый, если первое условие ложно, но второе истинно
        }else{
        // Блок кода, выполняемый, если все вышестоящие условия ложны
        }
```

1. ```if (условие)```: Проверяет выражение внутри круглых скобок. Если выражение оценивается как true, выполняется код.
2. ```else if (другое условие)```: Если условие в ```if``` ложно, проверяется следующее условие ```else if```. Может
   быть несколько ```else if```. Как только одно из условий становится истинным, соответствующий блок кода выполняется,
   а остальные ```else if``` и ```else``` игнорируются.
3. ```else```: Выполняется, если все ```if``` и ```else if``` условия оказались ложными. Этот блок не требует условия.

### [Пример](IfMain.java): ```if```

```java
public class Main {
    public static void main(String[] args) {
        int temperature = 25;

        // Проверяем условие: температура выше 20 градусов
        if (temperature > 20) {
            System.out.println("Теплая погода");
        }
    }
}
```

### [Пример](IfElseMain.java): Использование ```if``` и ```else```

```java
public class Main {
    public static void main(String[] args) {
        int number = -10;

        // Проверяем, положительное ли число
        if (number > 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное или ноль");
        }
    }
}
```

### [Пример](IfElseIfElseMain.java): Использование ```if```, ```else if```, ```else```

```java
public class Main {
    public static void main(String[] args) {
        int score = 75;

        // Проверка различных условий
        if (score >= 90) {
            System.out.println("Отлично");
        } else if (score >= 75) {
            System.out.println("Хорошо");
        } else if (score >= 50) {
            System.out.println("Удовлетворительно");
        } else {
            System.out.println("Неудовлетворительно");
        }
    }
}
```

### Особенности

1. **Порядок проверки**: ```if``` проверяется первым, затем все ```else if``` по порядку, и ```else``` выполняется
   только если все предыдущие условия ложны.
2. Конструкция ```else if``` необязательно. Даже ```else``` не обязательно.
3. **Необязательные фигурные скобки**: Если после ```if```,```else if``` или ```else``` идет только одно выражение,
   можно опустить фигурные скобки ```{}```, но это не рекомендуется для читаемости:

```
if(score >90)System.out.println("Отлично"); // Работает, но лучше всегда использовать скобки
```

## Тернарный оператор

**Тернарный оператор** — это компактная форма записи конструкции ```if-else```, которая используется для простых
условий.
Он позволяет сократить код и сделать его более лаконичным, особенно когда требуется присвоить значение переменной на
основе условия.

_Далеко не во всех языках программирования есть тернарный оператор. В большинстве языков где его нет причиной отказа
является его плохая читаемость и усложнение кода. В плане производительности он не имеет никаких явных преимуществ от
простого ```if-else```._

### Синтаксис:

Тернарный оператор записывается в формате:

```
переменная = (условие) ? значение1 : значение2;
```

- ```условие```: логическое выражение, которое проверяется.
- ```значение1```: значение, присваиваемое переменной, если условие истинно (```true```).
- ```значение2```: значение, присваиваемое переменной, если условие ложно (```false```).

### Как работает тернарный оператор?

Тернарный оператор оценивает условие. Если оно истинно, выбирается значение, стоящее после вопросительного
знака ```?```. Если условие ложно, выбирается значение, стоящее после двоеточия ```:```.

### [Пример](TernaryOperatorMain.java) использование тернарного оператора

```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Используем тернарный оператор для выбора наибольшего числа
        int max = (a > b) ? a : b;

        System.out.println("Наибольшее число: " + max);
    }
}
```

Тоже самое с использованием ```if-else```:

```java
public class Main {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int max;

        if (a > b) {
            max = a;
        } else {
            max = b;
        }

        System.out.println("Наибольшее число: " + max);
    }
}
```

### [Пример](TernaryAssignmentMain.java): Присвоение значения в зависимости от условий

Тернарный оператор можно использовать для присвоения значени зависимости от условий.

```java
public class Main {
    public static void main(String[] args) {
        int age = 18;

        // Присваиваем статус на основе возраста
        String status = (age >= 18) ? "Взрослый" : "Несовершеннолетний";

        System.out.println("Статус: " + status);
    }
}
```

### Вложенный тернарный оператор

Оказывается тернарный оператор может быть вложенным.

```java
public class Main {
    public static void main(String[] args) {
        int score = 85;

        // Вложенный тернарный оператор
        String grade = (score >= 90) ? "Отлично" : (score >= 75) ? "Хорошо" : "Удовлетворительно";

        System.out.println("Оценка: " + grade);
    }
}
```

Как можно заметить читаемости и понятности такое использование тернарного оператора не дает и считается _плохо
практикой_. В таких случаях лучше обойтись конструкцией ```if-else```.

### Особенности и рекомендации по использованию тернарного оператора:

1. **Удобство**: Тернарный оператор позволяет сократить код, убирая лишние строки и делая выражение более компактным.
2. **Читаемость**: Хотя тернарный оператор может сделать код короче, его чрезмерное использование или использование в
   сложных логических проверках может ухудшить читаемость.
3. **Ограничения**: Тернарный оператор подходит для простых условий, где требуется вернуть или присвоить одно из двух
   значений. Для более сложных логических ветвлений лучше использовать ```if-else```.

## Switch

Конструкция ```switch``` в **Java** используется для управления потоком выполнения программы в зависимости от значения
выражения. Она часто заменяет длинные цепочки ```if-else```, делая код более компактным и читабельным. В JDK
17 ```switch``` был существенно расширен и получил новые возможности, такие как switch-выражения и работа с новыми
типами данных, включая строки и перечисления (```enums```).

### Основные элементы конструкции ```switch```

1. ```switch (выражение)```: Выражение, которое проверяется на соответствие с каждым значением ```case```.
2. ```case значение:``` Если выражение совпадает с значением, выполняется соответствующий блок кода.
3. ```break;``` Прерывает выполнение switch, чтобы предотвратить выполнение следующих ```case```. Однако начиная с JDK
   12 вместо написания блока case с break можно использовать оператор ```->``` после которого указывается блок кода для
   выполнения.
4. ```default:``` Выполняется, если ни одно из значений case не совпало.

### Синтаксис до JDK 12

Пример ```switch```, где в case всё еще требуется явно указывать ```break```

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;
        String dayName;

        switch (day) {
            case 1:
                dayName = "Понедельник";
                break;
            case 2:
                dayName = "Вторник";
                break;
            case 3:
                dayName = "Среда";
                break;
            case 4:
                dayName = "Четверг";
                break;
            case 5:
                dayName = "Пятница";
                break;
            case 6:
                dayName = "Суббота";
                break;
            case 7:
                dayName = "Воскресенье";
                break;
            default:
                dayName = "Неверный день";
                break;
        }

        System.out.println("Сегодня: " + dayName);
    }
}
```

### Синтаксис после JDK 12

Конечно от старого синтаксиса никто не отказался и он также будет валидным. Но теперь есть более компактный способ
записи, который также уменьшает количество ошибок, связанных с забытыми операторами ```break```.

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;

        // Используем switch-выражение с оператором ->
        String dayName = switch (day) {
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            case 7 -> "Воскресенье";
            default -> "Неверный день";
        };

        System.out.println("Сегодня: " + dayName);
    }
}
```

### История новведений в оператор ```switch```

- **JDK 7**: Поддержка строк в ```switch```.
- **JDK 12**: Введение ```switch-выражений``` (в виде preview-функции), возможность возвращать значения,
  многострочные ```case```.
- **JDK 13**: Появление ```yield``` (в виде preview-функции).
- **JDK 14**: Окончательная стабилизация switch-выражений и ```yield```.
- **JDK 17**: Улучшение поддержки паттерн-матчинга в ```switch```.

### [Пример](SwitchValueMain.java) использования ```switch``` с возвратом значения

В данном примере в зависимости от того, какой будет выбран ```case``` в переменную ```activity``` попадают разные
значения.

```java
public class Main {
    public static void main(String[] args) {
        String day = "TUESDAY";
        String activity = switch (day) {
            case "MONDAY", "TUESDAY", "WEDNESDAY" -> "Рабочий день";
            case "THURSDAY", "FRIDAY" -> "Подготовка к выходным";
            case "SATURDAY", "SUNDAY" -> "Выходной";
            default -> "Неверный день";
        };

        System.out.println("Сегодня: " + activity);
    }
}
```

### [Пример](SwitchYieldMain.java) использование ```yield``` для возврата значений из блока.

Помимо одной строки и простых выражений под ```case``` может скрываться целый блок кода. Тогда для явного указания
возвращаемого значения используется ключевое слово ```yield```.

```java
public class Main {
    public static void main(String[] args) {
        int month = 3;
        int days = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> {
                System.out.println("Февраль");
                yield 28; // возвращаем значение через yield
            }
            default -> throw new IllegalArgumentException("Неверный месяц: " + month);
        };

        System.out.println("Дней в месяце: " + days);
    }
}
```

### Преимущества ```switch``` в более новых версиях в сравнении со старыми

1. **Компактность и читаемость**: Новые конструкции делают ```switch``` менее громоздким по сравнению с классическими
   версиями, где нужно было писать break после каждого ```case```.
2. **Безопасность**: Меньше шансов на ошибку из-за отсутствия ```break```, так как вместо него используется ```->```
   или ```yield```.
3. **Гибкость**: Возможность использовать ```switch``` как выражение, возвращающее значение, что упрощает код и
   позволяет писать более функциональный стиль.
4. **Поддержка различных типов**: Теперь ```switch``` может работать не только с числами и строками, но и с логическими
   паттернами и типами данных.

<!-- TODO: Пример с паттерном матчингом, но там необходимо ввести понятие record-ов -->