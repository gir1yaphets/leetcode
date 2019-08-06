public class LC190ReverseBits {
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int unitDigit = n & 1;
            result = (result << 1) | unitDigit;
            n = n >> 1;
        }
        return result;
    }
}
