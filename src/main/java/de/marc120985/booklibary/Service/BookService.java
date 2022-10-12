package de.marc120985.booklibary.Service;

import de.marc120985.booklibary.Model.Book;
import de.marc120985.booklibary.Model.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public Book getBookbyIsbn(String isbn) {
        return bookRepo.getBookByIsbn(isbn);
    }

    public Book addBook(Book book) {
        return bookRepo.addBook(book);
    }

    public Book removeBook(String isbn) {
        return bookRepo.removeBook(isbn);
    }
}
