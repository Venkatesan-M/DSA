package DynamicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    
    // https://leetcode.com/problems/longest-string-chain/description/
    // O(n^2 * m) where m is the average length of the strings
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int ans = 1;
        int[] seq = new int[n];
        Arrays.fill(seq, 1);

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(checker(words[i], words[j])){
                    seq[i] = Math.max(seq[i], seq[j] + 1);
                }
            }
            ans = Math.max(ans, seq[i]);
        }
        return ans;
    }

    boolean checker(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if(n != m + 1) return false;
        int i = 0, j = 0;
        while(i < n){
            if(j < m && s1.charAt(i) == s2.charAt(j)){
                i++; j++;
            } else {
                i++;
            }
        }
        return j == m;
    }
}
