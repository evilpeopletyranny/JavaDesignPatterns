# Proxy

## Заместитель

**Прокси** — это структурный паттерн проектирования, который позволяет подставлять вместо реальных объектов
специальные объекты-заменители. Эти объекты перехватывают вызовы к оригинальному объекту, позволяя сделать что-то до или
после передачи вызова оригиналу.

В разработке программного обеспечения часто возникает необходимость контролировать доступ к объектам, добавлять
дополнительную функциональность или управлять ресурсами. Структурный паттерн проектирования **Прокси** (Proxy)
предоставляет решение для этих задач, позволяя создавать заместителей (прокси) для других объектов. Прокси выступает в
роли посредника между клиентом и реальным объектом, перехватывая и управляя вызовами методов.

#### Основная идея

Основная идея паттерна Прокси заключается в том, чтобы предоставить объект-прокси, который имеет тот же интерфейс, что и
реальный объект, и управляет доступом к нему. Это позволяет внедрять дополнительные функциональности и контролировать
взаимодействие с реальным объектом.

#### Применение

1. **"Виртуальный прокси"** - ленивая инициализация. Позволяет отложить создание тяжелого объекта до
   необходимости/обращения. Загрузка больших объектов на старте программы может суещсвтенно повлиять на запуск по
   времени и памяти.
2. **"Защищающий прокси"** - разраничение доступа к объекту/части системы. Через прокси реализуются методы проверки.
3. **"Умный прокси/умная ссылка"** - когда необходимо кэшировать результаты запросов клиентов и управлять их жизненным
   циклом.
4. **"Удаленный прокси"** - прокси транслирует запросы клиента в виде понятном удаленными сервису.
5. **"Логирующий прокси"** - хранит историю обращений к сервисному объекту.
6. **"Сихнронизирующий прокси"** - проверка доступа к разделяемому ресурсу
7. и тд. Примеров ещё не мало.

### Реализация

1. Определите интерфейс, который бы сделал заместитель и оригинальный объект взаимозаменяемыми.
2. Создайте класс заместителя. Он должен содержать ссылку на сервисный объект. Чаще всего, сервисный объект создаётся
   самим заместителем. В редких случаях, заместитель получает готовый сервисный объект от клиента через конструктор.
3. Реализуйте методы заместителя в зависимости от его предназначения. В большинстве случаев, проделав какуюто полезную
   работу, методы заместителя должны передать запрос сервисному объекту.
4. Подумайте, не реализовать ли вам ленивую инициализацию сервисного объекта при первом обращении клиента к методам
   заместителя.

### Примеры

#### Примеры паттерна адаптер в стандартной библиотеке Java

- В стандартной библиотеке Java **Прокси** также встречается.
  Например: ```java.lang.reflect.Proxy```, ```java.rmi```, ```javax.servlet.Proxy ``` (Сложны для рассмотрения).

#### [Пример](code%2Fexample1_cache%2FCachingProxyMain.java) кэширующего прокси

```java
public interface DataService {
    String fetchData(String parameter);
}
```

```java
public class DataServiceImpl implements DataService {

    @Override
    public String fetchData(String parameter) {
        // Симуляция дорогостоящей операции, например, запрос к внешнему API
        simulateExpensiveOperation();
        return "Data for " + parameter;
    }

    private void simulateExpensiveOperation() {
        try {
            System.out.println("Fetching data from external source...");
            Thread.sleep(3000); // Симуляция задержки 3 секунды
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

```java
import java.util.HashMap;
import java.util.Map;

public class CachingDataServiceProxy implements DataService {
    private DataService realDataService;
    private Map<String, String> cache;

    public CachingDataServiceProxy(DataService realDataService) {
        this.realDataService = realDataService;
        this.cache = new HashMap<>();
    }

    @Override
    public String fetchData(String parameter) {
        if (cache.containsKey(parameter)) {
            System.out.println("Returning cached data for: " + parameter);
            return cache.get(parameter);
        }

        System.out.println("No cache found for: " + parameter + ". Fetching data...");
        String data = realDataService.fetchData(parameter);
        cache.put(parameter, data);
        return data;
    }
}
```

```java
public class CachingProxyMain {
    public static void main(String[] args) {
        // Создание реального объекта DataService
        DataService realDataService = new DataServiceImpl();

        // Создание прокси с функциональностью кэширования
        DataService cachingProxy = new CachingDataServiceProxy(realDataService);

        // Первый запрос с параметром "param1" — данные будут загружены и закэшированы
        System.out.println("First request:");
        String data1 = cachingProxy.fetchData("param1");
        System.out.println("Received: " + data1);

        System.out.println();

        // Второй запрос с тем же параметром "param1" — данные будут получены из кэша
        System.out.println("Second request:");
        String data2 = cachingProxy.fetchData("param1");
        System.out.println("Received: " + data2);

        System.out.println();

        // Запрос с новым параметром "param2" — данные будут загружены и закэшированы
        System.out.println("Third request:");
        String data3 = cachingProxy.fetchData("param2");
        System.out.println("Received: " + data3);

        System.out.println();

        // Повторный запрос с параметром "param2" — данные будут получены из кэша
        System.out.println("Fourth request:");
        String data4 = cachingProxy.fetchData("param2");
        System.out.println("Received: " + data4);
    }
}
```

#### [Пример](code%2Fexample1_cache%2FMain.java) кеширующего прокски (неудачный)

Представим что у нас есть сервис - аналог YouTube, интерфейс которого заключается в возможности скачать видео, получить
видео по имени, получить список видео. Но допустим что запрос к сервису и само скачивание видео операция долго и
тяжелая. Для решении данной проблемы реализуем кеширующее прокси.

```java
public record Video(Integer id,
                    String name) {
}
```

```java
/**
 * Интерфейс удаленного сервиса.
 * Интерфейс имеет тот же функционал, что и заворачиваемый в него объект.
 */
