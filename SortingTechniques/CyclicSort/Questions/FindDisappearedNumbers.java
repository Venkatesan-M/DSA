package SortingTechniques.CyclicSort.Questions;

// Google Question
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
// Easy
import java.util.ArrayList;
import java.util.List;
// import java.util.Arrays;

public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {1,1};
        List<Integer> ans = findDisappearedNumbers(nums);
        System.out.print(ans);
    }
    
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1){
                if(nums[i] == nums[nums[i] - 1]){
                    // already correct item is there in pos or duplicates
                    break;
                }
                swap(nums, i, nums[i] - 1);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ans.add(i+1);
            }
        }
        return ans;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
