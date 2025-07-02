package DynamicProgramming.SubSequences;

public class Knapsack {
    
     // https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        // int[][] dp = new int[n][W+1];
        // // for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        // for(int cap = 0; cap <= W; cap++){
        //     if(cap>=wt[0])dp[0][cap] = val[0];
        //     else{
        //         dp[0][cap] = 0;
        //     }
        // }
        // for(int i = 1; i < n; i++){
        //     for(int cap = 0; cap <= W; cap++){
        //         int take = (cap >= wt[i]) ? val[i] + dp[i-1][cap-wt[i]] : 0;
        //         int ntake = dp[i-1][cap];
        //         dp[i][cap] = Math.max(take, ntake);
        //     }
        // }
        // return dp[n-1][W];
        
        int[] prev = new int[W+1];
        // for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
        for(int cap = 0; cap <= W; cap++){
            if(cap>=wt[0])prev[cap] = val[0];
            else{
               prev[cap] = 0;
            }
        }
        for(int i = 1; i < n; i++){
            int[] curr = new int[W+1];
            for(int cap = 0; cap <= W; cap++){
                int take = (cap >= wt[i]) ? val[i] + prev[cap-wt[i]] : 0;
                int ntake = prev[cap];
                curr[cap] = Math.max(take, ntake);
            }
            prev = curr;
        }
        return prev[W];
        
        
        // return sack(val, wt,dp, W, n-1);
        
    }
    
    // static int sack(int[] val, int[] wt, int[][] dp, int cap, int i){
    //     if(i == 0){
    //         if(cap >= wt[0])return val[0];
    //         else{
    //             return 0;
    //         }
    //     }
    //     if(dp[i][cap]!=-1)return dp[i][cap];
    //     int take = (cap >= wt[i]) ? val[i] + sack(val, wt,dp, cap - wt[i], i-1): 0;
    //     int ntake = sack(val, wt,dp, cap, i-1);
    //     return dp[i][cap] = Math.max(take, ntake);
    // }



    // https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1
    static int knapSack(int val[], int wt[], int capacity) {
        int n = val.length;
        // int[][] dp = new int[n][capacity+1];
        // for(int cap = 0; cap <= capacity; cap++){
        //     if(cap < wt[0]) dp[0][cap] = 0;
        //     else{
        //         dp[0][cap] = val[0] * (cap / wt[0]);
        //     }
        // }
        
        // for(int i = 1; i < n; i++){
        //     for(int cap = 0; cap <= capacity; cap++){
        //         int take = (wt[i] <= cap)? val[i] + dp[i][cap - wt[i]]: 0;
        //         int ntake = dp[i-1][cap];
        //         dp[i][cap] = Math.max(take, ntake);
        //     }
        // }
        
        // return dp[n-1][capacity];
        
        
        int[] prev = new int[capacity+1];
        for(int cap = 0; cap <= capacity; cap++){
            if(cap < wt[0]) prev[cap] = 0;
            else{
                prev[cap] = val[0] * (cap / wt[0]);
            }
        }
        
        for(int i = 1; i < n; i++){
            int[] curr = new int[capacity+1];
            for(int cap = 0; cap <= capacity; cap++){
                int take = (wt[i] <= cap)? val[i] + curr[cap - wt[i]]: 0;
                int ntake = prev[cap];
                curr[cap] = Math.max(take, ntake);
            }
            prev = curr;
        }
        
        return prev[capacity];
        
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return profit(val, wt,dp, capacity, n-1);
        
    }
    
    // static int profit(int val[], int wt[], int[][] dp, int cap, int i){
    //     if(i == 0){
    //         if(cap < wt[0]) return 0;
    //         else{
    //             return val[0] * (cap / wt[0]);
    //         }
    //     }
    //     if(dp[i][cap]!=-1)return dp[i][cap];
    //     int take = (wt[i] <= cap)? val[i] + profit(val, wt,dp, cap - wt[i], i): 0;
    //     int ntake = profit(val, wt,dp, cap, i - 1);
        
    //     return dp[i][cap] = Math.max(take, ntake);
    // }
}
