package hw03;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CombinationTest {
    @Test
    public void testOneInteger() {
        List<Integer> baseSet = Collections.singletonList(0);
        Combination<Integer> combination = new Combination<>(baseSet, 1);
        Set<String> res = new HashSet<>();
        for (List<Integer> comb : combination) {
            res.add(comb.toString());
        }
        assertEquals(1, res.size());
    }

    @Test
    public void testTwoIntegers() {
        List<Integer> baseSet = Arrays.asList(0, 1);
        Combination<Integer> combination = new Combination<>(baseSet, 1);
        Set<String> res = new HashSet<>();
        for (List<Integer> comb : combination) {
            res.add(comb.toString());
        }
        assertEquals(2, res.size());
    }

    @Test
    public void testFourIntegers() {
        List<Integer> baseSet = Arrays.asList(0, 1, 2, 3);
        Combination<Integer> combination = new Combination<>(baseSet, 2);
        Set<String> res = new HashSet<>();
        for (List<Integer> comb : combination) {
            res.add(comb.toString());
        }
        assertEquals(6, res.size());
    }

    @Test
    public void testTenIntegers() {
        List<Integer> baseSet = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Combination<Integer> combination = new Combination<>(baseSet, 4);
        Set<String> res = new HashSet<>();
        for (List<Integer> comb : combination) {
            res.add(comb.toString());
        }
        assertEquals(210, res.size());
    }
}
