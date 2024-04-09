package postconstr_predestroy;

import org.springframework.stereotype.Component;

//Анотация component пишется для класса, который мы хотим получать из бинов.
//Если не указывать бин, то по умолчанию это будет имя класса, где заглавная буква
//заменена на прописную.
@Component("catBean")
public class Cat implements Pet {

    public Cat() {
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-Meow!");
    }
}
