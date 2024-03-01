package introduction.exceptions.own;

public class Caught {
    /**
     * Ловим исключение
     */
    public static void main(String[] args) {
        try {
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
        } catch (IncorrectAgeOfStudentException e) {
            System.err.println(e.getMessage());
        }
    }
}
