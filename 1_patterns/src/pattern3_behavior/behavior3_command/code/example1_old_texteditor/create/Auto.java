package pattern3_behavior.behavior3_command.code.example1_old_texteditor.create;

/**
 * Класс, который мы будем создавать.
 */
public class Auto {
    private String model;
    private String brand;
    private Long price;
    private Long kilometre;

    public Auto(String name, String brand, Long price, Long kilometreage) {
        this.model = name;
        this.brand = brand;
        this.price = price;
        this.kilometre = kilometreage;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getKilometre() {
        return kilometre;
    }

    public void setKilometre(Long kilometre) {
        this.kilometre = kilometre;
    }
}
