package hu.nye.progkor.bookcatalog.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.nye.progkor.bookcatalog.data.model.Book;
import hu.nye.progkor.bookcatalog.service.BookService;

/**
 * Controller for the book catalog.
 */
@Controller
@RequestMapping("/book-catalog")
public class BookCatalogController {

    private final BookService bookService;

    @Autowired
    public BookCatalogController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * Shows the book editor screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the book to retrieve
     * @return the name of the edit view to render
     */
    @GetMapping("/{id}")
    public String getBookById(Model model, @PathVariable Long id) {
        Optional<Book> optionalBook = bookService.retrieveBookById(id);
        return optionalBook.map(book -> {
            model.addAttribute("book", book);
            return "book-catalog/edit";
        }).orElseGet(() -> {
            model.addAttribute("requestUri", "book-catalog/" + id);
            return "book-catalog/notFound";
        });
    }

    /**
     * Shows the book list screen.
     *
     * @param model the model object to store attributes
     * @return the name of the book list view to render
     */
    @GetMapping
    public String getAllBooks(Model model) {
        List<Book> allBooks = bookService.retrieveAllBooks();
        model.addAttribute("books", allBooks);
        return "book-catalog/list";
    }

    /**
     * Shows the book creation screen.
     *
     * @return the name of the book creation view to render
     */
    @GetMapping("/create")
    public String createBook() {
        return "book-catalog/create";
    }

    /**
     * Creates a new book.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param book the book object to create
     * @return the name of the edit view to render
     */
    @PostMapping("/create")
    public String createBook(Model model, Book book) {
        Book newBook = bookService.createBook(book);
        model.addAttribute("book", newBook);
        return "book-catalog/edit";
    }

    /**
     * Updates an existing book.
     * Also navigates back to the editor screen.
     *
     * @param model the model object to store attributes
     * @param book the book object to update
     * @return the name of the edit view to render
     */
    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateBook(Model model, Book book) {
        Book updatedBook = bookService.updateBook(book);
        model.addAttribute("book", updatedBook);
        return "book-catalog/edit";
    }

    /**
     * Deletes a book by ID.
     * Also navigates back to the book list screen.
     *
     * @param model the model object to store attributes
     * @param id the id of the book to delete
     * @return the name of the book list view to render
     */
    @GetMapping("/{id}/delete")
    public String deleteBookById(Model model, @PathVariable Long id) {
        bookService.deleteBookById(id);
        List<Book> allBooks = bookService.retrieveAllBooks();
        model.addAttribute("books", allBooks);
        return "book-catalog/list";
    }
}
