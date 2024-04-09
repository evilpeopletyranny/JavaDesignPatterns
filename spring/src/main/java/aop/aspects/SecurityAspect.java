package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class SecurityAspect {
    @Before("AOP.aspects.MyPointcuts.allAddMethods()")
    public void beforeADDSecurityAdvice() {
        System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги/журнала");
        System.out.println("-----------------------------------------");
    }
}
