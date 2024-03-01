package introduction.exceptions.own;

/**
 * Пример реализации собственного исключения
 */
public class IncorrectAgeOfStudentException extends Exception {
    /**
     * Exception имеет конструктор в котором можно передать сообщение.
     * Для вызова родительского конструктора используется super(<параметры для родительского конструктора>)
     * @param message
     */
    public IncorrectAgeOfStudentException (String message) { super(message); }
}
