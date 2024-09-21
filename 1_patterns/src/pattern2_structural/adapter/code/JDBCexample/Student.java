package pattern2_structural.adapter.code.JDBCexample;

import java.util.Objects;

/**
 * Класс студента, который мы хотим получить из БД
 */
public class Student {
    private String firstName;
    private String secondName;
    private Integer age;

    public Student(String firstName, String secondName, Integer age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(firstName, student.firstName) && Objects.equals(secondName, student.secondName) && Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age);
    }
}