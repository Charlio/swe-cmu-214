package rec03;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps 
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed) 
 * and exports an accessor (totalAdded) for this count.
 * 
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList {
    private final SortedIntList list;
    private int totalAdded;

    public DelegationSortedIntList() {
        list = new SortedIntList();
        totalAdded = 0;
    }

    public boolean add(int num) {
        if (!list.add(num)) {
            return false;
        } else {
            totalAdded++;
            return true;
        }
    }

    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success = add(list.get(i));
        }
        return success;
    }

    public boolean remove(int num) {
        return list.remove(num);
    }

    public boolean removeAll(IntegerList list) {
        return this.list.removeAll(list);
    }

    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }
}
