package aop;

import org.springframework.stereotype.Component;

@Component("uniLibraryBean")
public class UniLibrary {

    //Пусть у нас его сквозная логика связанная с этим методом, но
    //к нему ничего писать не надо
    public void getBook() {
        System.out.println("UniLibrary: Мы берем книгу");
        System.out.println("-----------------------------------------");
    }

    public String returnBook() {
        //Для проверки работы с исключением
        int a = 10/0;
        System.out.println("UniLibrary: Мы возвращаем книгу");
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println("UniLibrary: Мы берем журнал");
        System.out.println("-----------------------------------------");
    }

    public void returnMagazine() {
        System.out.println("UniLibrary: Мы возвращаем журнал");
        System.out.println("-----------------------------------------");
    }

    public void addBook(String personName, Book book) {
        System.out.println("UniLibrary: Мы добавляем книгу");
        System.out.println("-----------------------------------------");
    }

    public void addMagazine() {
        System.out.println("UniLibrary: Мы добавляем журнал");
        System.out.println("-----------------------------------------");
    }
}
