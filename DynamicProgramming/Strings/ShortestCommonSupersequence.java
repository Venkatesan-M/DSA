package DynamicProgramming.Strings;

public class ShortestCommonSupersequence {
    
    // https://leetcode.com/problems/shortest-common-supersequence/description/
    // This problem can be solved using the Longest Common Subsequence (LCS) approach
    public String shortestCommonSupersequence(String str1, String str2) {
        // logic, we will take the common character from both the string once
        // so the ans's len = m + n - lcs(m, n)

        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int x = n, y = m;
        while(x > 0 && y > 0){
            if(str1.charAt(x-1) == str2.charAt(y-1)){
                // common character, take it once
                sb.append(str1.charAt(x-1)); x--; y--;
            }else{
                if(dp[x-1][y] >= dp[x][y-1]){
                    // take from str1
                    sb.append(str1.charAt(x-1)); x--;
                }else{
                    // take from str2
                    sb.append(str2.charAt(y-1)); y--;
                }
            }
        }
        while(y > 0){
            // if str2 is not exhausted, take the remaining characters
            sb.append(str2.charAt(y-1)); y--;
        }
        while(x > 0){
            // if str1 is not exhausted, take the remaining characters
            sb.append(str1.charAt(x-1)); x--;
        }

        return sb.reverse().toString();
    }
}
