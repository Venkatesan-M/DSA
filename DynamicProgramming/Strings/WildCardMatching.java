package DynamicProgramming.Strings;

public class WildCardMatching {
    

    // https://leetcode.com/problems/wildcard-matching/description/
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        // int[][] dp = new int[n][m];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return match(dp, s, p, n - 1, m - 1);
        

        // boolean[][] dp = new boolean[n + 1][m + 1];

        // // Empty pattern matches empty string
        // dp[0][0] = true;

        // // Pattern matches empty string: only possible if pattern is all '*'
        // for (int j = 1; j <= m; j++) {
        //     if (p.charAt(j - 1) == '*') {
        //         dp[0][j] = dp[0][j - 1];
        //     }
        // }

        // // Fill the DP table
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= m; j++) {
        //         char sc = s.charAt(i - 1);
        //         char pc = p.charAt(j - 1);

        //         if (pc == sc || pc == '?') {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         } else if (pc == '*') {
        //             dp[i][j] = dp[i - 1][j]     // * matches one or more
        //                     || dp[i][j - 1];    // * matches empty
        //         } else {
        //             dp[i][j] = false;
        //         }
        //     }
        // }

        // return dp[n][m];


        boolean[] prev = new boolean[m + 1];
        boolean[] curr = new boolean[m + 1];

        // Base case: empty string matches empty pattern
        prev[0] = true;

        // Fill first row for pattern matching empty string (only '*' allowed)
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j - 1) == '*') {
                prev[j] = prev[j - 1];
            }
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = false;  // non-empty string can't match empty pattern

            for (int j = 1; j <= m; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (pc == sc || pc == '?') {
                    curr[j] = prev[j - 1];
                } else if (pc == '*') {
                    curr[j] = prev[j] || curr[j - 1];
                } else {
                    curr[j] = false;
                }
            }

            // Move current row to previous for next iteration
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[m];
    }

    // boolean match(int[][] dp, String s, String p, int i, int j) {
    //     if (j < 0) return i < 0;
    //     if (i < 0) {
    //         // s is exhausted, check if remaining pattern is all '*'
    //         for (int k = 0; k <= j; k++) {
    //             if (p.charAt(k) != '*') return false;
    //         }
    //         return true;
    //     }

    //     if (dp[i][j] != -1) return dp[i][j] == 1;

    //     boolean ans;
    //     if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
    //         ans = match(dp, s, p, i - 1, j - 1);
    //     } else if (p.charAt(j) == '*') {
    //         // '*' matches zero or more characters
    //         ans = match(dp, s, p, i, j - 1) || match(dp, s, p, i - 1, j);
    //     } else {
    //         ans = false;
    //     }

    //     dp[i][j] = ans ? 1 : 0;
    //     return ans;
    // }
}
