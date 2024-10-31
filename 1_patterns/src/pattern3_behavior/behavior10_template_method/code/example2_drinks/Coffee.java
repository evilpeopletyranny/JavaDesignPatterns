package pattern3_behavior.behavior10_template_method.code.example2_drinks;

// Подкласс для приготовления кофе
class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Заваривание кофе");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавление сахара и молока");
    }
}
