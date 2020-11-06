package hw02;

import hw02.avltree.AvlTreeSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeSetTest {
    private AvlTreeSet avl;

    @Before
    public void setUp() {
        avl = new AvlTreeSet();
    }

    @Test
    public void testInitSize() {
        assertEquals(0, avl.size());
        assertTrue(avl.isEmpty());
    }

    @Test
    public void testInitMax() {
        try {
            avl.getMax();
        } catch (IllegalStateException e) {
            return;
        }
        fail();
    }

    @Test
    public void testInitMin() {
        try {
            avl.getMin();
        } catch (IllegalStateException e) {
            return;
        }
        fail();
    }

    @Test
    public void testInitHeight() {
        assertEquals(-1, avl.getHeight());
    }

    @Test
    public void testInitContains() {
        assertFalse(avl.contains(0));
    }

    @Test
    public void testInitRemove() {
        try {
            avl.remove(0);
        } catch (IllegalStateException e) {
            return;
        }
        fail();
    }

    @Test
    public void testOneNode() {
        avl.insert(2);
        assertFalse(avl.isEmpty());
        assertEquals(1, avl.size());
        assertEquals(0, avl.getHeight());
        assertEquals(2, avl.getMax());
        assertEquals(2, avl.getMin());
        assertTrue(avl.contains(2));

        avl.remove(2);
        assertTrue(avl.isEmpty());
    }

    @Test
    public void testTwoNodes() {
        avl.insert(2);
        avl.insert(3);
        assertEquals(2, avl.getMin());
        assertEquals(3, avl.getMax());
        assertEquals(1, avl.getHeight());
    }

    @Test
    public void testThreeNodes() {
        avl.insert(3);
        avl.insert(1);
        avl.insert(2);
        assertEquals(1, avl.getMin());
        assertEquals(3, avl.getMax());
        assertEquals(1, avl.getHeight());
    }

    @Test
    public void testManyNodes1() {
        avl.insert(3);
        avl.insert(7);
        avl.insert(5);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(2);
        assertEquals(1, avl.getMin());
        assertEquals(7, avl.getMax());
        assertTrue(avl.getHeight() == 2 || avl.getHeight() == 3);
    }

    @Test
    public void testManyNodes2() {
        avl.insert(3);
        avl.insert(2);
        avl.insert(1);
        avl.insert(6);
        avl.insert(7);
        avl.insert(5);
        avl.insert(4);
        assertEquals(1, avl.getMin());
        assertEquals(7, avl.getMax());
        assertTrue(avl.getHeight() == 2 || avl.getHeight() == 3);

        assertTrue(avl.contains(1));
        assertTrue(avl.contains(2));
        assertTrue(avl.contains(3));
        assertTrue(avl.contains(4));
        assertTrue(avl.contains(5));
        assertTrue(avl.contains(6));
        assertTrue(avl.contains(7));
        assertFalse(avl.contains(0));

        try {
            avl.remove(2);
            avl.remove(3);
            avl.remove(4);
            avl.remove(7);
            avl.remove(5);
            avl.remove(1);
            avl.remove(6);
        } catch (IllegalStateException e) {
            fail();
        }
    }
}
