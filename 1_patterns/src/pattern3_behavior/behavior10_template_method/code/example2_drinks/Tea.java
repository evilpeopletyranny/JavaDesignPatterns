package pattern3_behavior.behavior10_template_method.code.example2_drinks;

// Подкласс для приготовления чая
class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Заваривание чая");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавление лимона");
    }
}
