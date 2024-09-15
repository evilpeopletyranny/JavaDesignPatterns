package ioc.code.beanfactory;

/**
 * Класс, бины которого будут создаваться при помощи фабричного метода, определенного
 * в ScanBeanConfig.
 * В данном случае для класс не требуется указывать ни аннотаций ни каких-либо других конструкций.
 */
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
