package de.marc120985.booklibary.Controller;

import de.marc120985.booklibary.Model.Book;
import de.marc120985.booklibary.Service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping(path = "{isbn}")
        public Book getBookbyIsbn(@PathVariable String isbn){
            return bookService.getBookbyIsbn(isbn);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @DeleteMapping({"{isbn}"})
    public Book removeBook(@PathVariable String isbn){
       return bookService.removeBook(isbn);
    }


}
