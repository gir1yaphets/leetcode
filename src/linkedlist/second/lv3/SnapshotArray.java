package linkedlist.second.lv3;

import java.util.HashMap;
import java.util.Map;

/**
 * LC1146
 */
public class SnapshotArray {
    private int[] array;
    private int snapId = 0;
    private Map<Integer, int[]> map = new HashMap<>();

    public SnapshotArray(int length) {
        array = new int[length];
    }

    public void set(int index, int val) {
        array[index] = val;
    }

    public int snap() {
        map.put(snapId, array.clone());
        snapId += 1;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        int[] cache = map.get(snap_id);
        return cache[index];
    }
}
