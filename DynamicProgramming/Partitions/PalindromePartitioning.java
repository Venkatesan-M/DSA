package DynamicProgramming.Partitions;

public class PalindromePartitioning {
    
    // https://leetcode.com/problems/palindrome-partitioning-ii/description/
    public int minCut(String s) {
        int n = s.length();
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);
        // return cut(s, dp, 0) - 1;  

        int[] dp = new int[n+1];
        for(int i = n - 1; i >= 0; i--){
            String temp = "";
            int min = Integer.MAX_VALUE;
            for(int j = i; j < n; j++){
                temp += s.charAt(j);
                if(isPalindrome(temp)){
                    int next = 1 + dp[j+1];
                    min = Math.min(next, min);
                }
            }
            dp[i] = min;
        } 

        return dp[0] - 1;
    }

    int cut(String s,int[] dp, int i){
        int n = s.length();
        if(i == n) return 0;
        if(dp[i]!=-1) return dp[i];
        String temp = "";
        int min = Integer.MAX_VALUE;
        for(int j = i; j < n; j++){
            temp += s.charAt(j);
            if(isPalindrome(temp)){
                int next = 1 + cut(s,dp, j + 1);
                min = Math.min(next, min);
            }
        }
        return dp[i] = min;
    }

    boolean isPalindrome(String s){
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
