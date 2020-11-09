package hw03;

import hw03.iterator.PermutationWithIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A permutation class to generate all permutations of size k in a set of n elements: A(k, n)
 * e.g. A(2, 3) for [0, 1, 2]: [0, 1], [1, 0], [0, 2], [2, 0], [1, 2], [2, 1]
 */
public class Permutation<E> implements Iterable<List<E>> {

    private final Combination<E> combination;

    public Permutation(List<E> baseSet, int k) {
        combination = new Combination<>(baseSet, k);
    }

    @Override
    public Iterator<List<E>> iterator() {
        return new PermutationIterator();
    }

    private class PermutationIterator implements Iterator<List<E>> {

        private final List<Iterator<List<E>>> permutations;
        private int cur;

        PermutationIterator() {
            permutations = new ArrayList<>();
            for (List<E> comb : combination) {
                permutations.add(new PermutationWithIterator<>(comb).iterator());
            }
            cur = 0;
        }

        @Override
        public boolean hasNext() {
            return cur < permutations.size() && permutations.get(cur).hasNext();
        }

        @Override
        public List<E> next() {
            List<E> res = permutations.get(cur).next();
            if (!permutations.get(cur).hasNext()) cur++;
            return res;
        }
    }
}
