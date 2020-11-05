package rec03;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class SortedIntList extends AbstractIntList {
    private final List<Integer> list;

    public SortedIntList() {
        list = new ArrayList<>();
    }

    @Override
    public boolean add(int num) {
        list.add(num);
        sort(list);
        return true;
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public boolean remove(int num) {
        if (!list.remove((Object)num)) {
            return false;
        }
        sort(list);
        return true;
    }

    @Override
    public boolean removeAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.list.remove(list.get(i)) != -1;
        }
        sort(this.list);
        return success;
    }

    @Override
    public int size() {
        return list.size();
    }
}
