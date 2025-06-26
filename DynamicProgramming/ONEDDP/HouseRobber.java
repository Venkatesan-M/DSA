package DynamicProgramming.ONEDDP;

import java.util.*;  

class HouseRobber {

  // https://leetcode.com/problems/house-robber/description/
  public int rob(int[] nums) {
    // if ith house is robbed -> nums[i] + dp[i-2]
    // if i dont rob, then my reward = dp[i-1]
    // dp[i] = max(rob, nrob)
    // Memorisation
    int n = nums.length;
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    int idx = n - 1;
    return pick(nums, dp, idx);


    // tabulation
    // int[] dp = new int[n+1];
    // for(int i = 0;i < n; i++){
    //     int robbed = (i < 2) ? nums[i] : dp[i-2] + nums[i];
    //     int notRobbed = (i == 0) ? 0 : dp[i-1];
    //     dp[i] = Math.max(robbed, notRobbed);
    // }
    // return dp[n-1];

    // O(1) space
    // int n = nums.length;
    // int sprev = 0, prev = nums[0];
    // for(int i = 1 ;i < n; i++){
    //     int robbed =  sprev + nums[i];
    //     int notRobbed = prev;
    //     int curr = Math.max(robbed, notRobbed);
    //     sprev = prev;
    //     prev = curr;
    // }
    // return prev;
  }

  int pick(int[] nums, int[] dp, int idx){
    if(idx == 0) return nums[0];
    if(idx < 0) return 0;
    if(dp[idx]!=-1) return dp[idx];
    int rob = nums[idx] + pick(nums, dp, idx - 2);
    int nrob = pick(nums, dp, idx - 1);
    return dp[idx] = Math.max(rob, nrob);
  }

  // https://leetcode.com/problems/house-robber-ii/description/
  public int robCircle(int[] nums) {
    int n = nums.length;
    if(n == 1) return nums[0];
    if(n == 2) return Math.max(nums[0], nums[1]);
    int[] dp1 = new int[n+1], dp2 = new int[n+1];
    Arrays.fill(dp1, -1);
    Arrays.fill(dp2, -1);
    int idx = n - 1;
    return Math.max(pick(Arrays.copyOfRange(nums, 1, n), dp1, idx - 1), pick(nums, dp2, idx - 1));
  }
}