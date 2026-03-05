package service;

import model.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchService {

    public List<Book> searchByTitle(Collection<Book> books, String title) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }

        return result;
    }

    public List<Book> searchByAuthor(Collection<Book> books, String author) {

        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }

        return result;
    }
}
