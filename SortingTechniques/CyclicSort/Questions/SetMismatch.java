package SortingTechniques.CyclicSort.Questions;

import java.util.Arrays;

// https://leetcode.com/problems/set-mismatch/
// Easy

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] ans = findErrorNums(nums);
        System.out.println(Arrays.toString(ans));  
                
    }
            
    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        
    public static int[] findErrorNums(int[] nums) {
        int index = 0;
        while(index < nums.length){
            int crt = nums[index] - 1;
            if(nums[crt] != nums[index]){
                swap(nums, index, crt);
            }
            else{
                index++;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return new int[] {nums[i], i+1};
            }
        }
        return new int[] {-1, -1};
    }
}
