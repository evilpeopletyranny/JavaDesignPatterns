package aop;

import org.springframework.stereotype.Component;

/**
 * Класс университетской библиотеки - обычный компонент.
 * ВАЖНО!!! Аспекты работают только на бинах!
 */
@Component
public class UniLibrary implements ILibrary {
    /**
     * Простой метод взяти книги, который не содержит сложной и постронней логики
     */
    @Override
    public void getBook() {
        System.out.println("Мы берем книгу из UniLibrary");
    }

    @Override
    public void returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary");
    }

    /**
     * @param bookName имя книги
     * @param person   человек, которому выдается книга
     */
    @Override
    public void giveBookToPerson(String bookName, Person person) {
        System.out.println(person.name() + " получил книгу " + bookName + " в UniLibrary");
    }
}
