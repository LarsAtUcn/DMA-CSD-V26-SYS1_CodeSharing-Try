package model;

import java.util.ArrayList;
import java.util.List;

public class BookContainer {

    private List<Book> books;

    // Singleton instance
    private static BookContainer instance;

    // <<create>>
    private BookContainer() {
        books = new ArrayList<>();
    }

    // getInstance()
    public static BookContainer getInstance() {
        if (instance == null) {
            instance = new BookContainer();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookByTitle(String title) {
        for (Book aBook : books) {
            if (aBook.getTitle().equals(title)) {
                return aBook;
            }
        }
        return null; // not found
    }
}