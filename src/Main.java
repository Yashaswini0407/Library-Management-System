import model.Book;
import model.Patron;
import service.LibraryService;
import service.SearchService;

public class Main {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();
        SearchService searchService = new SearchService();

        Book book1 = new Book("Java Basics", "James", "111", 2020);
        Book book2 = new Book("Clean Code", "Robert Martin", "222", 2008);

        Patron patron = new Patron("1", "Alice");

        library.addBook(book1);
        library.addBook(book2);

        library.registerPatron(patron);

        library.checkoutBook("111", "1");

        library.returnBook("111", "1");

        System.out.println("Search Result:");

        searchService.searchByTitle(library.getAllBooks(), "Java Basics")
                .forEach(book -> System.out.println(book.getTitle()));
    }
}
