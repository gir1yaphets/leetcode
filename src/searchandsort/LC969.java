package searchandsort;

import java.util.ArrayList;
import java.util.List;

/**
 * error solution TBD
 */
public class LC969 {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }

        helper(list, result);

        return result;
    }

    private void helper(List<Integer> original, List<Integer> result) {
        if (original.size() == 0) {
            return;
        }

        int maxIndex = getMaxIndex(original);
        result.add(maxIndex + 1);
        result.add(original.size());

        original.remove(maxIndex);
        helper(original, result);
    }

    private int getMaxIndex(List<Integer> list) {
        int index = 0;
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                index = i;
            }
        }

        return index;
    }
}
