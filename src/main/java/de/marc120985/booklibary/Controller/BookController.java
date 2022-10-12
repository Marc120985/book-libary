package de.marc120985.booklibary.Controller;

import de.marc120985.booklibary.Service.BookService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
}
