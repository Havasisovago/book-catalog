package hu.nye.progkor.bookcatalog.data.repository;

import java.util.List;
import java.util.Optional;

/**
 * A generic interface for managing entities in a repository.
 *
 * @param <T> the type of the entity
 * @param <I> the type of the entity's identifier
 */
public interface Repository<T, I> {

    /**
     * Saves a new entity in the repository.
     *
     * @param item the entity to save
     * @return the saved entity
     */
    T save(T item);

    /**
     * Retrieves an entity by its identifier.
     *
     * @param id the identifier of the entity to retrieve
     * @return the retrieved entity or empty if it was not found
     */
    Optional<T> getById(I id);

    /**
     * Retrieves all the entities in the repository.
     *
     * @return the list of entities found.
     */
    List<T> getAll();

    /**
     * Updates an existing entity in the repository.
     *
     * @param item the entity to update
     * @return the updated entity
     */
    T update(T item);

    /**
     * Deletes an entity by its identifier.
     *
     * @param id the identifier of the entity to delete
     */
    void deleteById(I id);
}
