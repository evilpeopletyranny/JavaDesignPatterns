package context.xml;

import context.xml.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlContextMain {
    public static void main(String[] args) {
        //Получение контекста из XML-файла
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Студент, который инициализировался через конструктор
        var firstStudent = context.getBean("firstStudent", Student.class);
        System.out.println(firstStudent);

        //Студент, инициализированный через сеттеры
        var secondStudent = context.getBean("secondStudent", Student.class);
        System.out.println(secondStudent);

        //Студент, инициализированный через внутренний (принадлжеит классу Student) фабричный метод
        var thirdStudent = context.getBean("thirdStudent", Student.class);
        System.out.println(thirdStudent);

        //Студент, инициализированный через внешний фабричный метод
        var fourthStudent = context.getBean("fourthStudent", Student.class);
        System.out.println(fourthStudent);

        //Закрытие контекста
        context.close();
    }
}
