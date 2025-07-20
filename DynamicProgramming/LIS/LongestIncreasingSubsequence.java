package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
    
    // https://leetcode.com/problems/longest-increasing-subsequence/description/
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n][n + 1];
        // for(int i = 0; i < n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // return find(nums, dp, 0, -1);

        // int[][] dp = new int[n][n + 1];
        // for(int i = n - 1; i >= 0; i--){
        //     for(int prev = i - 1; prev >= -1; prev--){
        //         int take = 0;
        //         if(prev == -1 || nums[i] > nums[prev]){
        //             take = 1 + dp[i+1][i+1];
        //         }
        //         int ntake = dp[i+1][prev+1];
        //         dp[i][prev+1] = Math.max(take, ntake);
        //     }
        // }

        // return dp[0][0];

        // int[] dp = new int[n + 1];
        // for(int i = n - 1; i >= 0; i--){
        //     int[] temp = new int[n + 1];
        //     for(int prev = i - 1; prev >= -1; prev--){
        //         int take = 0;
        //         if(prev == -1 || nums[i] > nums[prev]){
        //             take = 1 + dp[i+1];
        //         }
        //         int ntake = dp[prev+1];
        //         temp[prev+1] = Math.max(take, ntake);
        //     }
        //     dp = temp;
        // }

        // return dp[0];


        // we gonna just override the number in subsequnce so that we only care about length
        // O(nlogn)
        List<Integer> ow = new ArrayList<>();
        int ans = 1;
        ow.add(nums[0]);
        for(int i = 1; i < n; i++){
            if(nums[i] > ow.get(ow.size() - 1)){
                ow.add(nums[i]);
                ans++;
            }else{
                int crtIdx = bs(ow, nums[i]);
                ow.set(crtIdx, nums[i]);
            }
        }
        // ow is not LIS, it;s just overrided nums
        // return ow.size();
        return ans;
    }

    int bs(List<Integer> arr, int tar){
        int s = 0, e = arr.size() - 1;
        while(s <= e){
            int m = s + (e - s) / 2;
            if(tar > arr.get(m)){
                s = m + 1;
            }else{
                e = m - 1;
            }
        }
        return s;
    }

    public int PrintLIS(int[] nums){
        int n = nums.length;
        // to print the LIS
        int ans = 1;
        int[] seq = new int[n];
        int[] par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        int start = 0;
        Arrays.fill(seq, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(seq[i] < seq[j] + 1) par[i] = j;
                    seq[i] = Math.max(seq[i], seq[j] + 1);
                }
            }
            if(ans < seq[i]) start = i;
            ans = Math.max(ans, seq[i]);
        }
        List<Integer> Lis = new ArrayList<>();
        while(par[start]!=start){
            Lis.add(nums[start]);
            start = par[start];
        }
        Lis.add(nums[start]);
        Collections.reverse(Lis);
        System.out.println(Lis.toString());
        return ans;
    }

    // int find(int[] nums, int[][] dp, int i, int prevIndex) {
    //     int n = nums.length;
    //     if(i == n) return 0;
    //     if(dp[i][prevIndex + 1] != -1) return dp[i][prevIndex + 1];

    //     int take = 0;
    //     if(prevIndex == -1 || nums[i] > nums[prevIndex]) {
    //         take = 1 + find(nums, dp, i + 1, i);
    //     }
    //     int notTake = find(nums, dp, i + 1, prevIndex);

    //     return dp[i][prevIndex + 1] = Math.max(take, notTake);
    // }
}
