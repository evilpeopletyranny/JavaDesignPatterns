# Facade

## Фасад

**Фасад** — это структурный паттерн проектирования, который предоставляет простой интерфейс к сложной системе классов,
библиотеке или фреймворку.

В разработке программного обеспечения часто возникает необходимость взаимодействовать с комплексными системами или
наборами классов, которые имеют сложные интерфейсы. Это может усложнить процесс интеграции и повысить связанность между
компонентами системы. Паттерн проектирования **Фасад** (Facade) предоставляет решение этой проблемы, предлагая простой
интерфейс для взаимодействия с более сложными системами или библиотеками.

Один из самых простых паттернов. Скорее всего вы его часто используете, даже не задумываясь, что это фасад.

#### Основная идея

Основная идея паттерна Фасад заключается в том, чтобы предоставить клиентам простой интерфейс для взаимодействия с
комплексной подсистемой, делегируя вызовы соответствующим объектам внутри подсистемы. Это снижает связанность между
клиентом и подсистемой, облегчает использование и понимание системы.

#### Применение

Примеры, когда можно использовать паттерн фасад:

1. Когда вам нужно представить простой или урезанный интерфейс к сложной подсистеме.
2. Когда вы хотите разложить подсистему на отдельные слои.
3. Когда необходимо скрыть особенности реализации от пользователя.

### Реализация

1. Определите можно ли создать более простой интерфейс, чем тот, который предоставляет сложная подсистема. Вы на
   правильном пути, если этот интерфейс избавит клиента от знания о подробностях подсистемы.
2. Создайте класс фасада, реализующий этот интерфейс. Он должен переадресовывать вызовы клиента нужным объектам
   подсистемы. Фасад должен будет позаботиться о том, чтобы правильно инициализировать объекты подсистемы.
3. Вы получите максимум пользы, если клиент будет работать только с фасадом. В этом случае, изменения в подсистеме будут
   затрагивать только код фасада, а клиентский код останется рабочим.
4. Если ответственность фасада начинает размываться, подумайте о введении дополнительных фасадов.

#### Типы Фасадов

- **Фасад для подсистемы:** Обеспечивает простой интерфейс для взаимодействия с одной подсистемой.
- **Фасад для архитектуры:** Может охватывать несколько подсистем, предоставляя единый интерфейс для различных
  компонентов системы.

### Примеры

#### Примеры паттерна фасад в стандартной библиотеке Java

- Класс ```java.lang.Runtime``` предоставляет интерфейс к среде выполнения Java приложения. Он выступает в роли фасада,
  скрывая сложность взаимодействия с JVM и предоставляя простые методы для выполнения операций, таких как запуск внешних
  процессов, освобождение памяти и завершение приложения.
- Класс ```java.util.Collections``` предоставляет статические методы, которые действуют как фасад для различных операций
  над коллекциями, таких как сортировка, синхронизация, создание неизменяемых коллекций и т.д.
- Класс ```java.util.Arrays``` предоставляет множество статических методов для работы с массивами, выступая в роли
  фасада, скрывающего сложность работы с низкоуровневыми операциями над массивами.

#### [Пример](code%2Fexample1_car%2FMain.java) с работой двигателя автомобиля

Допустим у нас реализована правильная логика запуска вигателя автомобиля включающее множество шагов: включение
инжектора, ввод
топлива, контроль этого всго и тд и тп. Но пользователю (автомобилисту) нет необходимости знать о том как что происходит
и в каком порядке. Он просто хочется сесть, завести машину и поехать.

Реализуем фасад, который внутри себя скрывает все процессы по запуску и останову двигателя автомобиля, а во внешний мир
для пользователем дадим лишь кнопку вкл/выкл.

Тем более прописав один раз правильный порядок выполнения действий и спрятов его пользователь не должен будет каждый раз
вспомнимать и реализовывать правильный порядок.

_Часть классов опущена, потому что не несет смысловой нагрузки_

Класс **фасад**, скрывающий правильную последовательность действий при запуске и останове двигателя.

```java
public class CarEngineFacade {
    private static int DEFAULT_COOLING_TEMP = 90;
    private static int MAX_ALLOWED_TEMP = 50;
    private FuelInjector fuelInjector = new FuelInjector();
    private AirFlowController airFlowController = new AirFlowController();
    private Starter starter = new Starter();
    private CoolingController coolingController = new CoolingController();
    private CatalyticConverter catalyticConverter = new CatalyticConverter();

    //Запуск двигателя
    public void startEngine() {
        fuelInjector.on();
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();
    }

    //Останов двигателя
    public void stopEngine() {
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();
    }
}
```

