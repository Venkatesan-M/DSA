package DynamicProgramming.TWODDP;

import java.util.*;

public class LeetCode {
    

    // https://leetcode.com/problems/unique-paths/description/
    public int uniquePaths(int m, int n) {

        // Tabulation approach
        //  int[][] dp = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(i == 0) dp[i][j] = (j== 0) ? 1 : dp[i][j-1];
        //         else if(j == 0) dp[i][j] = (i == 0) ? 1 : dp[i-1][j];
        //         else{
        //             dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //         }
        //     }
        // }
        // return dp[m-1][n-1];


        // Space optimized approach
        // int[] temp = new int[n];
        // Arrays.fill(temp, 1);
        // for(int i = 1; i < m; i++){
        //     int[] curr = new int[n];
        //     for(int j = 0; j < n; j++){
        //         if(j == 0) curr[j] = temp[j];
        //         else{
        //             curr[j] = curr[j-1] + temp[j];
        //         }
        //     }
        //     temp = curr;
        // }
        // return temp[n-1];



        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++)Arrays.fill(dp[i], -1);
        return travel(dp, m-1, n-1);
    }

    int travel(int[][] dp, int i, int j){
        if(i < 0 || j < 0) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int fromTop = travel(dp, i - 1, j);
        int fromLeft = travel(dp, i, j - 1);
        return dp[i][j] = fromTop + fromLeft;
    }


    // https://leetcode.com/problems/unique-paths-ii/description/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;

        // Tabulation approach
        // int[][] dp = new int[m][n];
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
        //         else if(i == 0) dp[i][j] = (j== 0) ? 1 : dp[i][j-1];
        //         else if(j == 0) dp[i][j] = (i == 0) ? 1 : dp[i-1][j];
        //         else{
        //             dp[i][j] = dp[i-1][j] + dp[i][j-1];
        //         }
        //     }
        // }
        // return dp[m-1][n-1];

        // Space optimized approach
        // int[] temp = new int[n]; temp[0] = (obstacleGrid[0][0] == 1) ? 0 : 1;
        // for(int j = 1; j < n; j++){
        //     temp[j] = (obstacleGrid[0][j] == 1) ? 0 : temp[j-1];
        // }
        // for(int i = 1; i < m; i++){
        //     int[] curr = new int[n];
        //     for(int j = 0; j < n; j++){
        //         if(obstacleGrid[i][j] == 1) curr[j] = 0;
        //         else if(j == 0) curr[j] = temp[j];
        //         else{
        //             curr[j] = curr[j-1] + temp[j];
        //         }
        //     }
        //     temp = curr;
        // }
        // return temp[n-1];

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return travel(obstacleGrid, dp, m-1, n-1);
    }

    int travel(int[][] grid, int[][] dp, int i, int j){
        if(i < 0 || j < 0 || grid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int fromTop = travel(grid, dp, i-1, j);
        int fromLeft = travel(grid, dp, i, j-1);
        return dp[i][j] = fromTop + fromLeft;
    }




    // https://leetcode.com/problems/minimum-path-sum/description/
    int m, n;
    public int minPathSum(int[][] grid) {
        m = grid.length; n = grid[0].length;
        int[][] dp = new int[m][n];

        // Tabulation approach
        // for(int i = 0; i < m; i++){
        //     for(int j = 0; j < n; j++){
        //         if(i == 0) dp[i][j] = (j==0) ? grid[0][0] : grid[0][j] + dp[0][j-1];
        //         else if(j == 0) dp[i][j] = (i == 0) ? grid[0][0] : grid[i][0] + dp[i-1][0];
        //         else{
        //             dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // return dp[m-1][n-1];

        // Space optimized approach
        // int[] temp = new int[n];
        // for(int j = 0; j < n; j++){
        //     temp[j] = (j==0) ? grid[0][0] : grid[0][j] + temp[j-1];
        // }
        // for(int i = 1; i < m; i++){
        //     int[] curr = new int[n];
        //     for(int j = 0; j < n; j++){
        //         if(j == 0) curr[j] = grid[i][0] + temp[j];
        //         else{
        //             curr[j] = grid[i][j] + Math.min(curr[j-1], temp[j]);
        //         } 
        //     }
        //     temp = curr;
        // }
        // return temp[n-1];


        for(int i = 0; i < m; i++)Arrays.fill(dp[i], -1);
        return minSum(grid, dp, m - 1, n - 1);
    }

    int minSum(int[][] grid, int[][] dp, int i, int j){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        if(i == 0 && j == 0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        int fromTop = minSum(grid, dp, i - 1, j);
        int fromLeft = minSum(grid, dp, i, j - 1);
        return dp[i][j] = grid[i][j] + Math.min(fromTop, fromLeft);
    }


    // https://leetcode.com/problems/triangle/description/
    public int minimumTotal(List<List<Integer>> triangle) {

        // Tabulation approach
        // int n = triangle.size();
        // int[][] dp = new int[n][n];

        // // Fill the last row of dp with the last row of the triangle
        // for (int j = 0; j < n; j++) {
        //     dp[n - 1][j] = triangle.get(n - 1).get(j);
        // }

        // // Build the dp table from bottom to top
        // for (int i = n - 2; i >= 0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         int val = triangle.get(i).get(j);
        //         dp[i][j] = val + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        //     }
        // }

        // // The result is stored at the top element
        // return dp[0][0];


        // Space optimized approach
        // int n = triangle.size();
        // int[] prev = new int[n];

        // // Initialize prev with the last row of the triangle
        // for (int i = 0; i < n; i++) {
        //     prev[i] = triangle.get(n - 1).get(i);
        // }

        // // Bottom-up from second last row
        // for (int i = n - 2; i >= 0; i--) {
        //     int[] curr = new int[n];  // Only need current row size, but n is safe
        //     for (int j = 0; j <= i; j++) {
        //         int val = triangle.get(i).get(j);
        //         curr[j] = val + Math.min(prev[j], prev[j + 1]);
        //     }
        //     prev = curr;  // Update prev to current row for next iteration
        // }

        // return prev[0];

        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return lvlGo(triangle, dp, 0, 0);
    }

    int lvlGo(List<List<Integer>> triangle, int[][] dp, int i, int lvl){
        if(lvl == triangle.size() - 1) return triangle.get(lvl).get(i);
        if(dp[i][lvl]!=-1)return dp[i][lvl];
        int bottomSt = lvlGo(triangle, dp, i, lvl + 1);
        int bottomRt = lvlGo(triangle, dp, i + 1, lvl + 1);
        return dp[i][lvl] = triangle.get(lvl).get(i) + Math.min(bottomSt, bottomRt);
    }




    // https://leetcode.com/problems/minimum-falling-path-sum/description/
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int[][] dp = new int[n][n];


        // Tabulation approach
        // for(int i = 0; i < n; i++)dp[0][i] = matrix[0][i];
        // for(int i = 1; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         if(j == 0) dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j+1]);
        //         else if(j == n - 1) dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i-1][j-1]);
        //         else{
        //             dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i-1][j+1]));
        //         }
        //     }
        // }
        // int min = dp[n-1][0];
        // for(int i = 1; i < n; i++)min = Math.min(min, dp[n-1][i]);
        // return min;


        // Space optimized approach
        // n = matrix.length;
        // int[] temp = new int[n];
        // for(int i = 0; i < n; i++)temp[i] = matrix[0][i];
        // for(int i = 1; i < n; i++){
        //     int[] curr = new int[n];
        //     for(int j = 0; j < n; j++){
        //         if(j == 0) curr[j] = matrix[i][j] + Math.min(temp[j], temp[j+1]);
        //         else if(j == n - 1) curr[j] = matrix[i][j] + Math.min(temp[j], temp[j-1]);
        //         else{
        //             curr[j] = matrix[i][j] + Math.min(temp[j], Math.min(temp[j-1], temp[j+1]));
        //         }
        //     }
        //     temp = curr;
        // }
        // int min = temp[0];
        // for(int i = 1; i < n; i++)min = Math.min(min, temp[i]);
        // return min;


        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        int min = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            min = Math.min(min, dfs(matrix, dp, n - 1, col));
        }
        return min;
    }

    int dfs(int[][] matrix, int[][] dp, int row, int col) {
        if (col < 0 || col >= n) return Integer.MAX_VALUE; // Prune invalid columns
        if (row == 0) return matrix[0][col];
        if (dp[row][col] != Integer.MIN_VALUE) return dp[row][col];

        int top = dfs(matrix, dp, row - 1, col);
        int topLeft = (col > 0) ? dfs(matrix, dp, row - 1, col - 1) : Integer.MAX_VALUE;
        int topRight = (col < n - 1) ? dfs(matrix, dp, row - 1, col + 1) : Integer.MAX_VALUE;

        return dp[row][col] = matrix[row][col] + Math.min(top, Math.min(topLeft, topRight));
    }
}
