package di.xml;

import di.xml.bean.AnotherBean;
import di.xml.bean.DifficultBean;
import di.xml.bean.ExampleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DiXMLMain {
    public static void main(String[] args) {
        //Считавание XML-файла инициализации бинов (resources/dependencyInjectionContext.xml)
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dependencyInjectionContext.xml");

        //Получения бина AnotherBean
        var anotherBean = context.getBean(AnotherBean.class);
        System.out.println(anotherBean);
        System.out.println(anotherBean.getDescription());

        //Получения бина ExampleBean
        var exampleBean = context.getBean(ExampleBean.class);
        System.out.println(exampleBean);
        System.out.println(exampleBean.getDescription());

        //Получени бина DifficultBean, внутрь которого внедряется бин,
        //id которого передается в качестве параметра конструктора в XML-файле.
        var difficultBean = context.getBean(DifficultBean.class);
        System.out.println(difficultBean);
        System.out.println(difficultBean.getExampleBean().getDescription());
    }
}