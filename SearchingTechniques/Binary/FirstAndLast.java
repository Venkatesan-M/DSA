package SearchingTechniques.Binary;

import java.util.Arrays;

// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=5701s
public class FirstAndLast {
    public static void main(String[] args) {
        int[] nums =  {5,7,7,8,8,10};
        int target = 8;
        int[] output = searchRange(nums, target);
        System.out.println(Arrays.toString(output));
        
    }

        // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        public static int[] searchRange(int[] nums, int target) {
            if(nums.length == 0){
                return new int[] {-1,-1};
            }
            int start = 0; int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(target<nums[mid]){
                    end = mid - 1;
                }
                else if (target>nums[mid]){
                    start = mid + 1;
                }
                else if(target == nums[mid]){
                    while(target!=nums[start]){
                        start++;
                    }
                    while(target!=nums[end]){
                        end--;
                    }
                    return new int[] {start, end};
                }
            }
            return new int[] {-1,-1};
        }
}
