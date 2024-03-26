package patterns.creational.factorymethod.code;

public class Main {

    /**
     * Клиентский код работает через общий интерфейс.
     * Всё зависит от подсонутой под интерфейс конкретной реализации.
     */
    public static void main(String[] args) {
        Restaurant mammaMia = new Pizzeria();
        System.out.println(mammaMia.prepareMeal());
        Restaurant burgerQueen = new BurgerHouse();
        System.out.println(burgerQueen.prepareMeal());
    }
}
