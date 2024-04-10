package di.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Computer {

    //Внедрение зависимости через поле
    //Указан тип интерфейса, конкретный бин определяется через @Qualifier
    @Autowired
    @Qualifier("intelProcessor")
    private IProcessor processor;

    public IProcessor getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "processor=" + processor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(processor, computer.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(processor);
    }
}
