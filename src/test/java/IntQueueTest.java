import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class IntQueueTest {
    private IntQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayIntQueue();
    }

    @Test
    public void testInitialQueue() {
        assertTrue(queue.isEmpty());
        assertEquals(1, queue.size());
        assertNull(queue.peek());
        assertNull(queue.dequeue());
    }

    @Test
    public void testEnqueueOneInt() {
        assertTrue(queue.enqueue(3));
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(3, (int)queue.peek());
    }

    @Test
    public void testEnqueueTwoInts() {
        assertTrue(queue.enqueue(4));
        assertTrue(queue.enqueue(-2));
        assertEquals(2, queue.size());
        assertEquals(4, (int)queue.peek());
    }

    @Test
    public void testDequeueOnce() {
        assertTrue(queue.enqueue(100));
        assertTrue(queue.enqueue(-3000));
        assertEquals(100, (int)queue.dequeue());
        assertEquals(1, queue.size());
        assertEquals(-3000, (int)queue.peek());
    }

    @Test
    public void testClear() {
        assertTrue(queue.enqueue(405));
        assertTrue(queue.enqueue(-4000));
        queue.clear();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 10; i++) {
            assertTrue(queue.enqueue(i));
        }
        for (int i = 0; i < 5; i++) {
            assertEquals(i, (int)queue.dequeue());
        }
        for (int i = 0; i < 10; i++) {
            assertTrue(queue.enqueue(i));
        }
        assertEquals(15, queue.size());
        assertEquals(5, (int)queue.peek());
    }
}
