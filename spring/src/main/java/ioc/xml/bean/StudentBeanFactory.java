package ioc.xml.bean;

/**
 * Фабрика студентов
 */
public class StudentBeanFactory {
    /**
     * Фабринчый метод создания студента
     */
    public static Student createStudent(String name, Integer age, String group, String creationType) {
        return new Student(name, age, group, creationType);
    }
}
