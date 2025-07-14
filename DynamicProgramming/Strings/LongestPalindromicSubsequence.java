package DynamicProgramming.Strings;

public class LongestPalindromicSubsequence {


    // https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/description/
    // This problem can be solved using the Longest Palindromic Subsequence (LPS) approach
    // The minimum number of insertions required to make a string palindrome is equal to the length of the longest palindromic subsequence
    public int minInsertions(String s) {
        int n = s.length();
        int p = longestPalindromeSubseq(s);

        return n - p;
    }
    

    // https://leetcode.com/problems/longest-palindromic-subsequence/description/
    // This problem can be solved using the Longest Common Subsequence (LCS) approach
    public int longestPalindromeSubseq(String s) {
        String s1 = new String(s), s2 = new StringBuilder(s).reverse().toString();

        return longestCommonSubsequence(s1, s2);
    }

    // https://leetcode.com/problems/longest-common-subsequence/
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        // int[][] dp = new int[n + 1][m + 1];
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= m; j++) {
        //         if (i == 0 || j == 0) {
        //             dp[i][j] = 0;
        //         } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // int i = n, j = m;
        // while(i != 0 && j != 0){
        //     if(text1.charAt(i-1) == text2.charAt(j-1)){
        //         sb.append(text1.charAt(i-1)); i--; j--;
        //     }else{
        //         if(dp[i-1][j] >= dp[i][j-1]){
        //             i--;
        //         }else{
        //             j--;
        //         }
        //     }
        // }
        // System.out.println(sb.reverse().toString());
        // return dp[n][m];

        int[] prev = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[m];

        // return lcs(text1, text2, n - 1, m - 1, dp);
    }

    // int lcs(String s1, String s2, int idx1, int idx2, int[][] dp){
    //     if(idx1 < 0 || idx2 < 0) return 0;
    //     if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
    //     int len = 0;
    //     if(s1.charAt(idx1) == s2.charAt(idx2)){
    //         len = 1 + lcs(s1, s2, idx1 - 1, idx2 - 1, dp);
    //     }else{
    //         len = Math.max(lcs(s1, s2, idx1 - 1, idx2, dp), lcs(s1, s2, idx1, idx2 - 1, dp));
    //     }

    //     return dp[idx1][idx2] = len;
    // }
}
