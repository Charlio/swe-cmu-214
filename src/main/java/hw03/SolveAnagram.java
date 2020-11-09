package hw03;

import hw03.iterator.PermutationWithIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveAnagram {
    public static void main(String[] args) {
        try {
            Set<String> dictWords = createDict(args[0]);
            for (int i = 1; i < args.length; i++) {
                PermutationWithIterator<Character> permutation
                        = new PermutationWithIterator<Character>(toCharList(args[i]));
                System.out.print(args[i] + ": ");
                Set<String> visited = new HashSet<>();
                for (List<Character> perm : permutation) {
                    String word = toWord(perm);
                    if (dictWords.contains(word)) {
                        if (!visited.contains(word)) System.out.print(word + " ");
                        visited.add(word);
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("can't read words file");
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

    private static Set<String> createDict(String fileName) throws IOException {
        // src/main/resources/hw03/words.tct
        InputStream is = SolveAnagram.class.getClassLoader().getResourceAsStream(fileName);
        assert is != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Set<String> words = new HashSet<>();
        String line = reader.readLine();
        while (line != null) {
            words.add(line);
            line = reader.readLine();
        }
        return words;
    }

    private static String toWord(List<Character> chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) sb.append(c);
        return sb.toString();
    }
}
