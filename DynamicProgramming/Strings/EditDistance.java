package DynamicProgramming.Strings;

public class EditDistance {
    
    // https://leetcode.com/problems/edit-distance/description/
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return edit(dp, word1, word2, n - 1, m - 1);

        // int[][] dp = new int[n+1][m+1];
        // for(int j = 0; j <= m; j++) dp[0][j] = j;
        // for(int i = 0; i <= n; i++) dp[i][0] = i;

        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         if(word1.charAt(i-1) == word2.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1];
        //         }else {
        //             int insert = 1 + dp[i][j-1];
        //             int replace = 1 + dp[i-1][j-1];
        //             int delete = 1 + dp[i-1][j];
        //             dp[i][j] = Math.min(insert, Math.min(replace, delete));
        //         }
        //     }
        // }

        // return dp[n][m];


        int[] prev = new int[m+1];
        for(int j = 0; j <= m; j++) prev[j] = j;

        for(int i = 1; i <= n; i++){
            int[] curr = new int[m+1];
            curr[0] = i;
            for(int j = 1; j <= m; j++){
                curr[j] = j;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else {
                    int insert = 1 + curr[j-1];
                    int replace = 1 + prev[j-1];
                    int delete = 1 + prev[j];
                    curr[j] = Math.min(insert, Math.min(replace, delete));
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    // int edit(int[][] dp, String s1, String s2, int i, int j){
    //     if(i < 0) return j + 1;
    //     if(j < 0) return i + 1;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     if(s1.charAt(i) == s2.charAt(j)){
    //         return dp[i][j] = 0 + edit(dp, s1, s2, i - 1, j - 1);
    //     }
    //     int insert = 1 + edit(dp, s1, s2, i, j -1);
    //     int replace = 1 + edit(dp, s1, s2, i - 1, j -1);
    //     int delete = 1 + edit(dp, s1, s2, i - 1, j);
        
    //     return dp[i][j] = Math.min(insert, Math.min(replace, delete));
    // }

}
