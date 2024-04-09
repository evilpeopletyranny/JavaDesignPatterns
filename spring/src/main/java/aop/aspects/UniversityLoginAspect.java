package aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoginAspect {

    //Данный тип Advice срабатывает в любом случае при заверешении работы метода
    //хоть при нормальной работые хоть при исключении
    //При данном типе Advice невозможно получить доступ к возвращаемому результату или исключению
    @After("execution(* getStudents(..))")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: логиурем номральнео окончание работы метода или " +
                "выброс исключения");
    }
}
