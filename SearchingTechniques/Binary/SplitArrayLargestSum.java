package SearchingTechniques.Binary;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8}; int k = 2;
        int output = splitArray(nums, k);
        System.out.println(output);
    }

    // Hard
    // https://leetcode.com/problems/split-array-largest-sum
    public static int splitArray(int[] nums, int k) {
        int MaxSum = 0;
        int MinSum = 0;
        for(int i = 0; i < nums.length; i++){
            MinSum = Math.max(MinSum, nums[i]);
            MaxSum += nums[i];
        }
        // Binary Search
        while(MinSum<MaxSum){
            // try for potential answer (Middle)
            // this is same as start, end but with possible sums with different k values i.e slicing;
            int MidSum = (MinSum) + (MaxSum - MinSum) / 2;
            int pieces = 1; int tempSum = 0;
            for(int i = 0; i < nums.length; i++){
                tempSum+=nums[i];
                if(tempSum > MidSum ){
                    // Subarray exceded the MidSum, so make a new Subarray add count the last subarray;
                    tempSum=nums[i]; pieces++;
                }
            }
            if(pieces > k){
                MinSum = MidSum + 1;
            }
            else{
                MaxSum = MidSum;
            }
        }
        return MaxSum; // MinSum == MaxSum
    
    }
}
