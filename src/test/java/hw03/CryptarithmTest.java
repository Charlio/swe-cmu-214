package hw03;

import org.junit.Test;

import static org.junit.Assert.fail;

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
        } catch(InvalidCryptarithm e) {
            return;
        }
        fail();
    }
}
