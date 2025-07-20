package DynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    
    // https://leetcode.com/problems/largest-divisible-subset/description/
    // O(n^2)
    // similar to LIS
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int ans = 1;
        int n = nums.length;
        int[] seq = new int[n];
        int[] par = new int[n];
        for(int i = 0; i < n; i++) par[i] = i;
        int start = 0;
        Arrays.fill(seq, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    if(seq[i] < seq[j] + 1) par[i] = j;
                    seq[i] = Math.max(seq[i], seq[j] + 1);
                }
            }
            if(ans < seq[i]) start = i;
            ans = Math.max(ans, seq[i]);
        }
        List<Integer> Lis = new ArrayList<>();
        while(par[start]!=start){
            Lis.add(nums[start]);
            start = par[start];
        }
        Lis.add(nums[start]);
        Collections.reverse(Lis);
        System.out.println(Lis.toString());
        return Lis;
    }
}
