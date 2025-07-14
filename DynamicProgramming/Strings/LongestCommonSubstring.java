package DynamicProgramming.Strings;

public class LongestCommonSubstring {
    

    // https://www.geeksforgeeks.org/problems/longest-common-substring1452/1
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        // int[][] dp = new int[n + 1][m + 1];  // dp[i][j] = length of longest common substring ending at s1[i-1], s2[j-1]
        // int result = 0;

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
        //             dp[i][j] = 1 + dp[i - 1][j - 1];
        //             result = Math.max(result, dp[i][j]);
        //         } else {
        //             dp[i][j] = 0; // Reset when characters don't match
        //         }
        //     }
        // }
        // return result;
        
        
        int[] prev = new int[m + 1];  // dp[i][j] = length of longest common substring ending at s1[i-1], s2[j-1]
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    result = Math.max(result, curr[j]);
                } else {
                    curr[j] = 0; // Reset when characters don't match
                }
            }
            prev = curr;
        }
        return result;
    }
}
