package DynamicProgramming.Partitions;

public class MatrixChainMultiplication {

    // https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        // int[][] dp = new int[n][n];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i] , -1);
        
        // return multiple(arr, dp, 1, n - 1);
        
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) dp[i][i] = 0;
        
        for(int i = n - 1; i >= 1; i--){
            for(int j = i + 1; j < n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k < j; k++){
                    int steps = arr[i-1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(min, steps);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
        
    }
    
    static int multiple(int[] arr, int[][]dp, int i, int j){
        if(i == j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int steps = arr[i-1] * arr[k] * arr[j];
            steps = steps + multiple(arr,dp, i, k) + multiple(arr,dp, k + 1, j);
            min = Math.min(min, steps);
        }
        
        return dp[i][j] = min;
    }
}
