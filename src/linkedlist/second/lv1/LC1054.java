package linkedlist.second.lv1;

import java.util.Arrays;

public class LC1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        return null;
    }

    private int[] helper(int[] barcodes) {
        Arrays.sort(barcodes);
        int middle = (barcodes.length - 1) / 2;;

//        if (barcodes.length % 2 == 0) {
//            middle = barcodes.length / 2;
//        } else {
//            middle = (barcodes.length - 1) / 2;
//        }

        int[] res = new int[barcodes.length];
        for (int i = 0; i < (res.length - 1) / 2; i++) {
            int k = 2 * i;
            res[k] = barcodes[i];
            res[k + 1] = barcodes[middle + i + 1];
        }
        return res;
    }
}
