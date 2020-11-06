package hw02;

import hw02.expression.BinaryExpression;
import hw02.expression.Expression;
import hw02.expression.NumExpression;
import hw02.expression.VariableExpression;
import hw02.operator.MulOperator;
import hw02.operator.SubOperator;
import org.junit.Test;
import hw02.zerofinder.DerivativeExpression;

import static org.junit.Assert.assertEquals;

public class DerivativeTest {
    @Test
    public void testSimpleDerivative() {
        VariableExpression var = new VariableExpression("x");
        Expression fn = new BinaryExpression(
                new BinaryExpression(
                        var,
                        var,
                        new MulOperator()
                ),
                new NumExpression(2),
                new SubOperator()
        );
        DerivativeExpression derExp = new DerivativeExpression(fn, var);
        assertEquals(0, derExp.eval(), 1e-3);
        var.store(1);
        assertEquals(2, derExp.eval(), 1e-3);
        var.store(-3);
        assertEquals(-6, derExp.eval(), 1e-3);
        assertEquals("(-(*(x, x), 2.0))'", derExp.toString());
    }
}
