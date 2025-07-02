package DynamicProgramming.SubSequences;

import java.util.Arrays;

public class SubSetSums {
    
   // https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1 
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        // int[][] dp = new int[n][sum + 1];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        
        // for (int i = 0; i < n; i++) dp[i][0] = 1;
        // if (arr[0] <= sum) dp[0][arr[0]] = 1;
    
        // for (int i = 1; i < n; i++) {
        //     for (int tar = 1; tar <= sum; tar++) {
        //         int notTake = dp[i - 1][tar];
        //         int take = 0;
        //         if (tar >= arr[i] && dp[i - 1][tar - arr[i]] == 1) {
        //             take = 1;
        //         }
        //         dp[i][tar] = (take == 1 || notTake == 1) ? 1 : 0;
        //     }
        // }
    
        // return dp[n - 1][sum] == 1;
        
        int[] prev = new int[sum + 1];

        prev[0] = 1;
        if (arr[0] <= sum) prev[arr[0]] = 1;
    
        for (int i = 1; i < n; i++) {
            int[] temp = new int[sum + 1];
            temp[0] = 1;
    
            for (int tar = 1; tar <= sum; tar++) {
                int notTake = prev[tar];
                int take = 0;
                if (tar >= arr[i]) take = prev[tar - arr[i]];
                temp[tar] = (take == 1 || notTake == 1) ? 1 : 0;
            }
    
            prev = temp;  // temp becomes the new prev for the next iteration
        }
    
        return prev[sum] == 1;
        // return find(arr, dp, sum, n - 1) == 1;
    }
    
    // static int find(int arr[], int dp[][], int target, int i){
    //     if(target == 0) return 1;
    //     if(i == 0) return target == arr[0] ? 1 : 0;
    //     if(dp[i][target]!=-1) return dp[i][target];
    //     int notTake = find(arr, dp, target, i - 1);
    //     int take = (target >= arr[i]) ? find(arr, dp, target - arr[i], i - 1) : 0;
    //     return dp[i][target] = (take == 1 || notTake == 1) ? 1 : 0;
    // }   


    // https://leetcode.com/problems/partition-equal-subset-sum/description/
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums) sum+=i;
        if((sum & 1) == 1) return false; 
        return isSubsetSum(nums, sum / 2);
    }


    // https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1
    public int minDifference(int nums[]) {
        int sum = 0, n = nums.length;
        for(int i : nums) sum+=i;    

        // tabulation approach
        // boolean[][] dp = new boolean[n][sum+1];
        // for(int i = 0; i < n; i++) dp[i][0] = true;
        // if(nums[0] >= 0 && nums[0] <= sum)dp[0][nums[0]] = true;
        // for (int i = 1; i < n; i++) {
        //     for (int tar = 1; tar <= sum; tar++) {
        //         boolean notTake = dp[i - 1][tar];
        //         boolean take = false;
        //         if (tar >= nums[i] && dp[i - 1][tar - nums[i]]) {
        //             take = true;
        //         }
        //         dp[i][tar] = (take || notTake) ? true : false;
        //     }
        // }
        
        boolean[] prev = new boolean[sum + 1];

        prev[0] = true;
        if (nums[0] <= sum) prev[nums[0]] = true;
    
        for (int i = 1; i < n; i++) {
            boolean[] temp = new boolean[sum + 1];
            temp[0] = true;
    
            for (int tar = 1; tar <= sum; tar++) {
                boolean notTake = prev[tar];
                boolean take = false;
                if (tar >= nums[i]) take = prev[tar - nums[i]];
                temp[tar] = (take || notTake ) ? true : false;
            }
    
            prev = temp;  // temp becomes the new prev for the next iteration
        }
        int ans = sum;
        for(int tar = 1; tar <= sum/2; tar++){
            if(prev[tar]){
                ans = Math.min(ans, Math.abs(tar - (sum - tar)));
            }
        }
        return ans;
    }


    // https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        // int[][] dp = new int[n][target + 1];

        // // Initialization
        // if (nums[0] == 0) {
        //     dp[0][0] = 2; // Include or exclude zero
        // } else {
        //     dp[0][0] = 1; // Exclude nums[0]
        //     if (nums[0] <= target) dp[0][nums[0]] = 1; // Include nums[0]
        // }

        // // DP transition
        // for (int i = 1; i < n; i++) {
        //     for (int tar = 0; tar <= target; tar++) {
        //         int noTake = dp[i - 1][tar];
        //         int take = 0;
        //         if (tar >= nums[i]) take = dp[i - 1][tar - nums[i]];
        //         dp[i][tar] = (noTake + take);
        //     }
        // }

        // return dp[n - 1][target];
        
        
        // int[] prev = new int[target + 1];

        // // Initialization
        // if (nums[0] == 0) {
        //     prev[0] = 2; // Include or exclude zero
        // } else {
        //     prev[0] = 1; // Exclude nums[0]
        //     if (nums[0] <= target) prev[nums[0]] = 1; // Include nums[0]
        // }

        // // DP transition
        // for (int i = 1; i < n; i++) {
        //     int[] curr = new int[target + 1];
        //     for (int tar = 0; tar <= target; tar++) {
        //         int noTake = prev[tar];
        //         int take = 0;
        //         if (tar >= nums[i]) take = prev[tar - nums[i]];
        //         curr[tar] = (noTake + take);
        //     }
        //     prev = curr;
        // }

        // return prev[target];

        return ways(nums, dp, n-1, target);
    }
    
    int ways(int[] nums, int[][] dp, int i, int tar) {
        if (i == 0) {
            if (tar == 0 && nums[0] == 0) return 2;
            if (tar == 0 || tar == nums[0]) return 1;
            return 0;
        }
        
        if (dp[i][tar] != -1) return dp[i][tar];
        
        int dontPick = ways(nums, dp, i - 1, tar);
        int pick = (tar >= nums[i]) ? ways(nums, dp, i - 1, tar - nums[i]) : 0;
        
        return dp[i][tar] = dontPick + pick;
    }


    // https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1
    int countPartitions(int[] arr, int d) {
        // code here
        int total = 0;
        for(int i : arr) total += i;
        if(total - d < 0 || (total - d) % 2 != 0) return 0;
        return perfectSum(arr, (total - d) / 2);
    }

    // https://leetcode.com/problems/target-sum/description/
    // split the array into two subsets such that the difference between their sums is equal to target
    // this is equivalent to finding the number of ways to partition the array into two subsets such
    // that the sum of one subset is equal to (total_sum - target) / 2
    // if total_sum - target is odd or negative, return 0
    public int findTargetSumWays(int[] nums, int target) {
        return countPartitions(nums, target);
    }
}
