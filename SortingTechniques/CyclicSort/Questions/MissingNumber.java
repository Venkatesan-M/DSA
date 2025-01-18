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

    // Easy
    // https://leetcode.com/problems/find-missing-and-repeated-values/

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] nums = new int[grid.length * grid[0].length];
        int k = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                nums[k] = grid[i][j];
                k++;
            }
        }
        int index = 0;
        while(index < nums.length){
            int crt = nums[index] - 1;
            if(nums[crt] != nums[index]){
                swap(nums, crt, index);
            }
            else{
                index++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                // Duplicate number and Missing Number Pair
                return new int[] {nums[i], i + 1};
            }
        }
        return new int[] {-1, -1};
    }
}