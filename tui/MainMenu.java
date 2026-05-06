package tui;
import java.util.Scanner;
import model.*;

/**
 * MainMenu for Code sharing exercise
 * @author Anita Lykke Clemmensen
 * @version 0.1
 */
public class MainMenu {
    private BookMenu bookMenu;

    public MainMenu() {
        bookMenu = new BookMenu();
    }
    
    public void start() {
        mainMenu();
    }
    
    private void mainMenu() {
        boolean running = true;
        while (running) {
            int choice = writeMainMenu();
            switch (choice) {
                case 1:
                  bookMenu.start();
                  break;
                case 9:
                  createTestData();
                  break;
                case 0:
                  System.out.println("Tak for denne gang.");
                  running = false;
                  break;
                default:
                  System.out.println("Der er sket en uforklarlig fejl, choice = "+choice);
                  break;
            }
        }
    }

    private int writeMainMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Hovedmenu ******");
        System.out.println(" (1) Bog menu");
        System.out.println(" (9) Generer testdata");// will generate test data
        System.out.println(" (0) Afslut programmet");
        System.out.print("\n Vælg:");
        
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        int choice = keyboard.nextInt();
        return choice;
    }
   
    private void createTestData() {
        //Only use classes from model layer
        //getInstance
        BookContainer books = BookContainer.getInstance();
        //create some books
        Book book1 = new Book("BlueJ", "Hansen");
        Book book2 = new Book("UML", "Nielsen");
        Book book3 = new Book("UP", "Olsen");
        Book book4 = new Book("SWOT", "Jensen");
            //add to book container
        books.addBook(book1);
        books.addBook(book2);
        books.addBook(book3);
        books.addBook(book4);
        //create some copies
        BookCopy bookCp1 = new BookCopy(101);
        BookCopy bookCp2 = new BookCopy(102);
        BookCopy bookCp3 = new BookCopy(111);
        BookCopy bookCp4 = new BookCopy(131);
        BookCopy bookCp5 = new BookCopy(132);
        BookCopy bookCp6 = new BookCopy(133);
            //add to book
        book1.addBookCopy(bookCp1);
        book1.addBookCopy(bookCp2);
        book3.addBookCopy(bookCp3);
        book4.addBookCopy(bookCp4);
        book4.addBookCopy(bookCp5);
        book4.addBookCopy(bookCp6);
    }

    public static void main(String[] args) {
        MainMenu program = new MainMenu();
        program.start();
    }

}