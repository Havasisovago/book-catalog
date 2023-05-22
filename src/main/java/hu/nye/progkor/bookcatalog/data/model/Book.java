package hu.nye.progkor.bookcatalog.data.model;

import java.util.Objects;

/**
 * Model class for books.
 */
public class Book {

    private Long id;
    private String title;
    private String writer;
    private String publisher;
    private Genre genre;

    public Book() {
    }

    public Book(Long id, String title, String writer, String publisher, Genre genre) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.publisher = publisher;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;

        if (!Objects.equals(id, book.id)) {
            return false;
        }
        if (!Objects.equals(title, book.title)) {
            return false;
        }
        if (!Objects.equals(writer, book.writer)) {
            return false;
        }
        if (!Objects.equals(publisher, book.publisher)) {
            return false;
        }
        return genre == book.genre;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (writer != null ? writer.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", writer='" + writer + '\''
                + ", publisher='" + publisher + '\''
                + ", genre=" + genre
                + '}';
    }
}
