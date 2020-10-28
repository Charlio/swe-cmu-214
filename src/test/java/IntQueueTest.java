import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class IntQueueTest {
    private IntQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayIntQueue();
    }
}
