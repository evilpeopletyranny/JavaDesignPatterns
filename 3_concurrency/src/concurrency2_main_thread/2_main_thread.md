# Основной поток выполнения программы

В Java-приложениях **главный поток** (```main``` thread) — это начальный поток выполнения, который создаётся виртуальной машиной Java (JVM) при запуске программы. Он отвечает за выполнение метода ```main()``` и служит точкой входа в приложение.

Когда JVM запускает программу, она создаёт главный поток и вызывает метод main() в этом потоке.

```java
public class Main{
  public static void main(String[] args) {
    // код....
  }
}
```

## Характеристики главного потока

- **Имя потока**: По умолчанию главный поток называется "```main```".
- **Группа потоков**: Главный поток принадлежит группе потоков ```main```, если не указано иное.
- **Приоритет**: Главный поток имеет нормальный приоритет ```Thread.NORM_PRIORITY``` (обычно значение ```5```).
- **Жизненный цикл**: Главный поток существует до тех пор, пока метод ```main()``` не завершит своё выполнение.

## Роль главного потока

- **Точка входа**: Главный поток служит начальной точкой выполнения программы.
- **Создание новых потоков**: Из главного потока можно создавать новые потоки для выполнения параллельных задач.
- **Завершение программы**: Программа продолжает выполняться до тех пор, пока работают все непотоковые (недемонические) потоки, включая главный поток.

# Примеры взаимодействия с главным потоком

## [Получение ссылки](code%2FGetLink.java) на главный поток

Вы можете получить ссылку на текущий выполняющийся поток с помощью метода ```Thread.currentThread()```:

```java
public class GetLink {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Имя главного потока: " + mainThread.getName());
    }
}
```

## [Изменение свойств](code%2FChangeProperty.java) главного потока

Вы можете изменить имя и приоритет главного потока:

```java
public class ChangeProperty {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        mainThread.setName("MyMainThread");
        mainThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Новое имя главного потока: " + mainThread.getName());
    }
}
```

## Приостановка главного потока

Главный поток может быть приостановлен с помощью метода ```sleep()```:

```java
public class MainSleep {
    public static void main(String[] args) throws InterruptedException {
            System.out.println("Главный поток спит 2 секунды.");
            Thread.sleep(2000); // Приостановка главного потока на 2 секунды
    }
}
```


