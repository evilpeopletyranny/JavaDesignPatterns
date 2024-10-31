package pattern3_behavior.behavior10_template_method.code.example2_drinks;

// Абстрактный класс с шаблонным методом
abstract class Beverage {

    // Шаблонный метод
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Общие шаги
    private void boilWater() {
        System.out.println("Кипячение воды");
    }

    private void pourInCup() {
        System.out.println("Наливание в чашку");
    }

    // Шаги, которые должны быть реализованы в подклассах
    protected abstract void brew();
    protected abstract void addCondiments();
}