public interface ThirdPartyYoutubeLib {
    List<Video> getVideoList();

    String getVideoName(Integer id);

    Video downloadVideo(Integer id);
}
```

```java
/**
 * Конкретная реализация сервиса, который будет обернут в прокси.
 */
public final class ThirdPartyYoutubeClass implements ThirdPartyYoutubeLib {
    private final List<Video> downloadedVideo = List.of(
            new Video(1, "Учимся программировать на Java."),
            new Video(2, "Изучаем паттерны проектирования на Java."),
            new Video(3, "Использование современных фреймоврков, реализующий паттерны проектирования."),
            new Video(4, "использование паттренов проектирования в мультипоточном программировании."));

    public List<Video> getVideoList() {
        return downloadedVideo;
    }

    public String getVideoName(Integer id) {
        return downloadedVideo.stream().filter(video -> video.id().equals(id)).findFirst().get().name();
    }

    public Video downloadVideo(Integer id) {
        return downloadedVideo.stream().filter(video -> video.id().equals(id)).findFirst().get();
    }
}
```

```java
/**
 * Пример "умного"/кешируюего прокси на сервисом
 * ThirdPartyYoutubeClass.
 * <p>
 * Прокси должен реализовывать интерфейс, аналогичный используемому сервису.
 * <p>
 * Пример простой и надуманный, но показательный.
 */
public class CachedYoutubeProxy implements ThirdPartyYoutubeLib {
    /**
     * Сервис, который "заворачивается" в прокси
     */
    private ThirdPartyYoutubeClass thirdPartyYoutubeClass = new ThirdPartyYoutubeClass();
    private List<Video> listCache;
    private Video videoCache;

    /**
     * В конструктор передаем ссылку на сервис.
     * Если у нас предусматривается только одно прокси, то в общем-то можно инициализировать поле сразу.
     */
    public CachedYoutubeProxy() {
    }

    /**
     * Получение списка видео.
     * Сначала выолняется проверка не лежит ли данный список в кэше.
     * Последний загруженный список становится кэшированным.
     *
     * @return список видео.
     */
    @Override
    public List<Video> getVideoList() {
        if (Objects.isNull(listCache) || listCache.isEmpty()) listCache = thirdPartyYoutubeClass.getVideoList();
        return listCache;
    }

    /**
     * Получение имени видео.
     * Сначала прверяется не лежит ли данное видео в кэше.
     * Последнее загруженное видео становиться кэшированным.
     *
     * @param id видое имя которого необходимо найти
     * @return имя видео
     */
    @Override
    public String getVideoName(Integer id) {
        if (Objects.isNull(videoCache) || !videoCache.id().equals(id))
            videoCache = thirdPartyYoutubeClass.downloadVideo(id);
        return videoCache.name();
    }

    /**
     * Получение видео.
     * Сначала прверяется не лежит ли данное видео в кэше.
     * Последнее загруженное видео становиться кэшированным.
     *
     * @param id видео которое необходимо найти
     * @return найденное видео
     */
    @Override
    public Video downloadVideo(Integer id) {
        if (Objects.isNull(videoCache) || !videoCache.id().equals(id))
            videoCache = thirdPartyYoutubeClass.downloadVideo(id);
        return videoCache;
    }
}
```

### Плюсы данного паттерна

- **Контроль доступа:** Прокси может контролировать доступ к реальному объекту, реализуя механизмы аутентификации или
  авторизации.
- **Добавление функциональности:** Позволяет динамически добавлять новые поведения (например, логирование, кэширование)
  без изменения реального объекта.
- **Ленивая инициализация:** Прокси может создавать реальный объект только при необходимости, экономя ресурсы.
- **Упрощение интерфейсов:** Прокси может предоставлять упрощённый интерфейс к сложной подсистеме, снижая связанность
  между компонентами.
- **Безопасность:** Прокси может защищать реальный объект от некорректного использования клиентами.

### Недостатки данного паттерна

- **Увеличение сложности системы:** Введение прокси добавляет дополнительный уровень абстракции, что может усложнить
  архитектуру приложения.
- **Потенциальная задержка:** Дополнительные вызовы методов через прокси могут привести к незначительным задержкам в
  производительности.
- **Сложность отладки:** Множественные уровни прокси могут затруднить процесс отладки и отслеживания проблем в системе.
- **Необходимость поддержки прокси:** Изменения в реальном объекте могут потребовать обновления прокси для корректного
  взаимодействия.

### Заключение

Паттерн проектирования Прокси является мощным инструментом для управления доступом к объектам, добавления дополнительной
функциональности и оптимизации использования ресурсов.

Правильное применение паттерна Прокси способствует созданию более гибкой, расширяемой и безопасной архитектуры
приложений. Однако, необходимо учитывать возможные недостатки, такие как увеличение сложности и потенциальные задержки,
чтобы эффективно использовать этот паттерн в своих проектах.

### Источники

- Design Patterns with Java: Proxy
- Введение в паттерны проектирования: Заместитель