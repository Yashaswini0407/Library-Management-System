package service;

import model.Book;
import model.Patron;
import model.Loan;

import java.util.*;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Patron> patrons = new HashMap<>();
    private List<Loan> loans = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(String isbn) {
        books.remove(isbn);
        System.out.println("Book removed: " + isbn);
    }

    public void registerPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
        System.out.println("Patron registered: " + patron.getName());
    }

    public void checkoutBook(String isbn, String patronId) {

        Book book = books.get(isbn);
        Patron patron = patrons.get(patronId);

        if (book != null && patron != null && book.isAvailable()) {

            Loan loan = new Loan(book, patron);
            loans.add(loan);

            book.setAvailable(false);
            patron.borrowBook(book);

            System.out.println("Book checked out successfully");
        } else {
            System.out.println("Book not available");
        }
    }

    public void returnBook(String isbn, String patronId) {

        Book book = books.get(isbn);
        Patron patron = patrons.get(patronId);

        if (book != null && patron != null) {

            book.setAvailable(true);
            patron.returnBook(book);

            System.out.println("Book returned successfully");
        }
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }
}
