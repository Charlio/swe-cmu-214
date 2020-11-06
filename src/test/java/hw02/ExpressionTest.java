package hw02;

import hw02.expression.BinaryExpression;
import hw02.expression.NumExpression;
import hw02.expression.UnaryExpression;
import hw02.expression.VariableExpression;
import hw02.operator.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTest {
    @Test
    public void testNumExpression() {
        NumExpression numExp = new NumExpression(4);
        assertEquals(4, numExp.eval(), 1e-3);
        assertEquals("4.0", numExp.toString());
    }

    @Test
    public void testUnaryExpressionAbs() {
        UnaryExpression absExp = new UnaryExpression(new NumExpression(-3), new AbsOperator());
        assertEquals(3, absExp.eval(), 1e-3);
        assertEquals("abs(-3.0)", absExp.toString());
    }

    @Test
    public void testUnaryExpressionNeg() {
        UnaryExpression negExp = new UnaryExpression(new NumExpression(4), new NegOperator());
        assertEquals(-4, negExp.eval(), 1e-3);
        assertEquals("neg(4.0)", negExp.toString());
    }

    @Test
    public void testBinaryExpressionAdd() {
        BinaryExpression addExp = new BinaryExpression(new NumExpression(-3), new NumExpression(4), new AddOperator());
        assertEquals(1, addExp.eval(), 1e-3);
        assertEquals("+(-3.0, 4.0)", addExp.toString());
    }

    @Test
    public void testBinaryExpressionSub() {
        BinaryExpression subExp = new BinaryExpression(new NumExpression(5), new NumExpression(-3), new SubOperator());
        assertEquals(8, subExp.eval(), 1e-3);
        assertEquals("-(5.0, -3.0)", subExp.toString());
    }

    @Test
    public void testBinaryExpressionMul() {
        BinaryExpression mulExp = new BinaryExpression(new NumExpression(2), new NumExpression(-3), new MulOperator());
        assertEquals(-6, mulExp.eval(), 1e-3);
        assertEquals("*(2.0, -3.0)", mulExp.toString());
    }

    @Test
    public void testBinaryExpressionDiv() {
        BinaryExpression divExp = new BinaryExpression(new NumExpression(8), new NumExpression(-4), new DivOperator());
        assertEquals(-2, divExp.eval(), 1e-3);
        assertEquals("/(8.0, -4.0)", divExp.toString());
    }

    @Test
    public void testBinaryExpressionExp() {
        BinaryExpression expExp = new BinaryExpression(new NumExpression(2), new NumExpression(10), new ExpOperator());
        assertEquals(1024, expExp.eval(), 1e-3);
        assertEquals("exp(2.0, 10.0)", expExp.toString());
    }

    @Test
    public void testVariableExpression() {
        VariableExpression varExp = new VariableExpression("x");
        assertEquals(0, varExp.eval(), 1e-3);
        assertEquals("x", varExp.name());
        assertEquals("x", varExp.toString());
        varExp.store(3.2);
        assertEquals(3.2, varExp.eval(), 1e-3);
    }

    @Test
    public void testComplicatedExpression1() {
        // 1 + 2*(3-4)/5 - 2 -> -1.4
        BinaryExpression exp = new BinaryExpression(
                new BinaryExpression(
                        new NumExpression(1),
                        new BinaryExpression(
                                new BinaryExpression(
                                        new NumExpression(2),
                                        new BinaryExpression(
                                                new NumExpression(3),
                                                new NumExpression(4),
                                                new SubOperator()
                                        ),
                                        new MulOperator()
                                ),
                                new NumExpression(5),
                                new DivOperator()
                        ),
                        new AddOperator()
                ),
                new NumExpression(2),
                new SubOperator()
        );
        assertEquals(-1.4, exp.eval(), 1e-3);
    }

    @Test
    public void testComplicatedExpression2() {
        // (3*3 + 4*4)^.5 -> 5.0
        BinaryExpression exp = new BinaryExpression(
                new BinaryExpression(
                        new BinaryExpression(
                                new NumExpression(3),
                                new NumExpression(3),
                                new MulOperator()
                        ),
                        new BinaryExpression(
                                new NumExpression(4),
                                new NumExpression(4),
                                new MulOperator()
                        ),
                        new AddOperator()
                ),
                new NumExpression(0.5),
                new ExpOperator()
        );
        assertEquals(5.0, exp.eval(), 1e-3);
    }
}
