package DynamicProgramming.Stocks;

public class BuyandSellStocksII {
    
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] dp = new int[n][2]; 

        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // return profit(dp, prices, 0, 1); 

        // int[][] dp = new int[n+1][2]; 
        // dp[n][0] = dp[n][1] = 0; 
        // for(int i = n - 1; i >= 0; i--){
        //     dp[i][1] = Math.max(dp[i+1][0] - prices[i], dp[i+1][1]);
        //     dp[i][0] = Math.max(dp[i+1][1] + prices[i], dp[i+1][0]);
        // }
        // return dp[0][1];
        
        int PBuy = 0; int PSell = 0;
        for(int i = n - 1; i >= 0; i--){
            int NBuy = 0; int NSell = 0;
            NBuy = Math.max(PSell - prices[i], PBuy);
            NSell = Math.max(PBuy + prices[i], PSell);
            PSell = NSell; PBuy = NBuy;

        }
        return PBuy;
    }

    // int profit(int[][] dp, int[] prices, int i, int canBuy) {
    //     int n = prices.length;
    //     if (i == n) return 0;

    //     if (dp[i][canBuy] != -1) return dp[i][canBuy];

    //     if (canBuy == 1) {
    //         int buy = profit(dp, prices, i + 1, 0) - prices[i];
    //         int skip = profit(dp, prices, i + 1, 1);
    //         dp[i][canBuy] = Math.max(buy, skip);
    //     } else {
    //         int sell = profit(dp, prices, i + 1, 1) + prices[i];
    //         int skip = profit(dp, prices, i + 1, 0);
    //         dp[i][canBuy] = Math.max(sell, skip);
    //     }

    //     return dp[i][canBuy];
    // }
}
