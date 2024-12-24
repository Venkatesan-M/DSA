package SortingTechniques.CyclicSort.Questions;

import java.util.ArrayList;
import java.util.List;

// microsoft Question
// https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
// Medium


public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> ans = findDuplicates(nums);
        System.out.print(ans);
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int index = 0;
        while(index < nums.length){
            int crtpos = nums[index] - 1;
            if(nums[crtpos] != nums[index]){
                swap(nums, index, crtpos);
            }
            else{
                index++;
            }
        }
        for(int i = nums.length - 1; i > -1; i--){
            if(nums[i] != i + 1){
                ans.add(nums[i]);
            }
        }
        return ans;
    }
}
