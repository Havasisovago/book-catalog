package hu.nye.progkor.bookcatalog.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import hu.nye.progkor.bookcatalog.data.model.Genre;
import hu.nye.progkor.bookcatalog.data.model.Book;
import hu.nye.progkor.bookcatalog.data.repository.Repository;
import hu.nye.progkor.bookcatalog.service.BookService;

/**
 * Unit tests for {@link DefaultBookService}.
 */
class DefaultBookServiceTest {

    private static final Long DUMMY_SONG_ID = 1L;
    private static final Book DUMMY_SONG = new Book(DUMMY_SONG_ID, "title", "writer", "publisher", Genre.Regény);

    @Mock
    private Repository<Book, Long> bookRepository;

    private BookService underTest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        underTest = new DefaultBookService(bookRepository);
    }

    @Test
    void createBookShouldDelegateToTheRepositoryAndReturnSavedBook() {
        // Given
        given(bookRepository.save(DUMMY_SONG)).willReturn(DUMMY_SONG);

        // When
        final Book actual = underTest.createBook(DUMMY_SONG);

        // Then
        assertThat(actual, equalTo(DUMMY_SONG));
        verify(bookRepository).save(DUMMY_SONG);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void retrieveBookByIdShouldDelegateToTheRepositoryAndReturnFoundBook() {
        // Given
        given(bookRepository.getById(DUMMY_SONG_ID)).willReturn(Optional.of(DUMMY_SONG));

        // When
        final Optional<Book> actual = underTest.retrieveBookById(DUMMY_SONG_ID);

        // Then
        assertThat(actual, equalTo(Optional.of(DUMMY_SONG)));
        verify(bookRepository).getById(DUMMY_SONG_ID);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void retrieveAllBooksShouldDelegateToTheRepositoryAndReturnAllFoundBooks() {
        // Given
        given(bookRepository.getAll()).willReturn(List.of(DUMMY_SONG));

        // When
        final List<Book> actual = underTest.retrieveAllBooks();

        // Then
        assertThat(actual, equalTo(List.of(DUMMY_SONG)));
        verify(bookRepository).getAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void updateBook() {
    }

    @Test
    void deleteBookById() {
    }
}
