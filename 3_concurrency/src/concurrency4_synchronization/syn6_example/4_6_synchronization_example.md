# Работа с разделяемым ресурсом

**Разделяемый ресурс** (англ. _shared resource_) в контексте многопоточного приложения — это любой объект, данные или
устройство, к которым одновременно могут обращаться несколько потоков выполнения. Такие ресурсы могут включать
переменные, коллекции данных, файлы, базы данных, устройства ввода-вывода и другие общие элементы, используемые
различными частями программы.

### Примеры разделяемых ресурсов

1. **Общие переменные и объекты:**
    - Переменные класса или экземпляра, доступные из разных потоков.
    - Списки, карты или другие коллекции, используемые для хранения данных, доступных нескольким потокам.
2. **Файлы и ресурсы ввода-вывода:**
    - Файлы, к которым обращаются несколько потоков для чтения или записи.
    - Сокеты или сетевые соединения, используемые разными потоками для передачи данных.
3. **Устройства:**
    - Общие устройства, такие как принтеры или базы данных, к которым обращаются несколько потоков.

## Проблемы при работе с разделяемыми ресурсами

Одновременный доступ нескольких потоков к одному и тому же ресурсу может привести к **состояниям гонки (race conditions)
**, когда итоговый результат зависит от порядка выполнения операций потоков. Это может вызвать некорректное поведение
программы, повреждение данных и трудноуловимые ошибки синхронизации.

# [Пример](code%2FWithoutAny.java) без какой-либо синхронизации

_Результаты представленных ниже вычислений без правильной работы с разделяемыми ресурсами могут варьироваться в
зависимости от множетсва факторов. Так что это нормально если ваши результаты не сойдутся с результатами представленными
здесь. Главное чтобы всё сошлось при правильной работе и вы получили ожидаемый результат :)_

Простой пример, где в качестве разделяемой переменной выступает счетчик. В 10 потоках будем увеличивать счетчик
на ```100_000``` - ожидаемый результат ```1_000_000```

```java
public class WithoutAny {
    static int counter = 0;     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++)
            counter++;
    }

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        System.out.println(counter);
    }
}
```

Если несколко раз запустить данную программу, то в среднем результат не достигает и ```10_000```. Потому что в данном
примере main поток не ожидает конца выполнения параллеьных потоков и выводит переменную сразу. Счетчик успевает
увеличиться лишь за то время пока главный поток запускает остальные потоки.

# [Пример](code%2FJoinMain.java) с синхронизацией потоков

Поскольку нам необходимо получить результат вычислений всех потоков и только потом вывести результат, то необходимо
чтобы main поток дождался выполнения побочных потоков. Достичь этого можно при помощи
метода [join](..%2Fsyn1_join%2F4_1_join.md).

```java
public class JoinMain {
    static int counter = 0;     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++)
            counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();

        System.out.println(counter);
    }
}
```

Если несколко раз запустить данную программу, то в среднем результат находится в промежутке ```120_000 - 180_000```. Это
уже лучше. Главный поток ждет выполнения побочных. Однако данный результат выглядит так, будто его считали 1-2 потока и
то не успели. Это связано с тем что потоки вступают в гонку и неконтролируемо обащаются к общему ресурсы, переписывая и
игнорируя результаты друг друга.

# [Пример](code%2FVolatileMain.java) с volatile переменной

Теперь попробуем использование ```volatile``` переменной, что предотвратит кэширование общей переменной в потоках, а
значит все изменения ДОЛЖНЫ быть доступны и видны всем остальным потокам.

```java
public class VolatileMain {
    static volatile int counter = 0;     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++)
            counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();
        System.out.println(counter);
    }
}
```

Теперь результат в промежутке ```150_000 - 200_000```, что уже лучше предедущего, но всё еще не достаточно. Причины:

1. ```volatile``` реально работает только при атомарных операциях (которые успевают выполнится за предоставленный квант
   времени).
2. ```volatile``` не решает проблему гонки данных. Пример: один поток начал считать с 0, другой с 17000, третий насчитал
   23000 и перезаписал общую перемнную и тд и тп.

# [Пример](code%2FVolatileMain.java) с atomic переменной

При использовании ```AtomicIteger``` в данной задаче мы получим ожидаемый результат.

```java
public class AtomicMain {
    static AtomicInteger counter = new AtomicInteger(0);     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++)
            counter.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();

        System.out.println(counter);
    }
}
```

Получаем ожидаемый результат ```1_000_000```. Операции с Atomic перемнными гарантированно выполняются в отведенный квант
времени. Помимо того они являются (содержат внутри класса) ```volatile``` переменную. И того такие переменные не
кешируются и операции над ними укладываются в квант времени.

В данном примере вычисление проводится действительно "в нескольких потоках", в отличии от примеров, которые будут
приведены ниже.

# [Пример](code%2FMutexMain.java) с Mutex (правильный)

Для правильной работы с разделяемым ресурсом ограничим работу с ним при помощи Mutex-a.

```java
public class MutexMain {
    static int counter = 0;     // разделяемая переменная
    static Lock lock = new ReentrantLock();

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        lock.lock();
        for (int j = 0; j < 100000; j++) counter++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();
        System.out.println(counter);
    }
}
```

Получаем ожидаемый результат ```1_000_000```. Однако на самом деле все операции проводились в одном поке... Но здесь
хотя бы Mutex использовался правильно. При обращении к критической секции происходит наложение монитора,
все ```100_000``` операций, которые должен выполнить поток и только потом снятие монитора.

# [Пример](code%2FMutexMain.java) с Mutex (не правильный)

Однако изменив всего 2 строки в коде можно замедлить выполнение программы на порядок.

```java
public class MutexIncorrectMain {
    static int counter = 0;     // разделяемая переменная
    static Lock lock = new ReentrantLock();

    //задача, которая будет выполняться в многопоточности
    public static void cyclicAdd() {
        for (int j = 0; j < 100000; j++) {
            lock.lock();
            counter++;
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();
        System.out.println(counter);
    }
}
```

Мы все так же получаем ожидаемые ```1_000_000```. Однако теперь каждый поток накладывает монитор, выполняет инкремент
один раз и снимает монитор. И так каждый поток делает ```100_000``` раз. Накладывание и снятие монитора тяжеловесная
операция из-за чего время выполнения программы возрасло в разы.

# [Пример](code%2FSynchronizationMain.java) с synchronized

Такого же эффекта как при правильном использования Mutex из примера выше мы можем добиться добавив ключевое
слово ```synchronized``` в сигнатуру метода.

```java
public class SynchronizationMain {
    static int counter = 0;     // разделяемая переменная

    //задача, которая будет выполняться в многопоточности
    public synchronized static void cyclicAdd() {
        for (int j = 0; j < 100000; j++) counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    cyclicAdd();
                }
            }));
        }

        for (var t : threads) t.start();
        for (var t : threads) t.join();
        System.out.println(counter);
    }
}
```

Получаем ожидаемый результат ```1_000_000```. Однако на самом деле все операции проводились в одном поке...