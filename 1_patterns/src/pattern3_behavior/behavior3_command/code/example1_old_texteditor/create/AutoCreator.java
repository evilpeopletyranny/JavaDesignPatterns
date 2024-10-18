package pattern3_behavior.behavior3_command.code.example1_old_texteditor.create;

/**
 * Создатель автомобилей.
 * А-ля фабричный метод.
 */
public class AutoCreator {
    /**
     * Фабринчый создания автомобиля через параметры.
     */
    Auto createAuto(String model, String brand, Long price, Long kilometre) {
        return new Auto(model, brand, price, kilometre);
    }

    /**
     * Перегруженный фабринчый метод создания автомобиля через команду.
     */
    Auto createAuto(AutoCreateCommand command) {
        return createAuto(
                command.getModel(),
                command.getBrand(),
                command.getPrice(),
                command.getKilometre());
    }
}
