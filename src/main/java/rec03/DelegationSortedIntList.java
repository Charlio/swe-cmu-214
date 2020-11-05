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

public class DelegationSortedIntList extends SortedIntList implements IntegerList {
    public int getTotalAdded() {
        return 0;
    }
}
