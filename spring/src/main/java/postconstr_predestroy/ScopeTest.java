package postconstr_predestroy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScopeTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AnnotationScanConfig.class);

        Dog myDog = context.getBean("dogBean", Dog.class);
        Dog yourDog = context.getBean("dogBean", Dog.class);

        System.out.println("Переменные ссылаются на один объект? " + (myDog.equals(yourDog)));
        System.out.println(myDog);
        System.out.println(yourDog);

        context.close();
    }
}
