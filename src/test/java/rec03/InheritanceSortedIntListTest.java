package rec03;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InheritanceSortedIntListTest {
    private InheritanceSortedIntList list;

    @Before
    public void setUp() {
        list = new InheritanceSortedIntList();
    }

    @Test
    public void testAddNoRemoval() {
        list.add(2);
        assertEquals(1, list.getTotalAdded());
        list.add(4);
        assertEquals(2, list.getTotalAdded());
        list.add(-1);
        assertEquals(3, list.getTotalAdded());
    }

    @Test
    public void testAddWithRemoval() {
        list.add(2);
        list.add(4);
        list.add(-1);
        assertEquals(3, list.getTotalAdded());
        list.remove(4);
        assertEquals(3, list.getTotalAdded());
        list.remove(-1);
        assertEquals(3, list.getTotalAdded());
        list.add(9);
        list.add(9);
        assertEquals(5, list.getTotalAdded());
        list.remove(9);
        assertEquals(5, list.getTotalAdded());
        list.remove(9);
        assertEquals(5, list.getTotalAdded());
    }

    /**
     * A helper function that prints out the contents of an IntegerList.
     * @param list IntegerList to be printed out.
     */
    private void printList(IntegerList list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            System.out.print(", ");
        }
        System.out.println();
    }
}
