package hw03;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CryptarithmTest {
    @Test
    public void testValidCryptarithm() {
        String[] crypArgs = {"SEND", "+", "MORE", "=", "MONEY"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testInvalidCryptarithm1() {
        String[] crypArgs = {"SEND", "+", "MORE", "-", "MONEY"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            fail();
        } catch(InvalidCryptarithm ignored) {
        }
    }

    @Test
    public void testSample1() {
        String[] crypArgs = {"SEND", "+", "MORE", "=", "MONEY"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            List<String> res = cryptarithm.generateSolutions();
            assertEquals(1, res.size());
            assertEquals("{S=9, E=5, N=6, D=7, M=1, O=0, R=8, Y=2}", res.get(0));
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testSample2() {
        String[] crypArgs = {"WINTER", "+", "IS", "+", "WINDIER", "+", "SUMMER", "+", "IS", "=", "SUNNIER"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            List<String> res = cryptarithm.generateSolutions();
            assertEquals(1, res.size());
            assertEquals("{W=7, I=6, N=0, T=2, E=8, R=1, S=9, D=4, U=3, M=5}", res.get(0));
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testSample3() {
        String[] crypArgs = {"NORTH", "*", "WEST", "=", "SOUTH", "*", "EAST"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            List<String> res = cryptarithm.generateSolutions();
            assertEquals(1, res.size());
            assertEquals("{N=5, O=1, R=3, T=0, H=4, W=8, E=7, S=6, U=9, A=2}", res.get(0));
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testSample4() {
        String[] crypArgs = {"JEDER", "+", "LIEBT", "=", "BERLIN"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            List<String> res = cryptarithm.generateSolutions();
            assertEquals(2, res.size());
            List<String> expected = Arrays.asList(
                    "{J=6, E=3, D=4, R=8, L=7, I=5, B=1, T=2, N=0}",
                    "{J=4, E=3, D=6, R=8, L=9, I=5, B=1, T=2, N=0}");
            assertArrayEquals(expected.toArray(), res.toArray());
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testSample5() {
        String[] crypArgs = {"I", "+", "CANT", "+", "GET", "=", "NO", "+", "SATISFACTION"};
        try {
            Cryptarithm cryptarithm = new Cryptarithm(crypArgs);
            List<String> res = cryptarithm.generateSolutions();
            assertTrue(res.isEmpty());
        } catch(InvalidCryptarithm e) {
            fail();
        }
    }

    @Test
    public void testSolveInterface() {
        String cry = "JEDER + LIEBT = BERLIN";
        Cryptarithm cryptarithm = new Cryptarithm();
        List<String> res = cryptarithm.solve(cry);
        assertEquals(2, res.size());
        List<String> expected = Arrays.asList(
                "{J=6, E=3, D=4, R=8, L=7, I=5, B=1, T=2, N=0}",
                "{J=4, E=3, D=6, R=8, L=9, I=5, B=1, T=2, N=0}");
        assertArrayEquals(expected.toArray(), res.toArray());
    }
}
