package DynamicProgramming.THREEDDP;

import java.util.Arrays;

public class CherryPicked {
    
    int m, n;
    public int cherryPickup(int[][] grid) {
        m = grid.length; n = grid[0].length;
        int[][][] dp = new int[m][n][n];

        // tabulation approach
        // for(int j1 = 0; j1 < n; j1++){
        //     for(int j2 = 0; j2 < n; j2++){
        //         if(j1==j2) dp[m-1][j1][j2] = grid[m-1][j1];
        //         else{
        //             dp[m-1][j1][j2] = grid[m-1][j1] + grid[m-1][j2];
        //         }
        //     }
        // }
        // for(int i = m - 2; i >= 0; i--){
        //     for(int j1 = 0; j1 < n; j1++){
        //         for(int j2 = 0; j2 < n; j2++){
        //             int max = 0;
        //             int points = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        //             for(int nj1 = -1; nj1 <= 1; nj1++){
        //                 for(int nj2 = -1; nj2 <= 1; nj2++){
        //                     if(j1 + nj1 >= 0 && j1 + nj1 < n && j2 + nj2 >= 0 && j2 + nj2 < n) max = Math.max(max, dp[i+1][j1+nj1][j2+nj2]);
        //                 }
        //             }
        //             dp[i][j1][j2] = max + points;
        //         }
        //     }
        // }
        // return dp[0][0][n-1];



        // Space optimized approach
        // int[][] front = new int[n][n];  // dp[i+1]
        
        // // Base case: last row
        // for (int j1 = 0; j1 < n; j1++) {
        //     for (int j2 = 0; j2 < n; j2++) {
        //         if (j1 == j2) front[j1][j2] = grid[m - 1][j1];
        //         else front[j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
        //     }
        // }

        // // Bottom-up DP
        // for (int i = m - 2; i >= 0; i--) {
        //     int[][] curr = new int[n][n];
        //     for (int j1 = 0; j1 < n; j1++) {
        //         for (int j2 = 0; j2 < n; j2++) {
        //             int max = 0;
        //             for (int d1 = -1; d1 <= 1; d1++) {
        //                 for (int d2 = -1; d2 <= 1; d2++) {
        //                     int nj1 = j1 + d1;
        //                     int nj2 = j2 + d2;
        //                     if (nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n) {
        //                         max = Math.max(max, front[nj1][nj2]);
        //                     }
        //                 }
        //             }
        //             int points = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        //             curr[j1][j2] = points + max;
        //         }
        //     }
        //     front = curr;
        // }

        // return front[0][n - 1];  // Start: robots at (0,0) and (0,n-1)



        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(grid, dp, 0 , 0, n - 1);
    }

    int f(int[][] grid, int[][][] dp, int i, int j1, int j2){
        if((i < 0 || i > m - 1) || (j1 < 0 || j1 >= n) || (j2 < 0 || j2 >= n)) return (int)-1e8;
        if(i == m-1){
            if(j1 == j2) return grid[i][j1];
            else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1)return dp[i][j1][j2];
        int max = 0;
        int points = (j1 == j2) ? grid[i][j1] : grid[i][j1] + grid[i][j2];
        for(int nj1 = -1; nj1 <= 1; nj1++){
            for(int nj2 = -1; nj2 <= 1; nj2++){
                max = Math.max(max, points + f(grid, dp, i+1, j1 + nj1, j2 + nj2));
            }
        }
        return dp[i][j1][j2] = max;
    }
    
    // https://leetcode.com/problems/cherry-pickup/description/
     public int cherryPickupI(int[][] grid) {
        int n = grid.length;
        Integer[][][] memo = new Integer[n][n][n];
        int result = Math.max(0, dfs(grid, 0, 0, 0, memo));
        return result;
    }

    private int dfs(int[][] grid, int r1, int c1, int r2, Integer[][][] memo) {
        int n = grid.length;
        int c2 = r1 + c1 - r2;

        // Bounds or thorn check
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n ||
            grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // Base case: both reached bottom-right
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        // Memoized result
        if (memo[r1][c1][r2] != null)
            return memo[r1][c1][r2];

        int cherries = 0;
        if (r1 == r2 && c1 == c2) {
            cherries += grid[r1][c1]; // Only count once
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        // Try all 4 movement combinations for both players
        int max = Math.max(
                    Math.max(dfs(grid, r1 + 1, c1, r2 + 1, memo),  // ↓↓
                             dfs(grid, r1, c1 + 1, r2, memo)),     // →↓
                    Math.max(dfs(grid, r1 + 1, c1, r2, memo),      // ↓→
                             dfs(grid, r1, c1 + 1, r2 + 1, memo))   // →→
                 );

        if (max == Integer.MIN_VALUE) {
            memo[r1][c1][r2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }

        memo[r1][c1][r2] = cherries + max;
        return memo[r1][c1][r2];
    }

}
