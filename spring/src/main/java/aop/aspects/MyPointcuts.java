package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

//Еслинам необходим жесктий порядок в вызове аспектов, то их
//необходимо разделить на классы и потом задать им порядок
public class MyPointcuts {
    //Используем pointcut сразу на 2 аспект класса
    @Pointcut("execution(* abc*(..))")
    public void allAddMethods(){}
}
