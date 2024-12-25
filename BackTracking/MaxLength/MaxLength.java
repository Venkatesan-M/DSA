package BackTracking.MaxLength;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Medium
// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

public class MaxLength {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("a", "abc", "d", "de", "def");
        int ans = maxLength(arr);
        System.out.println(ans); // Expected output: 6 (e.g., "abc" + "def")
    }

    public static int maxLength(List<String> arr) {
        return backtrack(arr, "", 0);
    }

    private static int backtrack(List<String> arr, String current, int index) {
        if (!isUnique(current)) {
            return 0; // Invalid combination
        }
        int maxLength = current.length();
        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(arr, current + arr.get(i), i + 1));
        }
        return maxLength;
    }

    private static boolean isUnique(String s) {
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }
}
