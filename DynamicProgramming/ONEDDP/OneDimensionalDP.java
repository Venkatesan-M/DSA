package DynamicProgramming.ONEDDP;

import java.util.*;

class OneDimensionalDP {

  // https://leetcode.com/problems/climbing-stairs/description/
  public int climbStairs(int n) {
    // tabulation
    // int[] dp = new int[n+1];
    // dp[1] = 1; dp[0] = 1;
    // for(int i = 2; i <= n; i++){
    //     dp[i] = dp[i-1] + dp[i-2];
    // }
    // return dp[n];
    
    // Memorisation
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    dp[1] = 1; dp[0] = 1;
    return go(dp, n);
  }

  int go(int[] dp, int curr){
    if(dp[curr]!=-1) return dp[curr];
    dp[curr] = go(dp, curr - 1) + go(dp, curr - 2);
    return dp[curr]; 
  }


  // http://geeksforgeeks.org/problems/geek-jump/1
  int minCost(int[] height) {
    int n = height.length;
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    return jump(dp, height, n - 1);

    // O(1) space
    // if(n < 2) return 0;
    // int sprev = 0, prev = Math.abs(height[0]-height[1]); 

    // for (int i = 2; i < n; i++) {
    //     int oneStep = prev + Math.abs(height[i] - height[i - 1]);
    //     int twoStep = sprev + Math.abs(height[i] - height[i - 2]);
    //     sprev = prev;
    //     prev = Math.min(oneStep, twoStep);
    // }

    // return prev;
  }

  int jump(int[] dp, int[] en, int n){
    if(n <= 0) return 0;
    if(dp[n]!=-1) return dp[n];
    int oneStep = jump(dp, en, n - 1) + Math.abs(en[n] - en[n-1]);
    int twoStep = (n > 1) ? jump(dp, en, n - 2) + Math.abs(en[n] - en[n-2]) : oneStep;
    dp[n] = Math.min(oneStep, twoStep);
    return dp[n];
  }
}