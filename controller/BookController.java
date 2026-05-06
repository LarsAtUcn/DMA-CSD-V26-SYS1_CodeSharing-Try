package controller;

import model.*;

public class BookController {

    private BookContainer bookCon;

    // <<create>>
    public BookController() {
        this.bookCon = BookContainer.getInstance();
    }

    public Book createBook(String title, String author) {
        Book book = new Book(title, author);
        bookCon.addBook(book);
        return book;
    }

    public BookCopy createBookCopy(String title, int copyNumber) {
        Book book = bookCon.findBookByTitle(title);
        if (book == null) {
            return null; // no book found
        }
        

        // Let Book handle creation and storage of copies
        BookCopy bookCopy = new BookCopy(copyNumber);
        book.addBookCopy(bookCopy);
        // Return the created copy (assuming BookCopy is identifiable by bookNumber)
        // This requires Book to expose its copies or return the created one.
        // Simplest approach: create and return explicitly:

        
        return bookCopy;
    }
}