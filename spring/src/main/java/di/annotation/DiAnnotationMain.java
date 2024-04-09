package di.annotation;

import di.annotation.bean.AMDProcessor;
import di.annotation.bean.Computer;
import di.annotation.bean.IntelProcessor;
import di.annotation.bean.JavaScanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DiAnnotationMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaScanConfig.class);

        var amdProcessor = context.getBean(AMDProcessor.class);
        System.out.println(amdProcessor);
        System.out.println(amdProcessor.getManufacturer());

        System.out.println("----------------------------------------");

        var intelProcessor = context.getBean(IntelProcessor.class);
        System.out.println(intelProcessor);
        System.out.println(intelProcessor.getManufacturer());

        System.out.println("----------------------------------------");

        var computer = context.getBean(Computer.class);
        System.out.println(computer);
        System.out.println(computer.getProcessor().getManufacturer());
    }
}
