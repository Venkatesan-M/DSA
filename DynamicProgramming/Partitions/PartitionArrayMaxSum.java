package DynamicProgramming.Partitions;

public class PartitionArrayMaxSum {
    
    // https://leetcode.com/problems/partition-array-for-maximum-sum/description/
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return par(arr, dp, 0, k);

        int[] dp = new int[n+1];
        // dp[n] = 0;
        for(int i = n - 1; i >= 0; i--){
            int ele = 0; int max = 0;
            for(int j = i; j < n && j < i + k; j++){
                ele = Math.max(arr[j], ele);
                int len = j - i + 1;
                int next = ele * len + dp[j+1];
                max = Math.max(max, next);
            }
            dp[i] = max;
        }
        return dp[0];
    }

    int par(int[] arr,int[] dp, int i, int k){
        int n = arr.length;
        if(i == n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ele = 0; int max = 0;
        for(int j = i; j < n && j < i + k; j++){
            ele = Math.max(arr[j], ele);
            int len = j - i + 1;
            int next = ele * len + par(arr,dp, j + 1, k);
            max = Math.max(max, next);
        }
        return dp[i] = max;
    }
}
