package SortingTechniques.CyclicSort.Questions;

// amazon Question
// https://leetcode.com/problems/find-the-duplicate-number/
// Medium

public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        int ans = findDuplicate(nums);
        System.out.println(ans);
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int findDuplicate(int[] nums) {
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
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return nums[i];
            }
        }
        return -1;
    }
}
