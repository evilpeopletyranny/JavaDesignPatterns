package ioc.code.beans;

public class ComponentA {
    private String name;

    public ComponentA(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass() + "{" +
                "name='" + name + '\'' +
                '}';
    }
}
