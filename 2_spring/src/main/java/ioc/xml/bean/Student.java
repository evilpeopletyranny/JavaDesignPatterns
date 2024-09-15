package ioc.xml.bean;

import java.util.Objects;

/**
 * Типичный POJO студент.
 * Данный класс является универсальным для всех методов инициализации
 * бинов: через конструктор, геттеры и сеттеры.
 * Также содержит фабричный метод.
 * <p>
 * При выполнении ЛР выберите один из способов инициализации бинов и работайте с ним!
 * Не надо намешивать всё подряд.
 * Например при инициализации через конструктор вам не нужны: пустой конструктор
 * и фабричный метод.
 */
public class Student {
    private String name;
    private Integer age;
    private String group;
    private String creationType;

    /**
     * Явно задаем конструктор без параметров, т.к. есть другие конструкторы.
     * Конструктор без параметров используется при инициализации бина
     * через сеттеры.
     */
    public Student() {
    }

    /**
     * Конструктор с параметрами.
     * Создание бина через конструктор
     */
    public Student(String name, Integer age, String group, String creationType) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.creationType = creationType;
    }

    /**
     * Фабричный метод, используется для инициализации бина через фабричный метод.
     */
    public static Student createStudent(String name, Integer age, String group, String creationType) {
        return new Student(name, age, group, creationType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCreationType() {
        return creationType;
    }

    public void setCreationType(String creationType) {
        this.creationType = creationType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", group='" + group + '\'' +
                ", creationType='" + creationType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name)
                && Objects.equals(age, student.age)
                && Objects.equals(group, student.group)
                && Objects.equals(creationType, student.creationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                age,
                group,
                creationType);
    }
}
