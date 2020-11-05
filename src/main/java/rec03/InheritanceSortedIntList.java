package rec03;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps 
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed) 
 * and exports an accessor (totalAdded) for this count.
 * 
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntList extends SortedIntList {
    private int totalAdded;

    public InheritanceSortedIntList() {
        totalAdded = 0;
    }

    @Override
    public boolean add(int num) {
        boolean success = super.add(num);
        if (success) {
            totalAdded++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= add(list.get(i));
        }
        return success;
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
