package LR2.exceptions.own;

/**
 * Синтетический пример использования исключений при проверке параметров.
 *
 */
public class Student {
    private String name;

    private String group;

    private Integer age;

    /**
     * Метод проверки возраста студента.
     * Если внутри функции исключение не обрабатывается блоками try-catch, то оно передается выше
     * и указывается в "сигнатуре" функции.
     * (Указание исключения в сигнатуре характерно только для Java)
     *
     * @param age возвраст стдуента для проверки
     * @return возраст студента
     * @throws IncorrectAgeOfStudentException выбрасывается если студент слишком молод
     */
    private Integer checkAge(Integer age) throws IncorrectAgeOfStudentException {
        if (age < 16) throw new IncorrectAgeOfStudentException("Слишком маленький возраст для студента!");
        return age;
    }

    /**
     * Обратите внимание на throws IncorrectAgeOfStudentException
     * @throws IncorrectAgeOfStudentException
     */
    public Student(String name, String group, Integer age) throws IncorrectAgeOfStudentException {
        this.name = name;
        this.group = group;
        this.age = checkAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Integer getAge() {
        return age;
    }

    /**
     * Обратите внимание на throws IncorrectAgeOfStudentException
     * @throws IncorrectAgeOfStudentException
     */
    public void setAge(Integer age) throws IncorrectAgeOfStudentException {
        this.age = checkAge(age);
    }
}
