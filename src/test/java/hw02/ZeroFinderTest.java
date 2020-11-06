package hw02;

import hw02.expression.BinaryExpression;
import hw02.expression.Expression;
import hw02.expression.NumExpression;
import hw02.expression.VariableExpression;
import hw02.operator.MulOperator;
import hw02.operator.SubOperator;
import org.junit.Test;
import hw02.zerofinder.ZeroFinder;

import static org.junit.Assert.assertEquals;

public class ZeroFinderTest {
    @Test
    public void testFindSqrtTwo() {
        VariableExpression x = new VariableExpression("x");
        Expression fn = new BinaryExpression(
                new BinaryExpression(x, x, new MulOperator()),
                new NumExpression(2),
                new SubOperator()
        );
        double zero = ZeroFinder.zero(fn, x, 1, 1e-9);
        assertEquals(1.414, zero, 1e-3);
    }
}
