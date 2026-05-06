package tui;
import java.util.Scanner;
import controller.*;
import model.*;

/**
 * Book menu
 * @author Anita Lykke Clemmensen
 * @version 0.1
 */
public class BookMenu {
    //Instance variables
    BookController bookCtrl;
    
    public BookMenu() {
        //Initialize instance variables
        bookCtrl = new BookController();
    }

    public void start() {
        bookMenu();
    }

    private void bookMenu() {
        boolean running = true;
        while (running) {
            int choice = writeBookMenu();
            switch (choice) {
                case 1:
                  createBook();
                  break;
                case 2:
                    createBookCopy();
                    break;
                case 0:
                  running = false;
                  break;
                default:
                  System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                  break;
            }
        }
    }
    
    private int writeBookMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Bog menu ******");
        System.out.println(" (1) Opret bog");
        System.out.println(" (2) Opret bogkopi");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
    
        private void createBook() {
        Scanner keyboard = new Scanner(System.in);
        String inTitle;
        String inAuthor;
        System.out.print("\n Bogtitel: ");
        inTitle = keyboard.nextLine();
        System.out.print("\n Forfatter: ");
        inAuthor = keyboard.nextLine();
        Book aBook = bookCtrl.createBook(inTitle, inAuthor);
        writeBook(aBook);
    }
    
    private void createBookCopy() {
        Scanner keyboard = new Scanner(System.in);
        String inTitle;
        int inNumber;
        System.out.print("\n Søg bog på bogtitel: ");
        inTitle = keyboard.nextLine();
        System.out.print("\n Nr på kopi: ");
        inNumber = keyboard.nextInt();
        BookCopy aBookCopy = bookCtrl.createBookCopy(inTitle, inNumber);
        if (aBookCopy != null) {
            writeBookCopy(inTitle, aBookCopy);
        } else {
            System.out.println("\n Kopi blev IKKE oprettet ");
        }
    }
    
    private void writeBook(Book inBook) {
        String bookText = "Book, title = " + inBook.getTitle();
        bookText += " - author= " + inBook.getAuthor();
        System.out.println("\n" + bookText);
    }
    
    private void writeBookCopy(String inTitle, BookCopy inBookCopy) {
        String bookCopyText = "Book, title = " + inTitle;
        bookCopyText += " - copy number = " + inBookCopy.getCopyNumber();
        System.out.println("\n" + bookCopyText);        
    }

}
