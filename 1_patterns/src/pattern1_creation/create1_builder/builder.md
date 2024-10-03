# Builder

## Строитель

**Билдер** — это порождающий паттерн проектирования, который позволяет создавать сложные объекты пошагово. Строитель
даёт возможность использовать один и тот же код строительства для получения разных представлений объектов.

В разработке программного обеспечения часто возникает необходимость создания объектов с множеством параметров, особенно
когда некоторые из них являются опциональными. Паттерн проектирования **Билдер (Builder)** предоставляет гибкий способ
создания сложных объектов, разделяя процесс их конструирования и представляя различные варианты их построения.

Почему то билдер не очень любят, но на самом деле у него есть много хороших применений:

- Разбиение гиганского конструктора на отдельные шаги. **В Java нет возможности указывать имя параметра при передаче,
  как например в Python, Kotlin, Scala**. Что сильно затрудняет чтение.
- Вариация шагов при создани объекта.
- За счет разных версий строителя может достигаться разный набор параметров в объекте.
- **Использование параметров по умолчанию (т.к. Java такого не умеет)**.
- Построение объекта на основе данных, получаемых в разных местах.

### Реализация

Реализация билдера в общем случае проста и заключается в разбиении телескопического конструктора на шаги.

#### Вариации

Есть множество вариантов как реализовать билдер, например:

- Статический внутренний класс.
- Внешний класс с использованием интерфейсов.
- Билдер со всеми обязательными полями.
- Билдер с полями по умолчанию.
- Билдер без проверки переданных данных перед пострением объекта.
- Билдер с проверкой переданных данных перед пострением объекта.
- Объединение нескольких указанных выше вариантов.

### Примеры

#### О примерах в книгах

В книге **Погружение в паттерны проектирования** *Александра Швеца* объяснение билдера осложнено введением класса
Директора. Директор не имеет прямого отношения к билдеру и является лишь надстройкой, которая позволяет использовать (
подсовывать директору) разные реализации билдеров, если такие есть.

Более удачный пример есть в книге **Design Patterns with Java** *Olaf Mysch*, где разбивается конструктор с 10+
параметрами.

#### Пример стандартной библиотеки

- Самой простой пример это класс ```StringBuilder```. Этот класс позволяет работать с изменяемыми строками, где в
  качестве шагов создания добавляются символы в строку. *Всё гениальное просто*.

#### Пример [Trip](code%2Fexample1_trip%2FTrip.java) с большим конструктором

В данном примере рассматривается следующее:

- Конструктор с большим кол-вом параметров.
- Вложенный статический билдер.
- В билдере указываются значения по умолчанию.
- Использование **паттерна Fluent Interface**.

**Fluent Interface** — это стиль программирования/паттерн, который позволяет связывать вызовы методов друг с другом для
создания более читаемого и выразительного кода. В данном примере он выражется в цепочке вызовов методов билдера.

