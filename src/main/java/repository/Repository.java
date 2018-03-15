package repository;

import java.io.FileNotFoundException;
import java.util.List;

public interface Repository<T> {


    /**
     * Gets all items from the repository.
     * @return an iterable with objects of type T.
     */
    List<T> getAll();

    /**
     * Loads JSON objects into an array of type T objects.
     * @throws FileNotFoundException - if the specified file does not exisst
     */
    void load() throws FileNotFoundException;
}
