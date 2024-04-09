package di.xml.bean;

import java.util.Objects;

public class ExampleBean implements IExampleBean {
    private String text;
    private Double number;

    public ExampleBean() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    @Override
    public String getDescription() {
        return "This is ExampleBean";
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "text='" + text + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExampleBean that = (ExampleBean) o;
        return Objects.equals(text, that.text)
                && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, number);
    }
}
