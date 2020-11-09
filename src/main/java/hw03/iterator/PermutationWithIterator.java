package hw03.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermutationWithIterator<E> implements Iterable<List<E>> {
    private final List<E> elements;

    public PermutationWithIterator(List<E> elements) {
        this.elements = new ArrayList<>(elements);
    }

    @Override
    public Iterator<List<E>> iterator() {
        return new PermIterator();
    }

    private class PermIterator implements Iterator<List<E>> {
        private boolean started;
        private final List<E> baseList;
        private final int[] tmp;
        private int i;
        private final int n;

        PermIterator() {
            started = false;
            baseList = new ArrayList<>(elements);
            n = elements.size();
            tmp = new int[n];
            for (int j = 0; j < n; j++) tmp[j] = 0;
            i = 0;
        }

        @Override
        public boolean hasNext() {
            if (!started) return true;
            while (i < n) {
                if (tmp[i] < i) {
                    return true;
                }
                tmp[i] = 0;
                i++;
            }
            return false;
        }

        @Override
        public List<E> next() {
            if (!started) {
                started = true;
                return new ArrayList<>(baseList);
            }
            // precondition: i < n && tmp[i] < i
            if (i % 2 == 0) {
                swap(0, i);
            } else {
                swap(tmp[i], i);
            }
            tmp[i]++;
            i = 0;
            return new ArrayList<>(baseList);
        }

        private void swap(int j, int k) {
            E temp = baseList.get(j);
            baseList.set(j, baseList.get(k));
            baseList.set(k, temp);
        }
    }
}
