package postconstr_predestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("dogBean")
@Scope("prototype")
public class Dog implements Pet {
//    private String name;

    public Dog() {
        System.out.println("Dog bean is created");
    }

    @Override
    public void say(){
        System.out.println("Bow-Wow!");
    }

    //Для аннотаций @PostConstruct и @PreDestroy необходимо добавить
    //maven зависимости javax.annotation-api
    //Данные анотации нужны вместо прописывания init и destroy в xml файле
    @PostConstruct
    private void init() {
        System.out.println("Class dog: init method");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Class dog: destroy method");
    }
}
