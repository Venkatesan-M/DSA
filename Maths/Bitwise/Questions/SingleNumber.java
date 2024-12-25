package Bitwise.Questions;

//Easy
// https://leetcode.com/problems/single-number/
public class SingleNumber{
    public static void main(String[] args) {
        // 6 alone doesn't have a pair in this array
        int arr[] = {2, 3, 4, 1, 2, 1, 3, 6, 4};

        // find the element which doesn't have the pair.
        int ans = singleNumber(arr);
        System.out.println(ans);
    }

    public static int singleNumber(int[] nums) {
        // XOR Operator Question
        // a ^ a = 0 
        // a ^ 0 = 0
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans = ans ^ nums[i]; // Pair will cancel out each other
            // only the Unique number will be there in answer
        }
        return ans;
    }

    // Medium
    // https://leetcode.com/problems/single-number-ii/description/

    public static int singleNumberII(int[] nums) {

        // ones will hold bits that have appeared exactly once so far.
        // twos will hold bits that have appeared exactly twice so far.
        // If a bit appears three times, it gets removed from both ones and twos.

        int ones = 0, twos = 0;
        
        for (int num : nums) {
            // Update `ones` with bits that appear once
            ones = (ones ^ num) & ~twos;
            
            // Update `twos` with bits that appear twice
            twos = (twos ^ num) & ~ones;
        }
        
        return ones; // `ones` contains the single number
    }
}