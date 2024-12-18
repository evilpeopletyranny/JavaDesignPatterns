# volatile

Ключевое слово ```volatile``` в Java используется для обозначения переменной как **нестабильной**, что означает, что ее
значение всегда будет читаться из основной памяти, а не из кеша потока. Это обеспечивает **видимость** изменений
переменной между разными потоками.

## Зачем нужно ```volatile```?

- **Обеспечение видимости изменений между потоками:** В многопоточном окружении каждый поток может иметь свой
  собственный кеш копий переменных из основной памяти. Без ```volatile``` изменения, сделанные одним потоком, могут быть
  невидимы другим потокам.
- **Предотвращение кеширования переменной потоком:** Помечая переменную как ```volatile```, вы гарантируете, что чтение
  и запись этой переменной будет происходить непосредственно из основной памяти.

## ```volatile``` в многопоточном программировании

- **Видимость изменений:** Обеспечивает, что все потоки видят актуальное значение переменной.
- **Запрет переупорядочивания команд:** Компилятор и процессор не будут переупорядочивать операции с ```volatile```
  переменными относительно других операций с памятью.
- **Облегчение межпоточной коммуникации:** Используется для простых флагов, индикаторов состояния и других переменных,
  где требуется уведомить другие потоки об изменении состояния.

## [Пример](code%2FVolatileMain.java): Использование ```volatile``` для индикатора готовности данных

```java
class VolatileDataExample {
    private int data;
    private volatile boolean ready = false;

    public void writer() {
        data = 42; // Запись данных
        ready = true; // Установка флага готовности
    }

    public void reader() {
        if (ready) {
            System.out.println("Данные прочитаны: " + data);
        } else {
            System.out.println("Данные еще не готовы.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VolatileDataExample example = new VolatileDataExample();

        Thread writerThread = new Thread(example::writer);
        Thread readerThread = new Thread(example::reader);

        writerThread.start();
        readerThread.start();
    }
}
```

- **Переменная ```ready``` объявлена как ```volatile```:** Гарантирует, что запись данных и установка флага ```ready```
  не будут переупорядочены.
- **Гарантирует порядок выполнения:** Другие потоки увидят изменения в ```data``` только после того, как ```ready```
  станет ```true```.

## Когда использовать ```volatile```

- **Простые флаги и индикаторы состояния:** Когда переменная используется как сигнал между потоками.
- **Когда операции являются атомарными:** Чтение и запись переменных типов ```int```, ```boolean```, ```reference```
  являются атомарными.
- **Когда нет необходимости в блокировке:** Если требуется лишь обеспечить видимость изменений, без необходимости
  атомарных операций.

## Когда не следует использовать ```volatile```

- **Для сложных операций:** Когда операции над переменной не являются атомарными (например, инкремент, декремент,
  операции с несколькими переменными).
- **Когда требуется инвариантность состояния:** Если изменение одной переменной зависит от другой, и требуется
  обеспечить согласованность.
- **Когда необходима взаимная блокировка:** В таких случаях следует использовать ```synchronized``` или ```Lock```.

# Atomic

**Atomic переменные** — это классы из пакета ```java.util.concurrent.atomic```, предоставляющие атомарные операции над
переменными примитивных типов и объектными ссылками. Они обеспечивают атомарность операций без использования
блокировок (```synchronized```), что позволяет безопасно обновлять общие переменные в многопоточном окружении.

Помимо того ```Atomic``` переменные являются ```volatile``` (содержать поле ```volatile``` внутри объекта), т.е. не
кешируются в потоках.

## Зачем нужны ```Atomic``` переменные?

- **Обеспечение атомарности операций:** В многопоточном программировании часто возникает необходимость в том, чтобы
  операции над переменными происходили **неделимо**. Atomic переменные гарантируют, что операции
  чтения-модификации-записи выполняются как единое целое.
- **Повышение производительности:** Использование ```Atomic``` переменных позволяет избежать блокировок, связанных
  с ```synchronized```, что может улучшить производительность и масштабируемость приложения.
- **Поддержка неблокирующих алгоритмов:** Atomic переменные используются для реализации неблокирующих (lock-free)
  структур данных и алгоритмов, повышающих отзывчивость системы.

## Особенности Atomic переменных

1. Атомарные операции: предоставляют методы, которые выполняются атомарно, например:

- ```incrementAndGet()```
- ```decrementAndGet()```
- ```compareAndSet(expectedValue, newValue)```

2. **Неблокирующая синхронизация:** Используют низкоуровневые атомарные операции процессора (например, CAS —
   Compare-And-Swap) вместо блокировок.
3. **Потокобезопасность:** Все методы Atomic переменных являются потокобезопасными без дополнительной синхронизации.
4. **Различные типы данных:** существуют классы для разных типов данных

- ```AtomicInteger```, ```AtomicLong```, ```AtomicBoolean```
- ```AtomicReference<T>```, ```AtomicStampedReference<T>```
- ```AtomicIntegerArray```, ```AtomicReferenceArray<T>```

## Пример использования ```AtomicInteger``` для счетчика

```java
public class AtomicCounter {
    private static final int NUM_THREADS = 10;
    private static final int INCREMENTS_PER_THREAD = 1000;

    private final AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        AtomicCounter example = new AtomicCounter();
        example.startThreads();
    }

    public void startThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<>(NUM_THREADS);

        // Создаем и запускаем потоки
        for (int i = 0; i < NUM_THREADS; i++) {
            threads.add(new Thread(new CounterTask()));
            threads.get(i).start();
        }

        // Ждем завершения всех потоков
        for (Thread thread : threads) {
            thread.join();
        }

        // Выводим окончательное значение счетчика
        System.out.println("Окончательное значение счетчика: " + atomicCounter.get());
    }

    private class CounterTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < INCREMENTS_PER_THREAD; i++) {
                atomicCounter.incrementAndGet(); // Атомарное увеличение счетчика на 1
            }
        }
    }
}
```

- **Класс ```AtomicCounterExample```**: Главный класс, содержащий метод main и логику запуска потоков.
- **Константы:**
    - ```NUM_THREADS```: количество потоков, которые будут одновременно инкрементировать счетчик (в данном примере 10).
    - ```INCREMENTS_PER_THREAD```: количество инкрементов, выполняемых каждым потоком (1000).
- **Переменная** ```atomicCounter```: Экземпляр ```AtomicInteger```, который будет использоваться в качестве общего
  счетчика для всех потоков.
- **Метод** ```startThreads()```:
    - Создает массив потоков.
    - Инициализирует каждый поток задачей CounterTask и запускает его.
    - Использует ```join()``` для ожидания завершения всех потоков.
- **Класс** ```CounterTask```:
    - Реализует интерфейс ```Runnable```.
    - В методе ```run()``` выполняет цикл, в котором инкрементирует ```atomicCounter``` с помощью
      метода ```incrementAndGet()```.

### Результат работы программы

После завершения всех потоков, окончательное значение счетчика должно быть равно:

```
NUM_THREADS * INCREMENTS_PER_THREAD = 10 * 1000 = 10 000
```
