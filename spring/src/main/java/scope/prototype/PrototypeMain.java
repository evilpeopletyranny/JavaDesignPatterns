package scope.prototype;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScanConfig.class);

        var firstService = context.getBean(PrototypeService.class);
        var secondService = context.getBean(PrototypeService.class);

        System.out.println(firstService);
        System.out.println(secondService);

        System.out.println(firstService == secondService);
        System.out.println(firstService.equals(secondService));

        secondService.setPort("5432");

        System.out.println(firstService);
        System.out.println(secondService);

        System.out.println(firstService == secondService);
        System.out.println(firstService.equals(secondService));
    }
}
