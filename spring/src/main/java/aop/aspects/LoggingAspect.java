package aop.aspects;

import aop.Person;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Класс аспект должен быть компонентом.
 * <p>
 * Aspect указывает на то что класс является аспектом.
 * Работа Spring с аспектами отличается от обычных компонентов.
 */
@Component
@Aspect
public class LoggingAspect {

    /**
     * Advice, помеченный @Before срабатывает до выполнения основного метода.
     * В аннотации @Before описывается Pointcut.
     * Pointcut - выражение, описывающее где должен быть применен Advice.
     * <p>
     * Название Advice-ов обычно формируется из <advice_type>+<methodName>
     * <p>
     * Spring AOP использует AspectJ Pointcut expression language. Т.е.
     * определённые правила в написании выражений для создания
     * Pointcut.
     * <p>
     * В данном Pointcut-е не указан declaring-type-pattern? поэтому он подойдет под любой
     * метод public void getBook() любого класса.
     * В данном случае он сработает и для UniLibrary.getBook() и SchoolLibrary.getBook()
     * <p>
     * ВАЖНО!!! Название самого Advice не играет никакой роли! Важен его Pointcut!!!
     */
    @Before("execution(public void getBook())")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу.");
    }

    /**
     * Advice, помеченный @AfterReturning выполняется только после нормального
     * окончания метода с основной логикой.
     * <p>
     * ВАЖНО!!! Название самого Advice не играет никакой роли! Важен его Pointcut!!!
     * execution(public void returnBook()) будет работать для обоих библиотек!!!
     * Для разрешения данного конфликта явно укажем declaring-type-pattern? (класс, которому
     * принадлжеит метод)
     */
    @AfterReturning("execution(public void aop.UniLibrary.returnBook())")
    public void afterUniReturnBookAdvice() {
        System.out.println("afterUniReturnBookAdvice: книга возвращена в UniLibrary");
    }

    /**
     * Advice, помеченный @AfterReturning выполняется только после нормального
     * окончания метода с основной логикой.
     * <p>
     * ВАЖНО!!! Название самого Advice не играет никакой роли! Важен его Pointcut!!!
     * execution(public void returnBook()) будет работать для обоих библиотек!!!
     * Для разрешения данного конфликта явно укажем declaring-type-pattern? (класс, которому
     * принадлжеит метод)
     */
    @AfterReturning("execution(public void aop.SchoolLibrary.returnBook())")
    public void afterSchoolReturnBookAdvice() {
        System.out.println("afterSchoolReturnBookAdvice: книга возвращена в SchoolLibrary");
    }

    /**
     * Как не трудно догадаться Advice, помеченый @Around выполняется "вокруг метода",
     * т.е. до и после его отрабаывания.
     * <p>
     * Очень сложный и сильный тип Advice, потому что в нем можно:
     * 1. Произвести какие-либо действия до работы target метода (даже перехватить
     * входные параметры).
     * 2. Произвести какие-либо действия после работы target метода (даже перехватить
     * результаты работы метода).
     * 3. Предпринять какие-либо действия, если из target метода выбрасывается исключение.
     *      исключения также можно перехватывать и обрабатывать.
     */
    @Around("execution(public void giveBookToPerson(String, aop.Person))")
    public Object AroundDiveBookToPersonAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //Действия до выполнения метода!
        //Перехват параметров, переданных в основной метод.
        Object[] args = proceedingJoinPoint.getArgs();

        //Преобразование параметров по нужным типам
        String bookName = object2String(args[0]).orElse("Неизвестный");
        Person person = object2Person(args[1]).orElseThrow();

        System.out.println(person + " пытается получить книгу " + bookName);

        //Запуск работы основного метода и получение его результатов работы
        //Здесь мы также можем что-то изменить в результатах работы метода
        Object targetMethodResult = proceedingJoinPoint.proceed();

        //Действия после выполнения метода!
        System.out.println(person + " получил книгу " + bookName + " без проблем.");

        //К сожелению и параметры и возвращаемый тип перехватывается в виде типа Object
        //из-за чего приходить городить проверки и преобразования...

        //Менять что-то в предаваемых и возвращаемых параметрах не следует ни в коем случае!!!
        //Данные механизмы нужны больше для проверки и логирования результатов.
        //Не портите жизнь ни себе, ни другим :)

        //Возвращаем ранее полученне результаты работы метода
        //Это обязательное действие, иначе результаты потеряются
        //и скорее всего у вас где-то что-то упадет, выкинет exception и тд и тп...
        return targetMethodResult;
    }

    /**
     * Вспомогательный метод приведения объекта к строке
     */
    public Optional<String> object2String(Object obj) {
        if (obj instanceof String) return Optional.of((String) obj);
        return Optional.empty();
    }

    /**
     * Вспомогательный метод приведения объекта к человеку
     */
    public Optional<Person> object2Person(Object obj) {
        if (obj instanceof Person) return Optional.of((Person) obj);
        return Optional.empty();
    }
}
