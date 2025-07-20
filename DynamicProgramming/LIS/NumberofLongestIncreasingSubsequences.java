package DynamicProgramming.LIS;

import java.util.Arrays;

public class NumberofLongestIncreasingSubsequences {
    

    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] seq = new int[n];
        int[] count = new int[n];
        Arrays.fill(seq, 1);
        Arrays.fill(count, 1);
        int ans = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (seq[i] < seq[j] + 1) {
                        seq[i] = seq[j] + 1;
                        count[i] = count[j]; // Inherit the count
                    } else if (seq[i] == seq[j] + 1) {
                        count[i] += count[j]; // Add ways to reach same length
                    }
                }
            }
            ans = Math.max(ans, seq[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            if (seq[i] == ans) {
                total += count[i];
            }
        }

        return total;
    }
}
