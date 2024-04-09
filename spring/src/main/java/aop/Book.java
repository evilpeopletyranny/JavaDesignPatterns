package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("bookBean")
public class Book {
    @Value("War & Piece")
    private String name;

    @Value("Л.Н. Толстой")
    private String author;

    @Value("1863")
    private int yearsOfPublication;

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearsOfPublication() {
        return yearsOfPublication;
    }
}
