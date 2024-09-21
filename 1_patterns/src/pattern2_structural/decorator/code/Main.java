package pattern2_structural.decorator.code;

public class Main {
    public static void main(String[] args) {
        System.out.println("Пицца Пепперони: ");
        Pizza pepperoniPizza = new PepperoniPizza();
        System.out.println(pepperoniPizza.getDescription());
        System.out.println(pepperoniPizza.getCost());

        System.out.println("------------------------");

        System.out.println("Пепперони с сыром: ");
        pepperoniPizza = new CheesePizzaDecorator(pepperoniPizza);
        System.out.println(pepperoniPizza.getDescription());
        System.out.println(pepperoniPizza.getCost());

        System.out.println("------------------------");

        //Обратите внимание, что из-за общего интерфейса мы можем вложить
        //декоратор в декоратор
        System.out.println("Из пепперони с сыром вытащили сыр: ");
        pepperoniPizza = new NonCheeseDecorator(pepperoniPizza);
        System.out.println(pepperoniPizza.getDescription());
        System.out.println(pepperoniPizza.getCost());
    }
}
