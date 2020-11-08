package hw03;

import hw02.expression.Expression;
import hw02.expression.VariableExpression;
import hw03.iterator.PermutationWithIterator;

import java.util.ArrayList;
import java.util.List;

public class Cryptarithm {
    private Expression leftExp, rightExp;
    private List<VariableExpression> vars;
    private List<PermutationWithIterator<Integer>> permutations;

    public Cryptarithm(String[] exps) throws InvalidCryptarithm {
        if (!createExpression(exps)) {
            throw new InvalidCryptarithm();
        }
        createPermutation();
    }

    /**
     * cryptarithm ::= <expr> "=" <expr>
     * expr ::= <word> [<operator> <word>]*
     * word ::= <alphabetic-character>+
     * operator ::= "+" | "-" | "*"
     *
     * @param exps an array of strings representing the cryptarithm equation
     * @return bool is the input array of strings a valid cryptarithm
     */
    private boolean createExpression(String[] exps) {
        // TODO check hw02.termcalc.ExpressionParser
        return false;
    }

    private void createPermutation() {
        // pick from 0...9 match size of vars -> many choices
        // each choice has permutations
    }

    public List<String> generateSolutions() {
        // iterate over permutations
        // fill values for vars
        // check leftExp equals rightExp
        // if yes, add a repr string of the letter2num mapping to result
        return new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
