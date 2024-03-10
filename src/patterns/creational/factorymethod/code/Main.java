package patterns.creational.factorymethod.code;

public class Main {

    /**
     * Клиентский код работает через общий интерфейс.
     * Всё зависит от подсонутой под интерфейс конкретной реализации.
     */
    public static void main(String[] args) {
        Restaurant mammaMia = new Pizzeria();
        mammaMia.order();
        Restaurant istanbul = new BurgerHouse();
        istanbul.order();
    }
}
