package DataStructures.Hashing;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args){
        int[] arr = {100,4,200,1,3,2};
        int answer = (longestConsecutive(arr));
        System.out.println(answer);
    }

    // https://leetcode.com/problems/longest-consecutive-sequence/
    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int max = 1;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        for(int num : set){
            int x = num, size = 1;
            if(!set.contains(x+1)){
                while(set.contains(x-1)){
                    x--; size++;
                }
                max = Math.max(max, size);
            }
        }
        return max;
    }
}
