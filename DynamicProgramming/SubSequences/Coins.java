package DynamicProgramming.SubSequences;

import java.util.Arrays;

public class Coins {
    
    // https://leetcode.com/problems/coin-change/description/
    public int coinChange(int[] coins, int amount) {
        // int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // for(int i = 0;i < n; i++) dp[i][0] = 0;
        // for (int j = 0; j <= amount; j++) {
        //     if (j % coins[0] == 0)
        //         dp[0][j] = j / coins[0];
        //     else
        //         dp[0][j] = Integer.MAX_VALUE - 1; // to avoid overflow
        // }

        // for (int i = 1; i < n; i++) {
        //     for (int j = 0; j <= amount; j++) {
        //         int notTake = dp[i - 1][j];
        //         int take = Integer.MAX_VALUE;
        //         if (coins[i] <= j && dp[i][j - coins[i]] != Integer.MAX_VALUE - 1) {
        //             take = 1 + dp[i][j - coins[i]];
        //         }
        //         dp[i][j] = Math.min(take, notTake);
        //     }
        // }

        // return dp[n - 1][amount] >= Integer.MAX_VALUE - 1 ? -1 : dp[n - 1][amount];
        // int res = coinsEx(coins, dp, n - 1, amount);
        // return res == Integer.MAX_VALUE ? -1 : res;



        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    // int coinsEx(int[] coins, int[][] dp, int i, int amount) {
    //     if (i == 0) {
    //         if (amount % coins[i] == 0) return amount / coins[i];
    //         else return Integer.MAX_VALUE;
    //     }
    //     if (amount == 0) return 0;
    //     if (dp[i][amount] != -1) return dp[i][amount];

    //     int notTake = coinsEx(coins, dp, i - 1, amount);
    //     int take = Integer.MAX_VALUE;
    //     if (coins[i] <= amount) {
    //         int res = coinsEx(coins, dp, i, amount - coins[i]);
    //         if (res != Integer.MAX_VALUE) take = 1 + res;
    //     }

    //     return dp[i][amount] = Math.min(take, notTake);
    // }


    // https://leetcode.com/problems/coin-change-ii/description/
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] dp = new int[n][amount+1];
        int[] prev = new int[amount+1];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // for(int i = 0; i < n; i++) dp[i][0] = 1;
        // for(int amt = 0; amt <= amount; amt++){
        //     if(amt % coins[0] == 0) dp[0][amt] = 1;
        //     else{
        //         dp[0][amt] = 0;
        //     }
        // }
        // for(int i = 1; i < n; i++){
        //     for(int amt = 1; amt <= amount; amt++){
        //         int ntake = dp[i-1][amt];
        //         int take = (coins[i]<=amt) ? dp[i][amt-coins[i]] : 0;
        //         dp[i][amt] = take + ntake;
        //     }
        // }

        // return dp[n-1][amount];
        prev[0] = 1;
        for(int amt = 0; amt <= amount; amt++){
            if(amt % coins[0] == 0) prev[amt] = 1;
            else{
                prev[amt] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            int[] temp = new int[amount+1];
            temp[0] = 1;
            for(int amt = 1; amt <= amount; amt++){
                int ntake = prev[amt];
                int take = (coins[i]<=amt) ? temp[amt-coins[i]] : 0;
                temp[amt] = take + ntake;
            }
            prev = temp;
        }
        return prev[amount];


        // return f(coins,dp, amount , n- 1);
    }

    // int f(int[] coins,int[][] dp, int amount, int i){
    //     if(i == 0){
    //         if(amount % coins[0] == 0) return 1;
    //         else{
    //             return 0;
    //         }
    //     }
    //     if(amount == 0) return 1;
    //     if(dp[i][amount]!=-1)return dp[i][amount];
    //     int ntake = f(coins,dp, amount, i-1);
    //     int take = (coins[i]<=amount) ? f(coins,dp, amount - coins[i], i) : 0;
    //     return dp[i][amount] = take + ntake;
    // }

}
