package SortingTechniques.CyclicSort.Questions;

// Amazon Question
// https://leetcode.com/problems/missing-number/description/
// Easy
class MissingNumber {
    public static void main(String args[]){
        // the given array of size N contain 1-N natural numbers

        int[] nums = {9,6,4,2,3,5,7,0,1};
        int ans = missingNumber(nums);
        System.out.println(ans);
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] < nums.length && nums[i] != i){
                swap(nums, nums[i], i);
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}