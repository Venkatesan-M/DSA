package STS;

public class LongestSequenceof1safterFlip {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int output = longestOnes(nums, k);
        System.out.println(output);
    }

    // https://leetcode.com/problems/max-consecutive-ones-iii/description/
    public static int longestOnes(int[] nums, int k) {
        int l = 0; int zeros = 0; int maxLength = 0;
        for(int r = 0; r < nums.length; r++){
            if(nums[r]==0){
                zeros++;
            }
            while(zeros > k){
                if(nums[l]==0){
                    zeros--;
                }
                l++;
            }
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }
}