```java
import java.time.LocalDate;
import java.util.Objects;

/**
 * Класс поездки, который содержит много-много параметров.
 * Для использования параметров по умолчанию можно
 * поля изначально инициализировать какими-то значениями, либо предоставить это
 * действие билдеру.
 * В данном примере значения по умолчанию будут указываться в билдере.
 */
public class Trip {
    private final LocalDate startDate;              //дата начала поездки
    private final LocalDate endDate;                //дата конца поездки
    private final String start;                     //начальный пункт
    private final String end;                       //конечный пункт
    private final Integer duration;                 //продолжительность
    private final Integer numberTraveller;          //кол-во путешественников
    private final Integer numberKids;               //кол-во детей
    private final Integer minimumStars;             //минимальное кол-во звезд
    private final Integer minimumRecommendations;   //минимальное кол-во рекомендаций
    private final Integer rating;                   //рейтинг
    private final Integer minimumNumberRatings;     //минимальное кол-во отзывов с рейтингом

    /**
     * Большой ужасный конструктор
     */
    public Trip(LocalDate startDate,
                LocalDate endDate,
                String start,
                String end,
                Integer duration,
                Integer numberTraveller,
                Integer numberKids,
                Integer minimumStars,
                Integer minimumRecommendations,
                Integer rating,
                Integer minimumNumberRatings) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.start = start;
        this.end = end;
        this.duration = duration;
        this.numberTraveller = numberTraveller;
        this.numberKids = numberKids;
        this.minimumStars = minimumStars;
        this.minimumRecommendations = minimumRecommendations;
        this.rating = rating;
        this.minimumNumberRatings = minimumNumberRatings;
    }

    /**
     * Приватный конструктор
     *
     * @param builder на основе чего будет создан новый объект
     */
    private Trip(Builder builder) {
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.start = builder.start;
        this.end = builder.end;
        this.duration = builder.duration;
        this.numberTraveller = builder.numberTraveller;
        this.numberKids = builder.numberKids;
        this.minimumStars = builder.minimumStars;
        this.minimumRecommendations = builder.minimumRecommendations;
        this.rating = builder.rating;
        this.minimumNumberRatings = builder.minimumNumberRatings;
    }

    public static class Builder {
        private LocalDate startDate;
        private LocalDate endDate;
        private String start;
        private String end;
        private Integer duration = 1;                    //по умолчанию продолжительность 1
        private Integer numberTraveller = 1;             //по умолчанию 1 путешесвенник
        private Integer numberKids = 0;                  //по умолчанию 0 детей
        private Integer minimumStars = 3;                //по умолчанию минимум 3 звезды
        private Integer minimumRecommendations = 100;    //минимум 100 отзывов
        private Integer rating = 4;                      //минимуальный рейтинг 4
        private Integer minimumNumberRatings = 20;       //миниумальное кол-во отзывов с рейтингом 20

        /**
         * В конструкторе можно определить несколько значений, которые
         * ВСЕГДА требуют инициализации и НЕ ИМЕЮТ параметров по умолчанию.
         * Или можно вобще все скинуть в отдельные методы - тут уже на ваше усмотрение
         *
         * @param startDate дата начала поездки
         * @param endDate   дата окончания поездки
         * @param start     место начала
         * @param end       место конца
         */
        public Builder(LocalDate startDate,
                       LocalDate endDate,
                       String start,
                       String end) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.start = start;
            this.end = end;
        }

        /**
         * Самый главный метод билдера - build(),
         * в котором создаются новые объекты.
         * В данном случае это делается через приватный конструктор, который
         * принимает билдер.
         *
         * @return созданная поездка
         */
        public Trip build() {
            return new Trip(this);
        }

        //На остальные поля делаются "сеттеры"
        //Эти сеттеры и будут "шагами" для создания объекта
        //ВАЖНОЙ!!! В качестве возвращаемого значения они должны
        //возвращать сам Builder, чтобы можно было
        //продложить вызов цепочки методов.
        public Builder setDuration(Integer duration) {
            this.duration = duration;
            return this;
        }

        public Builder setNumberTraveller(Integer numberTraveller) {
            this.numberTraveller = numberTraveller;
            return this;
        }

        public Builder setNumberKids(Integer numberKids) {
            this.numberKids = numberKids;
            return this;
        }

        public Builder setMinimumStars(Integer minimumStars) {
            this.minimumStars = minimumStars;
            return this;
        }

        public Builder setMinimumRecommendations(Integer minimumRecommendations) {
            this.minimumRecommendations = minimumRecommendations;
            return this;
        }

        public Builder setRating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public Builder setMinimumNumberRatings(Integer minimumNumberRatings) {
            this.minimumNumberRatings = minimumNumberRatings;
            return this;
        }
    }

    @Override
    public boolean equals(Object otherObject) {
        if (Objects.isNull(otherObject)) return false;
        if (this == otherObject) return true;
        if (getClass() != otherObject.getClass()) return false;

        Trip trip = (Trip) otherObject;
        return duration.equals(trip.duration) &&
                numberTraveller.equals(trip.numberTraveller) &&
                numberKids.equals(trip.numberKids) &&
                minimumStars.equals(trip.minimumStars) &&
                minimumRecommendations.equals(trip.minimumRecommendations) &&
                rating.equals(trip.rating) &&
                minimumNumberRatings.equals(trip.minimumNumberRatings) &&
                startDate.equals(trip.startDate) &&
                endDate.equals(trip.endDate) &&
                start.equals(trip.start) &&
                end.equals(trip.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                startDate,
                endDate,
                start,
                end,
                duration,
                numberTraveller,
                numberKids,
                minimumStars,
                minimumRecommendations,
                rating,
                minimumNumberRatings);
    }

    @Override
    public String toString() {
        return "Trip[" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                ", duration=" + duration +
                ", numberTraveller=" + numberTraveller +
                ", numberKids=" + numberKids +
                ", minimumStars=" + minimumStars +
                ", minimumRecommendations=" + minimumRecommendations +
                ", rating=" + rating +
                ", minimumNumberRatings=" + minimumNumberRatings +
                ']';
    }
}
```

