public class LC912SortArray {
//    public int[] sortArray(int[] nums) {
//        int temp;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                if (nums[i] > nums[j]) {
//                    temp = nums[i];
//                    nums[i] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
//        return nums;
//    }

    public static void sort(int a[], int start, int end) {
        if (start > end){
            return;
        }

        int i = start, j = end, key = a[i];
        while (i < j) {
            while (i < j && a[j] >= key) {
                j--;
            }

            if (i < j) {
                a[i++] = a[j];
            }

            while (i < j && a[i] < key) {
                i++;
            }

            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = key;
        sort(a, start, i - 1);
        sort(a, i + 1, end);
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
}
