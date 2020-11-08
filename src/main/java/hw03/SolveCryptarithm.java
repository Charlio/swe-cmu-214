package hw03;

import java.util.Arrays;
import java.util.List;

public class SolveCryptarithm {

    public static void main(String[] args) {
        // java SolveCryptarithm SEND + MORE = MONEY
        Cryptarithm cryptarithm;
        try {
            cryptarithm = new Cryptarithm(args);
        } catch (InvalidCryptarithm e) {
            System.out.println("invalid cryptarithm" + Arrays.toString(args));
            return;
        }
        List<String> solutions = cryptarithm.generateSolutions();
        if (solutions.isEmpty()) {
            System.out.println("0 solution(s)");
            return;
        }
        System.out.println(solutions.size() + " solution(s):");
        for (String solution : solutions) {
            System.out.println(solution);
        }
    }
}
