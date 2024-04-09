package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {

    //При использованни данного Advice нам необхродимо самостоятельно вызывать таргет метод в Advice
    //при помощи ProceedingJoinPoint (через него можно так же как и через простой JoinPoint получить
    //сигнатуру метода)
    @Around("execution(public String AOP.UniLibrary.returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");

        Object targetMethodResult;

        //Внутри Advice @Around можно обработать исключение
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        }
        catch (Exception e)
        {
            System.out.println("aroundReturnBookLoggingAdvice: залогированно исключение " + e);
            throw e;
        }

        System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");

        return targetMethodResult;
    }
}
