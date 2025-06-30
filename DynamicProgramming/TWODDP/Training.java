package DynamicProgramming.TWODDP;

import java.util.Arrays;

public class Training {
    
    // https://www.geeksforgeeks.org/problems/geeks-training/1
    public int maximumPoints(int[][] arr) {
        int n = arr.length;
        int[][] dp = new int[n][4];  // last can be 0,1,2 or 3 (3 means no task done previously)


        // Tabulation approach
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < 3; j++){
        //         dp[i][j] = arr[i][j];
        //     } 
        // }
        
        // for(int i = 1; i < n; i++){
        //     dp[i][0] += Math.max(dp[i-1][1], dp[i-1][2]);
        //     dp[i][1] += Math.max(dp[i-1][0], dp[i-1][2]);
        //     dp[i][2] += Math.max(dp[i-1][0], dp[i-1][1]);
        // }
        // int ans = Math.max(dp[n-1][0], dp[n-1][1]);
        // return Math.max(ans, dp[n-1][2]);


        // Space Optimized approach
        // int[] prev = new int[3];
        // System.arraycopy(arr[0], 0, prev, 0, 3); // initialize with the first row

        // for (int i = 1; i < n; i++) {
        //     int[] curr = new int[3];
        //     curr[0] = arr[i][0] + Math.max(prev[1], prev[2]);
        //     curr[1] = arr[i][1] + Math.max(prev[0], prev[2]);
        //     curr[2] = arr[i][2] + Math.max(prev[0], prev[1]);
        //     prev = curr; // move to next row
        // }

        // return Math.max(prev[0], Math.max(prev[1], prev[2]));

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return find(arr, dp, n - 1, 3);  // start from last day, with no task done before
    }

    int find(int[][] arr, int[][] dp, int day, int last) {
        if (day < 0) return 0;

        if (dp[day][last] != -1) return dp[day][last];

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = arr[day][task] + find(arr, dp, day - 1, task);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }
}
