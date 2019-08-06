import java.util.ArrayList;
import java.util.List;

public class LC119PascalTriangle {
    public static List<Integer> getRow(int rowIndex) {
        int[][]a = new int[rowIndex + 1][rowIndex + 1]; //第rowIndex行 第rowIndex列的数组
        a[0][0] = 1;

        for (int i = 1; i <= rowIndex; i++) {
            a[i][0] = 1;
            for (int j = i; j > 0; j--) {
                if (i == j) {
                    a[i][j] = 1;
                } else {
                    a[i][j] = a[i-1][j-1] + a[i-1][j];
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int k = 0; k <= rowIndex; k++) {
            result.add(a[rowIndex][k]);
        }

        return result;
    }
}
