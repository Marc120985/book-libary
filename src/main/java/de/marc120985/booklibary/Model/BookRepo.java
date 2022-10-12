package de.marc120985.booklibary.Model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class BookRepo {
   private final List<Book> bookList = new ArrayList<>(List.of(
           new Book("1234", "Tagebuch", "Marc", BookType.SOFTCOVER),
           new Book("4567", "Fantasy World", "James", BookType.AUDIOBOOK)
   ));

   public List<Book> getAllBooks(){
       return bookList;
   }


    public Book getBookByIsbn(String isbn) {
       for(Book book : bookList){
           if(book.isbn().equals(isbn)){
               return book;
           }
       }
        throw new NoSuchElementException("Diese ISBN wurde nicht gefunden");
    }

    public Book addBook(Book book) {
       bookList.add(book);
       return book;
    }

    public Book removeBook(String isbn) {
       for(Book book : bookList){
           if(book.isbn().equals(isbn)){
               bookList.remove(book);
           }
       }
        throw new NoSuchElementException("Kein Buch mit dieser ISBN zum löschen gefunden");
    }
}
