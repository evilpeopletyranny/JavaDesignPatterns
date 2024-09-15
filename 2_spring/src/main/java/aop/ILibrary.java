package aop;

/**
 * Библиотека
 */
public interface ILibrary {

    /**
     * Получени книги
     */
    void getBook();

    /**
     * Возвращение книги
     */
    void returnBook();

    /**
     * Выдать книгу какому-то человеку
     *
     * @param bookName имя книги
     * @param person   человек, которому выдается книга
     */
    void giveBookToPerson(String bookName, Person person);
}
