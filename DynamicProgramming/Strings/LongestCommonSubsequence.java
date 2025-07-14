package DynamicProgramming.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSubsequence {


    // https://leetcode.com/problems/delete-operation-for-two-strings/description/  
    public int minDistance(String word1, String word2) {
        int common = longestCommonSubsequence(word1, word2);
        int l1 = word1.length(), l2 = word2.length();
        return (l1 - common) + (l2 - common);
    }
    

    // https://leetcode.com/problems/longest-common-subsequence/description/
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();

        // Tabulation DP approach (2D array)
        // Time Complexity: O(n * m)
        // Space Complexity: O(n * m)

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

        // // Uncomment below to print the LCS string
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


        // Space-optimized tabulation approach (2 1D arrays)
        // Time Complexity: O(n * m)
        // Space Complexity: O(m)

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

        // int[][] dp = new int[n][m];
        // for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        // return lcs(text1, text2, n - 1, m - 1, dp);
    }

    // Memoization (top-down recursive with memo)
    // Time Complexity: O(n * m)
    // Space Complexity: O(n * m) + O(n + m) [stack space]

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



    // https://www.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1
    Set<String> ans; // Use a set to avoid duplicates
    
    public List<String> allLCS(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n+1][m+1];

        // Step 1: Fill DP table for LCS length
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // Step 2: Use Set to collect all unique LCS
        ans = new HashSet<>();
        solve(s1, s2, dp, n, m, new StringBuilder());

        // Convert to list and sort
        List<String> result = new ArrayList<>(ans);
        Collections.sort(result);
        return result;
    }

    void solve(String s1, String s2, int[][] dp, int i, int j, StringBuilder current) {
        if (i == 0 || j == 0) {
            ans.add(current.reverse().toString()); // Reverse to correct the order
            current.reverse(); // Reverse it back to maintain original state
            return;
        }

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            current.append(s1.charAt(i-1));
            solve(s1, s2, dp, i-1, j-1, current);
            current.deleteCharAt(current.length() - 1);
        } else {
            if (dp[i-1][j] == dp[i][j-1]) {
                solve(s1, s2, dp, i-1, j, current);
                solve(s1, s2, dp, i, j-1, current);
            } else if (dp[i-1][j] > dp[i][j-1]) {
                solve(s1, s2, dp, i-1, j, current);
            } else {
                solve(s1, s2, dp, i, j-1, current);
            }
        }
    }
}
