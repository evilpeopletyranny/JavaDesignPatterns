package di.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

//Бин, реализующий интерфейс
@Component
public class IntelProcessor implements IProcessor {
    private Long frequency;
    private String architecture;

    public IntelProcessor() {
    }

    public Long getFrequency() {
        return frequency;
    }

    public void setFrequency(@Value("10000") Long frequency) {
        this.frequency = frequency;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(@Value("Intel Core") String architecture) {
        this.architecture = architecture;
    }

    @Override
    public String getManufacturer() {
        return "Made by Intel";
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "frequency=" + frequency +
                ", architecture='" + architecture + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntelProcessor that = (IntelProcessor) o;
        return Objects.equals(frequency, that.frequency)
                && Objects.equals(architecture, that.architecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency, architecture);
    }
}
