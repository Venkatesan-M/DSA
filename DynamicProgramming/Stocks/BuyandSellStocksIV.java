package DynamicProgramming.Stocks;

public class BuyandSellStocksIV {
    

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
    // This problem is similar to Buy and Sell Stocks III, but allows for k transactions.
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n][2][k+1]; 

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 2; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        // return profit(dp, prices, 0, 1, k); 

        int[][][] dp = new int[n+1][2][k+1];
        // for(int i = 0; i < 2; i++) dp[n][i][0] = dp[n][i][1] = dp[n][i][2] = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < k + 1; j++){
        //         dp[i][j][0] = 0;
        //     }
        // }

        for(int i = n - 1; i >= 0; i--){
            for(int tx = 1; tx < k+1; tx++){
                dp[i][1][tx] = Math.max(dp[i+1][0][tx] - prices[i], dp[i+1][1][tx]);
                dp[i][0][tx] = Math.max(dp[i+1][1][tx - 1] + prices[i], dp[i+1][0][tx]);
            }
        }

        return dp[0][1][k];

    }

    // int profit(int[][][] dp, int[] prices, int i, int canBuy, int tx) {
    //     int n = prices.length;
    //     if (i == n) return 0;
    //     if(tx == 0) return 0;
    //     if (dp[i][canBuy][tx] != -1) return dp[i][canBuy][tx];

    //     if (canBuy == 1) {
    //         int buy = profit(dp, prices, i + 1, 0, tx) - prices[i];
    //         int skip = profit(dp, prices, i + 1, 1, tx);
    //         dp[i][canBuy][tx] = Math.max(buy, skip);
    //     } else {
    //         int sell = profit(dp, prices, i + 1, 1, tx - 1) + prices[i];
    //         int skip = profit(dp, prices, i + 1, 0, tx);
    //         dp[i][canBuy][tx] = Math.max(sell, skip);
    //     }

    //     return dp[i][canBuy][tx];
    // }
}