#### Пример [Computer](code%2Fexample2_computer%2FComputer.java)

В данном примере рассматривается следующее:

- Конструктор с большим кол-вом параметров.
- Вложенный статический билдер.
- В билдере указываются значения по умолчанию.
- Использование **паттерна Fluent Interface**.

_Название методов - шагов создания - методов реализующих **Fluent Interface** не обязательно должно относится к
геттерам.
Можно просто использоваться имена полей._

```java
public class Computer {
    // Обязательные параметры
    private String CPU;
    private String RAM;

    // Опциональные параметры
    private String storage;
    private String GPU;
    private String OS;

    /**
     * Приватный конструктор, который принимает в себя билдер.
     *
     * @param builder
     */
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
        this.OS = builder.OS;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", storage='" + storage + '\'' +
                ", GPU='" + GPU + '\'' +
                ", OS='" + OS + '\'' +
                '}';
    }

    /**
     * Вложенный статичсекий класс Билдер.
     */
    public static class Builder {
        // Обязательные параметры
        private String CPU;
        private String RAM;

        // Опциональные параметры
        private String storage;
        private String GPU;
        private String OS;

        /**
         * В конструкторе указываются обязательные поля.
         *
         * @param CPU
         * @param RAM
         */
        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        /**
         * Метод оптицианальной установки поля storage
         *
         * @param storage значение для поля storage
         */
        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        /**
         * Метод оптицианальной установки поля GPU
         *
         * @param GPU значение для поля GPU
         */
        public Builder GPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        /**
         * Метод оптицианальной установки поля OS
         *
         * @param OS значение для поля OS
         */
        public Builder OS(String OS) {
            this.OS = OS;
            return this;
        }

        /**
         * Метод построения объекта на основе билдера.
         *
         * @return созданный класс Computer
         */
        public Computer build() {
            return new Computer(this);
        }
    }
}


```

### Плюсы данного паттерна

- **Разделение конструкции и представления**: Позволяет создавать различные представления объекта, используя один и тот
  же процесс построения.
- **Упрощение создания объектов**: Избегает необходимости создавать конструкторы с большим числом параметров или
  использовать множество конструкторов для различных комбинаций параметров.
- **Повышение читаемости кода**: Код создания объекта становится более понятным и структурированным, особенно при
  использовании Fluent Interface.
- **Гибкость**: Легко добавлять новые опциональные параметры без изменения существующих классов.

### Недостатки данного паттерна

- **Увеличение количества кода**: Требуется создание дополнительных классов (Builder), что может привести к увеличению
  объёма кода.
- **Отсутствие поддержки рекурсии**: Паттерн может быть неудобен при создании объектов, содержащих рекурсивные
  структуры.

### Источники

- Design Patterns with Java: Builder
- Введение в паттерны проектирования: Строитель