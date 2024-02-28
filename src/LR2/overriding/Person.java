package LR2.overriding;

import java.util.Objects;

/**
 * Понятие POJO -объекта.
 * Пример правильной перегрузки стандартных методом, унаследованных от Object^
 *  - toString()
 *  - equals()
 *  - hashCode()
 *
 * POJO (англ. Plain Old Java Object) — «старый добрый Java-объект», простой Java-объект, не унаследованный от
 * какого-то специфического объекта и не реализующий никаких служебных интерфейсов сверх тех,
 * которые нужны для бизнес-модели.
 */
public class Person {
    private String name;
    private String secondName;
    private Integer age;
    private Gender gender;
    private Double height;
    private Double weight;

    public Person(String name, String secondName, Integer age, Gender gender, Double height, Double weight) {
        this.name = name;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * Пример правильной перегрузки toString().
     * Под правильно в данном случае будем считать соответсвие
     * реализации toString() базовый вещей в Java.
     *
     * Такой же вывод реализован в Record
     *
     * @return строкове представление объекта
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Пример правильной перегрузки метода hashCode().
     * Для всех примитивов и коллекций уже реализоаны адекватные способы вычисления хэша,
     * поэтому предлагается просто вызывать hash на каждое поле объекта.
     *
     * Стоит обратить внимание, что такой способ требует переопределение hashCode()
     * для всех полей. Т.е. если в качестве поля используется другой кастомный тип - сначала переопеределите hash там -
     * должна быть правильная "матрешка вычисления хэшей"
     *
     * Такой же hashCode() реализован в Record
     *
     * @return значение хэша
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                name,
                secondName,
                age,
                gender,
                height,
                weight
        );
    }

    /**
     * Пример правильной перегрузки equals()
     * Обратите внимание на то, что в качестве параметра передается тип Object
     *
     * Такой же equals() реализован в Record
     *
     * @param otherObject объект для сравнения
     */
    @Override
    public boolean equals(Object otherObject) {
        //возвратить логическое значение false,
        // если явный параметр имеет пустое значение null
        if (Objects.isNull(otherObject)) return false;      //Внимание к проверке на null

        //быстро проверить объекты на идентичность
        if (this == otherObject) return true;

        //если классы не совпадают, они не равны
        if (getClass() != otherObject.getClass()) return false;

        //Теперь известно, что объект otherObject
        //относится к типу Employee и не является пустым
        Person other = (Person) otherObject;

        // проверить, хранятся ли в полях объектов
        // одинаковые значения
        return name.equals(other.name)
                && secondName.equals(other.secondName)
                && age.equals(other.age)
                && gender.equals(other.gender)
                && height.equals(other.height)
                && weight.equals(other.weight);
    }
}

/**
 * Задание:
 * Реализуйте POJO класс User, у которого есть:
 *  - id
 *  - username
 *  - login
 *  - password
 *  - email
 *
 *  Т.е. должен содержать конструктор со всеми параметрами, геттеры, сеттеры, toString, hashCode, equals
 */
