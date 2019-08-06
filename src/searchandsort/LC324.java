package searchandsort;

import java.util.Arrays;

public class LC324 {
    /**
     * Error solution: cannot solve the scenario of equal
     * @param nums
     */
    public void wiggleSortError(int[] nums) {
        int temp, max;

        for (int k = 0; k < (nums.length - 2) / 2; k++) {
            int t = 2 * k;
            if (nums[t] > nums[t + 1]) {
                temp = nums[t];
                nums[t] = nums[t + 1];
                nums[t + 1] = temp;
            }

            if (nums[t + 1] < nums[t + 2]) {
                temp = nums[t + 1];
                nums[t + 1] = nums[t + 2];
                nums[t + 2] = temp;
            }
        }

        if (nums.length % 2 == 0 && nums.length >= 2 && nums[nums.length - 1] < nums[nums.length - 2]) {
            temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = temp;
        }
    }

    /**
     * Error solution: fail to handle the equal condition
     * @param nums
     */
    public void wiggleSort(int[] nums) {
        int copy[] = nums.clone();
        Arrays.sort(copy);

        int lo = 0, hi = nums.length - 1;

        for (int i = 0; i < (nums.length - 1) / 2; i++) {
            int k = 2 * i;
            nums[k] = copy[lo];
            nums[k + 1] = copy[hi];
            lo++;
            hi--;
        }

        if (nums.length % 2 == 0 && nums.length > 2) {
            nums[nums.length - 1] = copy[hi];
            nums[nums.length - 2] = copy[lo];
        }
    }
}
