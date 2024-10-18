package pattern3_behavior.behavior3_command.code.example1_old_texteditor.create;

/**
 * Команда для создания автомобиля.
 * Особый прекрасный вид команд - команды, которые по сути просто инкапсулируют
 * в себе данные, которые будут куда-то передаваться.
 */
public class AutoCreateCommand {
    private final String model;
    private final String brand;
    private final Long price;
    private final Long kilometre;

    public AutoCreateCommand(String model, String brand, Long price, Long kilometre) {
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.kilometre = kilometre;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public Long getPrice() {
        return price;
    }

    public Long getKilometre() {
        return kilometre;
    }
}
