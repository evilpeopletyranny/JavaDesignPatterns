package di.xml.bean;

import java.util.Objects;

public class AnotherBean implements IExampleBean {
    private String text;
    private Double number;

    public AnotherBean(String text, Double number) {
        this.text = text;
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public Double getNumber() {
        return number;
    }

    @Override
    public String getDescription() {
        return "This is AnotherBean";
    }

    @Override
    public String toString() {
        return "AnotherBean{" +
                "text='" + text + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnotherBean that = (AnotherBean) o;
        return Objects.equals(text, that.text) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, number);
    }
}
