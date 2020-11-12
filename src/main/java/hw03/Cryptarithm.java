package hw03;

import java.util.*;

import hw02.expression.BinaryExpression;
import hw02.expression.Expression;
import hw02.expression.NumExpression;
import hw02.expression.VariableExpression;
import hw02.operator.AddOperator;
import hw02.operator.BinaryOperator;
import hw02.operator.MulOperator;
import hw02.operator.SubOperator;

public class Cryptarithm {
    private static final double DELTA = 1e-5;

    private Expression leftExp, rightExp;
    private List<Character> varNames;
    private List<VariableExpression> vars;
    private Set<Character> leadingVarNames;
    private Permutation<Integer> permutation;

    private void init(String[] exps) throws InvalidCryptarithm {
        varNames = new ArrayList<>();
        vars = new ArrayList<>();
        leadingVarNames = new HashSet<>();
        if (!createExpression(exps)) {
            throw new InvalidCryptarithm();
        }
        List<Integer> digits = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        permutation = new Permutation<>(digits, vars.size());
    }

    public Cryptarithm() {}

    public Cryptarithm(String[] exps) throws InvalidCryptarithm {
        init(exps);
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
        int i = 1;
        try {
            leftExp = createWordExp(exps[0]);
            while (i < exps.length && !exps[i].equals("=")) {
                if (i + 1 == exps.length) return false;
                leftExp = new BinaryExpression(leftExp, createWordExp(exps[i + 1]), createOp(exps[i]));
                i += 2;
            }
        } catch(InvalidCryptarithm e) {
            return false;
        }
        if (i >= exps.length) return false;
        assert exps[i].equals("=");
        i++;
        if (i >= exps.length) return false;
        try {
            rightExp = createWordExp(exps[i++]);
            while (i + 1 < exps.length) {
                rightExp = new BinaryExpression(rightExp, createWordExp(exps[i + 1]), createOp(exps[i]));
                i += 2;
            }
        } catch (InvalidCryptarithm e) {
            return false;
        }
        return true;
    }

    private Expression createWordExp(String word) throws InvalidCryptarithm {
        // TODO validate
        // MORE -> M * 1000 + O * 100 + R * 10 + E
        char[] chars = word.toCharArray();
        createVar(chars[0]);
        leadingVarNames.add(chars[0]);
        Expression exp = getVar(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            createVar(chars[i]);
            exp = new BinaryExpression(exp, new NumExpression(10), new MulOperator());
            exp = new BinaryExpression(exp, getVar(chars[i]), new AddOperator());
        }
        return exp;
    }

    private void createVar(char c) {
        if (!varNames.contains(c)) {
            varNames.add(c);
            vars.add(new VariableExpression(c + ""));
        }
    }

    private VariableExpression getVar(char c) {
        assert varNames.contains(c);
        return vars.get(varNames.indexOf(c));
    }

    private BinaryOperator createOp(String op) throws InvalidCryptarithm {
        return switch (op) {
            case "+" -> new AddOperator();
            case "-" -> new SubOperator();
            case "*" -> new MulOperator();
            default -> throw new InvalidCryptarithm();
        };
    }

    public List<String> solve(String cry) {
        String[] exps = cry.split(" ");
        try {
            init(exps);
        } catch (InvalidCryptarithm e) {
            return new ArrayList<>();
        }
        return generateSolutions();
    }

    public List<String> generateSolutions() {
        List<String> ans = new ArrayList<>();
        for (List<Integer> perm : permutation) {
            if (satisfyCryptarithm(perm)) {
                ans.add(createSolution(perm));
            }
        }
        return ans;
    }

    private boolean satisfyCryptarithm(List<Integer> perm) {
        assert vars.size() == perm.size();
        for (int i = 0; i < vars.size(); i++) {
            if(isLeadingZero(i, perm.get(i))) return false;
            vars.get(i).store(perm.get(i));
        }
        return Math.abs(leftExp.eval() - rightExp.eval()) < DELTA;
    }

    private boolean isLeadingZero(int i, int val) {
        return val == 0 && leadingVarNames.contains(vars.get(i).name().charAt(0));
    }

    private String createSolution(List<Integer> perm) {
        StringBuilder sb = new StringBuilder("{");
        int n = vars.size();
        for (int i = 0; i < n - 1; i++) {
            sb.append(vars.get(i).name()).append("=").append(perm.get(i)).append(", ");
        }
        sb.append(vars.get(n - 1).name()).append("=").append(perm.get(n - 1)).append("}");
        return sb.toString();
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
