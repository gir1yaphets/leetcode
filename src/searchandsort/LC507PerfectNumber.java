package searchandsort;

public class LC507PerfectNumber {
    public boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;

        int sum = 0;
        int count = 0;
        int temp = num;
        while (temp % 2 == 0) {
            count += 1;
            temp = temp / 2;
            sum += temp + (int)Math.pow(2, count);
        }

        if (temp != 1) {
            sum += 1;
        }

        return sum == num;
    }
}
