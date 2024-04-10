package di.annotation.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

//Бин, реализующий интерфейс
@Component
public class AMDProcessor implements IProcessor {
    private Long frequency;
    private String architecture;

    public AMDProcessor(@Value("11000") Long frequency,
                        @Value("Zen") String architecture) {
        this.frequency = frequency;
        this.architecture = architecture;
    }

    @Override
    public String getManufacturer() {
        return "Made by AMD";
    }

    public Long getFrequency() {
        return frequency;
    }

    public String getArchitecture() {
        return architecture;
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
        AMDProcessor that = (AMDProcessor) o;
        return Objects.equals(frequency, that.frequency)
                && Objects.equals(architecture, that.architecture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frequency,
                architecture);
    }
}
