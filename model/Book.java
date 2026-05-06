package model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String title;
    private String author;
    private List<BookCopy> bookCopies;

    // <<create>>
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookCopies = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void addBookCopy(BookCopy aBookCopy) {
        bookCopies.add(aBookCopy);
    }
    
}