package hw03;

import hw03.iterator.PermutationWithIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolveAnagram {
    public static void main(String[] args) {
        // load words.txt, word1, word2, etc.
        String dictFile = args[0];
        for (int i = 1; i < args.length; i++) {
            PermutationWithIterator<Character> permutation
                    = new PermutationWithIterator<Character>(toCharList(args[i]));
            // generate permutations of each word
            // check each permutation in the dictionary words.txt
            // print anagrams for each word
        }
    }

    private static List<Character> toCharList(String arg) {
        char[] chars = arg.toCharArray();
        List<Character> res = new ArrayList<>();
        for (char c : chars) {
            res.add(c);
        }
        return res;
    }
}
