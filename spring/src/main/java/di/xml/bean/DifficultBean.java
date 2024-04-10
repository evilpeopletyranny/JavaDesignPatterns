package di.xml.bean;

import java.util.Objects;

public class DifficultBean {
    private IExampleBean exampleBean;
    private String text;
    private Double number;

    public DifficultBean(IExampleBean exampleBean,
                         String text,
                         Double number) {
        this.exampleBean = exampleBean;
        this.text = text;
        this.number = number;
    }

    public IExampleBean getExampleBean() {
        return exampleBean;
    }

    public void setExampleBean(IExampleBean exampleBean) {
        this.exampleBean = exampleBean;
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
    public String toString() {
        return this.getClass() + "{" +
                "exampleBean=" + exampleBean +
                ", text='" + text + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DifficultBean that = (DifficultBean) o;
        return Objects.equals(exampleBean, that.exampleBean)
                && Objects.equals(text, that.text)
                && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exampleBean,
                text,
                number);
    }
}
