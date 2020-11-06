package hw02;

import hw02.operator.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OperatorTest {
    @Test
    public void testAbsOp() {
        AbsOperator absOp = new AbsOperator();
        assertEquals(0, absOp.apply(0), 1e-3);
        assertEquals(3, absOp.apply(-3), 1e-3);
        assertEquals(2, absOp.apply(2), 1e-3);
        assertEquals("abs", absOp.toString());
    }

    @Test
    public void testNegOp() {
        NegOperator negOp = new NegOperator();
        assertEquals(0, negOp.apply(0), 1e-3);
        assertEquals(2, negOp.apply(-2), 1e-3);
        assertEquals(-3, negOp.apply(3), 1e-3);
        assertEquals("neg", negOp.toString());
    }

    @Test
    public void testAddOp() {
        AddOperator addOp = new AddOperator();
        assertEquals(3, addOp.apply(1, 2), 1e-3);
        assertEquals(0, addOp.apply(-1, 1), 1e-3);
        assertEquals(-5, addOp.apply(-9, 4), 1e-3);
        assertEquals("+", addOp.toString());
    }

    @Test
    public void testSubOp() {
        SubOperator subOp = new SubOperator();
        assertEquals(8, subOp.apply(10, 2), 1e-3);
        assertEquals(5, subOp.apply(3, -2), 1e-3);
        assertEquals(-6, subOp.apply(2, 8), 1e-3);
        assertEquals("-", subOp.toString());
    }

    @Test
    public void testMulOp() {
        MulOperator mulOp = new MulOperator();
        assertEquals(6, mulOp.apply(3, 2), 1e-3);
        assertEquals(0, mulOp.apply(0, 5), 1e-3);
        assertEquals(-4, mulOp.apply(-2, 2), 1e-3);
        assertEquals(9, mulOp.apply(-3, -3), 1e-3);
        assertEquals("*", mulOp.toString());
    }

    @Test
    public void testDivOp() {
        DivOperator divOp = new DivOperator();
        assertEquals(2, divOp.apply(6, 3), 1e-3);
        assertEquals(-4, divOp.apply(-8, 2),1e-3);
        assertEquals(0.2, divOp.apply(-1, -5), 1e-3);
        assertEquals("/", divOp.toString());
    }

    @Test
    public void testExpOp() {
        ExpOperator expOp = new ExpOperator();
        assertEquals(1, expOp.apply(2, 0), 1e-3);
        assertEquals(3, expOp.apply(3, 1), 1e-3);
        assertEquals(8, expOp.apply(2, 3), 1e-3);
        assertEquals(-243, expOp.apply(-3, 5), 1e-3);
        assertEquals("exp", expOp.toString());
    }
}
