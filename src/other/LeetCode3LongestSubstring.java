package other;

import java.util.HashMap;
import java.util.Map;

public class LeetCode3LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
//        int length = 0;
//        int startIndex, endIndex = 0;
//
//        for (startIndex = 0; startIndex < s.length(); startIndex++) {
//            for (endIndex = startIndex + 1; endIndex < s.length(); endIndex++) {
//                if (isAllUnique(s, startIndex, endIndex)) {
//                    length = Math.max(length, endIndex - startIndex + 1);
//                }
//            }
//        }

//        return length;

        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;

    }

    private static boolean isAllUnique(String s, int start, int end) {
        String cache = "";

        for (int i = start; i < end; i++) {
            if (!cache.contains(s.charAt(i) + "")) {
                cache += s.charAt(i);
            } else {
                return false;
            }
        }

        return true;
    }
}
