package ioc.mix;

import ioc.mix.bean.ComponentByConstructor;
import ioc.mix.bean.ComponentBySetters;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MixContextMain {
    public static void main(String[] args) {
        //Чтение контекста из xml файла с автосканированием патеков
        //В файле указаны пакеты для сканирования
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("autoScanContext.xml");

        //Чтение компонента, инициализирующегося через конструктор
        var componentByConstructor = context.getBean("componentByConstructor", ComponentByConstructor.class);
        System.out.println(componentByConstructor);

        //Чтение компонента, инициализирующегося через сеттеры
        var componentBySetters = context.getBean("bySetters", ComponentBySetters.class);
        System.out.println(componentBySetters);

        //Контекст необходимо закрывать.
        //Приложение не сработает пока не будет закрыт контекст.
        context.close();
    }
}
