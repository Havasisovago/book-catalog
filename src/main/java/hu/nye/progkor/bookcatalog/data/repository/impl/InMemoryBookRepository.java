package hu.nye.progkor.bookcatalog.data.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import hu.nye.progkor.bookcatalog.data.model.Book;
import hu.nye.progkor.bookcatalog.data.repository.Repository;

/**
 * Map-based in-memory implementation of {@link Repository}.
 */
@org.springframework.stereotype.Repository
public class InMemoryBookRepository implements Repository<Book, Long> {

    private static final Map<Long, Book> STORAGE = new HashMap<>();

    @Override
    public Book save(Book book) {
        Long id = STORAGE.size() + 1L;
        book.setId(id);
        STORAGE.put(id, book);
        return STORAGE.get(id);
    }

    @Override
    public Optional<Book> getById(Long id) {
        return Optional.ofNullable(STORAGE.get(id));
    }

    @Override
    public List<Book> getAll() {
        return STORAGE.values().stream().toList();
    }

    @Override
    public Book update(Book book) {
        Long id = book.getId();
        STORAGE.put(id, book);
        return STORAGE.get(id);
    }

    @Override
    public void deleteById(Long id) {
        STORAGE.remove(id);
    }
}
