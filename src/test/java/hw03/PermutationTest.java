package hw03;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PermutationTest {
    @Test
    public void testThreeChoseTwoIntegers() {
        List<Integer> nums = Arrays.asList(0, 1, 2);
        Permutation<Integer> permutation = new Permutation<>(nums, 2);
        Set<String> res = new HashSet<>();
        for (List<Integer> perm : permutation) {
            res.add(perm.toString());
        }
        assertEquals(3 * 2, res.size());
    }

    @Test
    public void testFourChoseThreeIntegers() {
        List<Integer> nums = Arrays.asList(0, 1, 2, 3);
        Permutation<Integer> permutation = new Permutation<>(nums, 3);
        Set<String> res = new HashSet<>();
        for (List<Integer> perm : permutation) {
            res.add(perm.toString());
        }
        assertEquals(4 * 3 * 2, res.size());
    }

    @Test
    public void testTenChoseFourCharacters() {
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j');
        Permutation<Character> permutation = new Permutation<>(chars, 4);
        Set<String> res = new HashSet<>();
        for (List<Character> perm : permutation) {
            res.add(perm.toString());
        }
        assertEquals(10 * 9 * 8 * 7, res.size());
    }

    @Test
    public void testTenChoseTenCharacters() {
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j');
        Permutation<Character> permutation = new Permutation<>(chars, 10);
        Set<String> res = new HashSet<>();
        for (List<Character> perm : permutation) {
            res.add(perm.toString());
        }
        assertEquals(10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2, res.size());
    }
}
