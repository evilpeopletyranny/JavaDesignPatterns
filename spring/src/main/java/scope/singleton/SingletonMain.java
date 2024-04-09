package scope.singleton;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("singletonContext.xml");

        var firstPerson = context.getBean(SingletonPerson.class);
        System.out.println(firstPerson);

        var secondPerson = context.getBean(SingletonPerson.class);
        System.out.println(secondPerson);

        assert firstPerson == secondPerson;
        System.out.println(firstPerson == secondPerson);
    }
}
