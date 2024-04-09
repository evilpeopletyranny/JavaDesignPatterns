package aop.aspects;

import aop.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //указываем порядок срабатывания аспекта по отношению к другим классам аспектам
public class LoggingAspect {

    @Before("AOP.aspects.MyPointcuts.allAddMethods()")
    //Через JoinPoint мы можем получить всю информацию о методе, где быть вызван данный Advice
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Сигнатура: " + methodSignature);
        System.out.println("Сигнатура.getMethod: " + methodSignature.getMethod());
        System.out.println("Сигнатура.getReturnType: " + methodSignature.getReturnType());
        System.out.println("Сигнатура.getName: " + methodSignature.getName());

        //отдельно для метода addBook
        if (methodSignature.getName().equals("addBook"))
        {
            Object[] args = joinPoint.getArgs();
            for (Object obj: args) {
                if (obj instanceof Book)
                {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() + ", author - "
                            + myBook.getAuthor() + ", год издания - " + myBook.getYearsOfPublication());
                }
                else if (obj instanceof String)
                {
                    System.out.println("Книгу в библиотеку добавил: " + obj);
                }
            }
        }

        System.out.println("-----------------------------------------");
    }
}
