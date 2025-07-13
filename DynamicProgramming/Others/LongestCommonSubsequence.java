package DynamicProgramming.Others;

import java.util.*;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String A = input.nextLine();
        String B = input.nextLine();
        int ans = LCS(A, B);
        System.out.println("LCS Length: " + ans);
        input.close();
    }

    public static int LCS(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the LCS from the dp table
        int i = m, j = n;
        StringBuilder lCS = new StringBuilder();

        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                lCS.append(A.charAt(i - 1)); // Add the matching character
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--; // Move up
            } else {
                j--; // Move left
            }
        }

        // LCS is built in reverse order, so we need to reverse it
        String res = lCS.reverse().toString();
        System.out.println("LCS: " + res);

        return dp[m][n]; // Return the length of the LCS
    }

    // 1143 Medium
    // https://leetcode.com/problems/longest-common-subsequence/description/
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(); int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
