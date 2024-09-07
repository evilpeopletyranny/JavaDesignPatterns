package oop.bean;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Java Bean всё ещё является POJO но вводит следующие правила:
 * • Свойства имеют модификатор доступа private, а взаимодействия с ними осуществляется через геттеры и сеттеры.
 * • Имена геттеров и сеттеров подчиняются следующему правилу:
 * get + <Имя_поля>, set + <Имя_поля> (is + <Имя_поля> для типа bool),
 * где имя поля начинается с заглавной буквы следуя camelCase.
 * • Содержит конструктор по умолчанию – без параметров. Объект может быть создан без передачи аргументов,
 * например для сериализации.
 * • Реализует интерфейс Serializable.
 * <p>
 * Пример Bean класса.
 */
public class EmployeeBean implements Serializable {
    @Serial
    private static final long serialVersionUID = -3760445487636086034L;

    private String firstName;

    private String lastName;

    private LocalDate startDate;

    /**
     * Если присутсвуют дургие консктруторы, то конструктор без параметров необходимо
     * прописать явно.
     */
    public EmployeeBean() {
    }

    /**
     * Констурктор с параметрами.
     *
     * @param firstName имя присваемое работнику
     * @param lastName фамилия присваемачя работнику
     * @param startDate дата начала работы
     */
    public EmployeeBean(String firstName, String lastName, LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.startDate = startDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}