package DynamicProgramming.Stocks;


class BuyAndSellStocksI {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // int ans = find(prices, dp, n - 1, 0);
        // return ans >= 0 ? ans : 0;
        int cost = 0, min = prices[0];
        for(int i = 1; i < n; i++){
            cost = Math.max(cost, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return cost;
    }


    // int find(int[] prices, int[] dp, int i, int buy){
    //     if(i == 0) return dp[i] = buy - prices[0];
    //     if(dp[i]!=-1) return dp[i];
    //     int sell = buy - prices[i];
    //     return dp[i] = Math.max(sell, find(prices, dp, i - 1, Math.max(buy, prices[i])));
    // }
}