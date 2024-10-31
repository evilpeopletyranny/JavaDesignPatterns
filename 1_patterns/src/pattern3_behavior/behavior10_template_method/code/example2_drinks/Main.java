package pattern3_behavior.behavior10_template_method.code.example2_drinks;

public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        System.out.println("Приготовление чая:");
        tea.prepareRecipe();

        System.out.println("\nПриготовление кофе:");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
