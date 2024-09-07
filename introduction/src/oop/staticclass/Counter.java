package oop.staticclass;

/**
 * Класс со статической переменной и методом.
 */
public class Counter {
    private static int count;   //объявление статической переменной

    //Статичсекий блок (необязательный)
    //В основном нужен для инициализации статических значений
    //Статический блок выполняется при инициализации класса.
    //Инициализация класса происходит если к нему есть хотя бы одно обращение
    static {
        count = 100;
        System.out.println("Static block:");
        System.out.println("Статический блок выполняется в момент инициализации класса.");
    }

    /**
     * Обращение к статической переменной из констурктора.
     * К статическим переменным можно обращаться из конструктора и других методов
     * класса.
     */
    public Counter() {
        count++;
    }

    /**
     * Статический метод.
     * Однако статические методы имеют доступ только к статическим переменным.
     *
     * @return значение статического поля.
     */
    public static Integer getCount() {
        return count;
    }

    /**
     * Статический метод для увеличени я счетчика.
     */
    public static void increaseCount() {
        count++;
    }
}
