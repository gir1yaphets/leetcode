public class LeetCode7ReverseInterger {
    public static int reverseMine(int x) {
        int result = 0;
        boolean isMinus = false;

        String valueString = String.valueOf(x);

        if (valueString.contains("-")) {
            valueString = valueString.substring(1);
            isMinus = true;
        }

        for (int i = 0; i < valueString.length(); i++) {
            int digitInt = Integer.valueOf(valueString.charAt(i) + "");
            if (result + digitInt * Math.pow(10, i) > Integer.MAX_VALUE) {
                result = 0;
                break;
            } else {
                result += digitInt * Math.pow(10, i);
            }
        }

        if (isMinus) {
            result = result * (-1);
        }

        return result;
    }

    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int lastDigit = x % 10; //取余得最后一位
            x = x / 10;

            //result * 10已经越界了
//            if (result * 10 + lastDigit > Integer.MAX_VALUE || result * 10 + lastDigit < Integer.MIN_VALUE) {
//                return 0;
//            }

            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && lastDigit > 7) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && lastDigit < -8) {
                return 0;
            }

            result = result * 10 + lastDigit;
        }

        return result;
    }
}
