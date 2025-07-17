package DynamicProgramming.Stocks;

public class BuyandSellStocksWithCoolDown {
    
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
    // This problem is similar to Buy and Sell Stocks II, but with a cooldown period after each transaction.
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // ************ MEMOIZATION ************
        // int[][] dp = new int[n][2];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return profit(dp, prices, 0, 1);


        // ************ TABULATION ************
        int[][] dp = new int[n + 2][2]; // +2 to safely access i+2
        for (int i = n - 1; i >= 0; i--) {
            // canBuy = 1
            int buy = -prices[i] + dp[i + 1][0];
            int skipBuy = dp[i + 1][1];
            dp[i][1] = Math.max(buy, skipBuy);

            // canBuy = 0 (i.e., currently holding)
            int sell = prices[i] + dp[i + 2][1]; // cooldown of 1 day
            int skipSell = dp[i + 1][0];
            dp[i][0] = Math.max(sell, skipSell);
        }
        return dp[0][1]; // starting at day 0 with ability to buy
    }

    // ************ MEMOIZATION FUNCTION ************
    // int profit(int[][] dp, int[] prices, int i, int canBuy) {
    //     int n = prices.length;
    //     if (i >= n) return 0;
    //     if (dp[i][canBuy] != -1) return dp[i][canBuy];

    //     if (canBuy == 1) {
    //         int buy = profit(dp, prices, i + 1, 0) - prices[i];
    //         int skip = profit(dp, prices, i + 1, 1);
    //         dp[i][canBuy] = Math.max(buy, skip);
    //     } else {
    //         int sell = profit(dp, prices, i + 2, 1) + prices[i]; // cooldown
    //         int skip = profit(dp, prices, i + 1, 0);
    //         dp[i][canBuy] = Math.max(sell, skip);
    //     }

    //     return dp[i][canBuy];
    // }
}
