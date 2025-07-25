package DynamicProgramming.Partitions;

import java.util.Arrays;

public class BurstBalloons {
    
    // https://leetcode.com/problems/burst-balloons/description/
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n+2];
        Arrays.fill(balloons, 1);
        System.arraycopy(nums, 0, balloons, 1, n);
        // int[][] dp = new int[n+1][n+1];
        // // for(int i = 0; i < n+1; i++) Arrays.fill(dp[i], -1);
        // // return burst(balloons,dp, 1, n);

        int[][] dp = new int[n+2][n+2];
        for(int i = n; i >= 1; i--){
            for(int j = 1; j <= n; j++){
                if(i > j) continue;
                int max = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++){
                    int points = balloons[i-1] * balloons[k] * balloons[j+1];
                    points += dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max, points);
                }
                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    int burst(int[] balloons, int[][] dp, int i, int j){
        if(i > j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k = i; k <= j; k++){
            int points = balloons[i-1] * balloons[k] * balloons[j+1];
            points += burst(balloons,dp, i, k - 1) + burst(balloons,dp, k + 1, j);
            max = Math.max(max, points);
        }
        return dp[i][j] = max;
    }
}
