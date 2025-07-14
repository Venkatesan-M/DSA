package DynamicProgramming.Strings;

public class DistinctSubsequences {
    
    // https://leetcode.com/problems/distinct-subsequences/description/
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return ways(dp, s, t, n - 1, m - 1);

        // int[][] dp = new int[n+1][m+1];
        // dp[0][0] = 1;
        // for(int i = 1; i <= n; i++) dp[i][0] = 1;

        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         if(s.charAt(i-1) == t.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        //         }else{
        //             dp[i][j] = dp[i-1][j];
        //         }
        //     }
        // }

        // return dp[n][m];

        // int[] prev = new int[m+1];
        // prev[0] = 1;
        // for(int i = 1; i <= n; i++){
        //     int[] curr = new int[m+1];
        //     curr[0] = 1;
        //     for(int j = 1; j <= m; j++){
        //         if(s.charAt(i-1) == t.charAt(j-1)){
        //             curr[j] = prev[j-1] + prev[j];
        //         }else{
        //             curr[j] = prev[j];
        //         }
        //     }
        //     prev = curr;
        // }
        // return prev[m];


        int[] temp = new int[m + 1];
        temp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    temp[j] = temp[j - 1] + temp[j];
                }
                // else: do nothing, temp[j] remains unchanged
            }
        }

        return temp[m];
    }

    // int ways(int[][] dp, String s, String t, int i, int j){
    //     if(i < 0) return j >= 0 ? 0 : 1;
    //     if(j < 0) return 1;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int w = 0;
    //     if(s.charAt(i) == t.charAt(j)){
    //         int m = ways(dp, s, t, i - 1, j - 1);
    //         int nm = ways(dp, s, t, i - 1, j);
    //         w = m + nm;
    //     }else{
    //         w = ways(dp, s, t, i - 1, j);
    //     }

    //     return dp[i][j] = w;
    // }
}
