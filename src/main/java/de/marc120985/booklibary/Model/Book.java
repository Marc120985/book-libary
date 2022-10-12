package de.marc120985.booklibary.Model;

public record Book(
        String isbn,
        String title,
        String author,
        BookType type
        ) {

}
