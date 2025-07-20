package DynamicProgramming.LIS;

import java.util.Arrays;

public class LongestBitonicSubsequence {
    
    // https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
    public static int LongestBitonicSequence(int n, int[] nums) {
        int[] inc = new int[n];
        int[] des = new int[n];
        Arrays.fill(inc, 1);
        Arrays.fill(des, 1);

        // Compute LIS (Longest Increasing Subsequence) ending at i
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // Compute LDS (Longest Decreasing Subsequence) starting at i
        for(int i = n - 2; i >= 0; i--){
            for(int j = n - 1; j > i; j--){
                if(nums[i] > nums[j]){
                    des[i] = Math.max(des[i], des[j] + 1);
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(inc[i] > 1 && des[i] > 1){ // ✅ Must have both increasing and decreasing parts
                ans = Math.max(ans, inc[i] + des[i] - 1);
            }
        }
        return ans;
    }
}
