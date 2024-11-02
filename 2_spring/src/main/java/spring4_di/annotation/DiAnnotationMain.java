package spring4_di.annotation;

import spring4_di.annotation.bean.AMDProcessor;
import spring4_di.annotation.bean.Computer;
import spring4_di.annotation.bean.IntelProcessor;
import spring4_di.annotation.bean.JavaScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiAnnotationMain {
    public static void main(String[] args) {
        //Считавание контекста с конфигурационного класса
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaScanConfig.class);

        //Получение бина AMDProcessor
        var amdProcessor = context.getBean(AMDProcessor.class);
        System.out.println(amdProcessor);
        System.out.println(amdProcessor.getManufacturer());

        System.out.println("----------------------------------------");

        //Получение бина IntelProcessor
        var intelProcessor = context.getBean(IntelProcessor.class);
        System.out.println(intelProcessor);
        System.out.println(intelProcessor.getManufacturer());

        System.out.println("----------------------------------------");

        //Получени бина Computer, внутрь которого внедряется бин,
        //какой именно бин внедряется указано при помощи аннотации @Qualifier
        var computer = context.getBean(Computer.class);
        System.out.println(computer);
        System.out.println(computer.getProcessor().getManufacturer());
    }
}