```java
/**
 * Эмитируем работу двигателя.
 * Все части двигателя находятся в пакете engine и не интересуют нас.
 */
public class Main {
    public static void main(String[] args) {
        int DEFAULT_COOLING_TEMP = 90;
        int MAX_ALLOWED_TEMP = 50;
        FuelInjector fuelInjector = new FuelInjector();
        AirFlowController airFlowController = new AirFlowController();
        Starter starter = new Starter();
        CoolingController coolingController = new CoolingController();
        CatalyticConverter catalyticConverter = new CatalyticConverter();

        //Правильная последовательность действий для включения двигателя.
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();

        //Правильная последовательность действий для выключения двигателя.
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();

        System.out.println("-------------------------");

        //Пользователю не интересно как работает двигатель и какова правильная последовательность действий.
        //Пользователь хочет кнопку вкл/выкл, с которой легко работать и она не требует глубинных знаний.
        //Здесь как раз таки и поможет паттерн фасад.
        CarEngineFacade carEngineFacade = new CarEngineFacade();

        //нажали вкл
        carEngineFacade.startEngine();

        //нажали выкл
        carEngineFacade.stopEngine();

        //Пользователю не приходиться знать внутренностей и последовательность действий.
        //К тому же если добавяться новые элементы или поменяется последовательность,
        //то у пользователя также остануться лишь кнопки вкл/выкл
    }
}
```

#### [Пример](code%2Fexample1_car%2FMain.java) фасад для работы с файлами

Рассмотрим другой пример, где паттерн Фасад используется для упрощения операций с файловой системой.

```java
import java.io.IOException;

public interface FileFacade {
    void createFile(String path) throws IOException;

    void deleteFile(String path) throws IOException;

    void writeFile(String path, String content) throws IOException;

    String readFile(String path) throws IOException;
}
```

```java
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileFacadeImpl implements FileFacade {

    @Override
    public void createFile(String path) throws IOException {
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("File created: " + path);
        } else {
            System.out.println("File already exists: " + path);
        }
    }

    @Override
    public void deleteFile(String path) throws IOException {
        Files.deleteIfExists(Paths.get(path));
        System.out.println("File deleted: " + path);
    }

    @Override
    public void writeFile(String path, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(content);
        writer.close();
        System.out.println("Written to file: " + path);
    }

    @Override
    public String readFile(String path) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(path)));
        System.out.println("Read from file: " + path);
        return content;
    }
}
```

```java
public class FileMain {
    public static void main(String[] args) {
        FileFacade fileFacade = new FileFacadeImpl();
        String filePath = "example.txt";

        try {
            // Создание файла
            fileFacade.createFile(filePath);

            // Запись в файл
            fileFacade.writeFile(filePath, "Hello, Facade Pattern!");

            // Чтение из файла
            String content = fileFacade.readFile(filePath);
            System.out.println("File Content: " + content);

            // Удаление файла
            fileFacade.deleteFile(filePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

- ```FileFacade``` определяет простой интерфейс для операций с файлами.
- ```FileFacadeImpl``` реализует этот интерфейс, используя стандартные классы Java для работы с файлами.
- Клиентский код использует фасад для выполнения операций с файлом, не взаимодействуя напрямую с низкоуровневыми API.

### Плюсы данного паттерна

- **Упрощение интерфейса:** Клиенты взаимодействуют с подсистемой через простой интерфейс, не зная о её внутренней
  сложности.
- **Снижение связанности:** Фасад изолирует клиентов от деталей реализации подсистемы, что облегчает изменение
  подсистемы без влияния на клиентский код.
- **Упрощение использования:** Позволяет клиентам выполнять сложные операции через несколько простых методов фасада.
- **Повышение модульности:** Разделение ответственности между фасадом и подсистемой улучшает структуру кода и облегчает
  его поддержку.

### Недостатки данного паттерна

- **Ограничение гибкости:** Клиентский код может быть ограничен предоставляемыми фасадом возможностями и не иметь
  доступа к более тонким аспектам подсистемы.
- **Добавление дополнительного уровня абстракции:** Может увеличить количество классов в системе, что усложняет её
  структуру.
- **Необходимость поддерживать фасад:** При изменении подсистемы может потребоваться обновление фасада, чтобы он
  соответствовал новым возможностям или интерфейсам.

### Заключение

Паттерн проектирования **Фасад** является мощным инструментом для упрощения взаимодействия с комплексными системами и
подсистемами. Он предоставляет клиентам единый, упрощённый интерфейс, скрывая внутреннюю сложность и снижая связанность
между компонентами системы.

Правильное применение паттерна Фасад способствует созданию более чистой, модульной и легко поддерживаемой архитектуры
приложений. Однако, как и любой паттерн, его следует применять осознанно, учитывая требования и специфику проекта, чтобы
избежать избыточной абстракции и усложнения системы.

### Источники

- Design Patterns with Java: Facade
- Введение в паттерны проектирования: Фасад