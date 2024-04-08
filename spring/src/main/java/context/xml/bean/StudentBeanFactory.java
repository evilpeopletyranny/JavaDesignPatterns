package context.xml.bean;

/**
 * Фабрика студентов
 */
public class StudentBeanFactory {
    /**
     * Фабринчый метод создания студента
     */
    public Student createStudent(String name, Integer age, String group, String creationType) {
        return new Student(name, age, group, creationType);
    }
}
