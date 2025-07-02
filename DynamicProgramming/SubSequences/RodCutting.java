package DynamicProgramming.SubSequences;

public class RodCutting {
    
    // https://www.geeksforgeeks.org/problems/rod-cutting0840/1
    public int cutRod(int[] price) {
        int n = price.length;
        // int[][] dp = new int[n + 1][n + 1];


        //  // Base case: using only 1-length rods (i == 0)
        // for (int len = 0; len <= n; len++) {
        //     dp[0][len] = price[0] * len;
        // }

        // // Fill the table
        // for (int i = 1; i < n; i++) {
        //     int rod = i + 1;
        //     for (int len = 0; len <= n; len++) {
        //         int skip = dp[i - 1][len];
        //         int take = (rod <= len) ? price[i] + dp[i][len - rod] : Integer.MIN_VALUE;
        //         dp[i][len] = Math.max(skip, take);
        //     }
        // }

        // return dp[n - 1][n];
        
        int[] prev = new int[n + 1];

        // Initialize for only 1-length rods (price[0])
        for (int len = 0; len <= n; len++) {
            prev[len] = price[0] * len;
        }

        // Iteratively update dp for each rod length
        for (int i = 1; i < n; i++) {
            int rod = i + 1;
            for (int len = rod; len <= n; len++) {
                prev[len] = Math.max(prev[len], price[i] + prev[len - rod]);
            }
        }

        return prev[n];

        // for (int i = 0; i <= n; i++) {
        //     Arrays.fill(dp[i], -1);
        // }

        // return join(price, dp, n, n - 1);
    }

    // int join(int[] price, int[][] dp, int len, int i) {
    //     if (i == 0) return price[0] * len;

    //     int rod = i + 1;

    //     if (dp[rod][len] != -1) return dp[rod][len];

    //     int skip = join(price, dp, len, i - 1);
    //     int take = Integer.MIN_VALUE;

    //     if (rod <= len) {
    //         take = price[i] + join(price, dp, len - rod, i);
    //     }

    //     return dp[rod][len] = Math.max(take, skip);
    // }
}
