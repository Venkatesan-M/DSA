package DynamicProgramming.Stocks;

public class BuyandSellStocksIII {
    
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][][] dp = new int[n][2][3]; 

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 2; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }

        // return profit(dp, prices, 0, 1, 2); 

        // int[][][] dp = new int[n+1][2][3];
        // for(int i = 0; i < 2; i++) dp[n][i][0] = dp[n][i][1] = dp[n][i][2] = 0;
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 3; j++){
        //         dp[i][j][0] = 0;
        //     }
        // }

        // for(int i = n - 1; i >= 0; i--){
        //     for(int tx = 1; tx < 3; tx++){
        //         dp[i][1][tx] = Math.max(dp[i+1][0][tx] - prices[i], dp[i+1][1][tx]);
        //         dp[i][0][tx] = Math.max(dp[i+1][1][tx - 1] + prices[i], dp[i+1][0][tx]);
        //     }
        // }

        // return dp[0][1][2];

        int PB0 = 0; 
        // int PS0 = 0;
        int PB1 = 0; int PS1 = 0;
        int PB2 = 0; int PS2 = 0;
        for(int i = n - 1; i >= 0; i--){
            // int NB0 = 0; int NS0 = 0;
            int NB1 = 0; int NS1 = 0;
            int NB2 = 0; int NS2 = 0;

            NB1 = Math.max(PS1 - prices[i], PB1);
            NS1 = Math.max(PB0 + prices[i], PS1);
            PS1 = NS1; PB1 = NB1;

            NB2 = Math.max(PS2 - prices[i], PB2);
            NS2 = Math.max(PB1 + prices[i], PS2);
            PS2 = NS2; PB2 = NB2;

        }
        return PB2;
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
