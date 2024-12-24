package SortingTechniques.CyclicSort.Questions;

// Amazon
// https://leetcode.com/problems/first-missing-positive/description/
// Hard

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int ans = firstMissingPositive(nums);
        System.out.println(ans);  
                        
    }
                    
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
                
    public static int firstMissingPositive(int[] nums) {
        int index = 0;
        while(index < nums.length){
            int crt = nums[index] - 1;
            // cyclic sort only the positive numbers in the array to their right index
            if( (crt > -1 && crt < nums.length) && nums[crt] != nums[index]){
                // swap only if the positive number is in the array index range
                swap(nums, index, crt);
            }
            else{
                index++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        // all the 1-N positive number is there in the given array
        // return the next positive number that is not in the array!
        return nums.length + 1;
    }
}
