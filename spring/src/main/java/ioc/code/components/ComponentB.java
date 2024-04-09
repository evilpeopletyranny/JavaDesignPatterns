package ioc.code.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ComponentB {
    private String name;

    public ComponentB(@Value("Component annotation") String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}
