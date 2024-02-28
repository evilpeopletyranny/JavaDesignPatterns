package LR2.exceptions.own;

public class NonCatch {
    /**
     * Не ловим исключение и оно пробрасывается к JVM
     * (Плохая практика)
     */
    public static void main(String[] args) throws IncorrectAgeOfStudentException {
        Student vasily = new Student(
                "Василий",
                "IVT1",
                15
        );

        Student ivan = new Student(
                "Иван",
                "IVT9",
                25
        );
    }
}
