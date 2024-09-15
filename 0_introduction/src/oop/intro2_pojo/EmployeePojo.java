package oop.intro2_pojo;

import java.time.LocalDate;

/**
 * Java POJO (Plain Old Java Object) — это простой объект Java, который не зависит от каких-либо специфических фреймворков
 * или библиотек. В POJO нет соглашений об именовании полей, методов, наличии конструкторов и возможности внесения
 * изменений в класс и объекты. Также поля в POJO объекте могут иметь модификатор доступа public, что открывает к ним доступ извне.
 * <p>
 * Пример POJO класса.
 * - public поля
 * - нет пустого конструктора
 * - нет сериализации
 */
public class EmployeePojo {
    public String firstName;
    public String lastName;
    private LocalDate startDate;

    public EmployeePojo(String firstName, String lastName, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public String name() {
        return this.firstName + " " + this.lastName;
    }

    public LocalDate getStart() {
        return this.startDate;
    }
}