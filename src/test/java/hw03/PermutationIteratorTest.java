package hw03;

import hw03.iterator.PermutationWithIterator;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PermutationIteratorTest {
    @Test
    public void testPermuteOneNumber() {
        List<Integer> nums = Collections.singletonList(0);
        PermutationWithIterator<Integer> permutator = new PermutationWithIterator<>(nums);
        Set<String> res = new HashSet<>();
        for (List<Integer> permutation : permutator) {
            res.add(permutation.toString());
        }
        assertEquals(1, res.size());
    }

    @Test
    public void testPermuteTwoNumbers() {
        List<Integer> nums = Arrays.asList(0, 1);
        PermutationWithIterator<Integer> permutator = new PermutationWithIterator<>(nums);
        Set<String> res = new HashSet<>();
        for (List<Integer> permutation : permutator) {
            res.add(permutation.toString());
        }
        assertEquals(2, res.size());
    }

    @Test
    public void testPermuteFourNumbers() {
        List<Integer> nums = Arrays.asList(0, 1, 2, 3);
        PermutationWithIterator<Integer> permutator = new PermutationWithIterator<>(nums);
        Set<String> res = new HashSet<>();
        for (List<Integer> permutation : permutator) {
            res.add(permutation.toString());
        }
        assertEquals(24, res.size());
    }
}
