package hw03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A Combination class to select k elements from a set of n elements: C(k, n)
 */
public class Combination<E> implements Iterable<List<E>> {

    private final int k;
    private final List<E> baseSet;

    public Combination(List<E> baseSet, int k) {
        this.k = k;
        this.baseSet = new ArrayList<>(baseSet);
    }

    @Override
    public Iterator<List<E>> iterator() {
        return new CombinationIterator();
    }

    private class CombinationIterator implements Iterator<List<E>> {

        private final List<E> base;
        private boolean[] flags;
        private final int kk, n;
        private int start, end;
        private boolean first;

        CombinationIterator() {
            base = new ArrayList<>(baseSet);
            n = base.size();
            kk = k;
            flags = new boolean[n];
            for (int i = 0; i < kk; i++) flags[i] = true;
            for (int i = kk + 1; i < n; i++) flags[i] = false;
            first = true;
            start = 0;
            end = kk - 1;
        }

        @Override
        public boolean hasNext() {
            return first || end < n - 1;
        }

        @Override
        public List<E> next() {
            if (first) {
                first = false;
                return createComb();
            }
            if (start == end) {
                flags[end] = false;
                flags[end + 1] = true;
                start += 1;
                end += 1;
                while (end + 1 < n && flags[end + 1]) end++;
            } else {
                if (start == 0) {
                    flags[end] = false;
                    flags[end + 1] = true;
                    end--;
                } else {
                    flags[end + 1] = true;
                    for (int i = start; i <= end; i++) flags[i] = false;
                    for (int i = 0; i < end - start; i++) flags[i] = true;
                    end -= start + 1;
                    start = 0;
                }
            }
            return createComb();
        }

        private List<E> createComb() {
            List<E> res = new ArrayList<>();
            for (int i = 0, count = 0; i < n && count < kk; i++) {
                if (flags[i]) {
                    res.add(base.get(i));
                    count++;
                }
            }
            return res;
        }
    }
}
