package pattern2_structural.decorator.code;

/**
 * Конкретная пицца, над которой мы будем издеваться
 * декораторами.
 */
public class PepperoniPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Pepperoni, Pepper, mozzarella";
    }

    @Override
    public Double getCost() {
        return 10.0;
    }
}
