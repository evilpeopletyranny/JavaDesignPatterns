package context.mix;

import context.mix.bean.ComponentByConstructor;
import context.mix.bean.ComponentBySetters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MixContextMain {
    public static void main(String[] args) {
        //Чтение контекста из xml файла с автосканированием патеков
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autoScanContext.xml");

        //Чтение компонента, инициализирующегося через конструктор
        var componentByConstructor = context.getBean("componentByConstructor", ComponentByConstructor.class);
        System.out.println(componentByConstructor);

        //Чтение компонента, инициализирующегося через сеттеры
        var componentBySetters = context.getBean("bySetters", ComponentBySetters.class);
        System.out.println(componentBySetters);

        context.close();
    }
}
