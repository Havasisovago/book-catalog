package hu.nye.progkor.bookcatalog.service;

import java.util.List;
import java.util.Optional;

import hu.nye.progkor.bookcatalog.data.model.Book;

/**
 * A service for managing books in the book catalog.
 */
public interface BookService {

    /**
     * Creates a new book.
     *
     * @param book the book to create
     * @return the created book
     */
    Book createBook(Book book);

    /**
     * Retrieves a book by its id.
     *
     * @param id the id of the book to retrieve
     * @return the retrieved book or empty optional if it was not found
     */
    Optional<Book> retrieveBookById(Long id);

    /**
     * Retrieves all the books in the catalog.
     *
     * @return the list of found books
     */
    List<Book> retrieveAllBooks();

    /**
     * Updates an existing book.
     *
     * @param book the book to update
     * @return the updated book
     */
    Book updateBook(Book book);

    /**
     * Deletes a book by its id.
     *
     * @param id the id of the book to delete
     */
    void deleteBookById(Long id);
}
