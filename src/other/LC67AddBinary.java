package other;

import java.util.ArrayList;
import java.util.List;

public class LC67AddBinary {
    public String addBinary(String a, String b) {
        String shorter = a.length() <= b.length() ? a : b;
        String longer = a.length() > b.length() ? a : b;
        String supplyZeros = "";

        char count = '0';

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < longer.length() - shorter.length(); i++) {
            supplyZeros += '0';
        }

        String supplyShorter = supplyZeros.concat(shorter);

        for (int i = longer.length() - 1; i >= 0; i--) {
            result.append(sum(sum(longer.charAt(i), supplyShorter.charAt(i)),  count));
            count = getDigit(count, getDigit(longer.charAt(i), supplyShorter.charAt(i)));
        }

        if (result.charAt(longer.length() - 1) == '0' && count == '1') {
            result.insert(longer.length(), '1');
        }

//        StringBuilder reversResult = new StringBuilder();
//        for (int i = result.length() - 1; i >=0; i--) {
//            reversResult.append(result.charAt(i));
//        }

        return result.reverse().toString();
    }

    private char sum(char a, char b) {
        if (a =='0' && b =='0' || a == '1' && b == '1') {
            return '0';
        }

        return '1';
    }

    private char getDigit(char a, char b) {
        if (a == '1' && b == '1') {
            return '1';
        }

        return '0';
    }

    private List<Character> sum(char a, char b, char c) {
        List<Character> result = new ArrayList<>();

        return null;
    }
}
