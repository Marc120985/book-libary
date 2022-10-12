package de.marc120985.booklibary.Service;

import de.marc120985.booklibary.Model.Book;
import de.marc120985.booklibary.Model.BookRepo;
import de.marc120985.booklibary.Model.BookType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {
    BookRepo bookRepo = mock(BookRepo.class);
    BookService bookService = new BookService(bookRepo);

    @Test
    void getBooksfromBooklistTest(){
        //given
        List<Book> testList = new ArrayList<>(List.of(
                new Book("1234", "Mein Tagebuch", "Marc", BookType.HARDCOVER)
        ));
        when(bookRepo.getAllBooks()).thenReturn(testList);
        //when
        List<Book> actual = bookService.getAllBooks();
        //then
        List<Book> expected = testList;
        assertEquals(expected, actual);
    }

    @Test
    void getBookByIsbnTest(){
        //given
        String isbn = "1234";
        Book testBook = new Book("8973", "testbuch", "testautor", BookType.HARDCOVER);
        when(bookRepo.getBookByIsbn(isbn)).thenReturn(testBook);
        //when
        Book actual = bookService.getBookbyIsbn(isbn);
        //then
        Book expected = testBook;
        assertEquals(expected, actual);

    }

    @Test
    void addBookTest(){
        //given
        Book newTestBook = new Book("9999", "Mir", "mich", BookType.HARDCOVER);
        when(bookRepo.addBook(newTestBook)).thenReturn(newTestBook);
        //when
        Book actual = bookService.addBook(newTestBook);
        //then
        Book expected = newTestBook;
        assertEquals(expected,actual);
    }

    @Test
    void deleteBookTest(){
        //given
        String isbn = "1234";
        Book testbook = new Book("1234", "Will ich nicht mehr", "testauthor", BookType.HARDCOVER);
        when(bookRepo.removeBook(isbn)).thenReturn(testbook);
        //when
        Book actual = bookService.removeBook(isbn);
        //then
        Book expected = testbook;
        assertEquals(expected,actual);
    }

}