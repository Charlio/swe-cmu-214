package hw03;

import java.util.List;

/**
 * Interface of a permutation generator to generate all
 */
public interface Permutation<E> {
    List<E> next();

    boolean hasNext();

    List<List<E>> getAll();
}
