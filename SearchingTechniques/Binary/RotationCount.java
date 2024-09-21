package SearchingTechniques.Binary;

public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2}; int target = 0;
        int output = countRotation(nums, target);
        System.out.println(output);
    }

    // a sorted array is rotated N times, fine the number of times it is rotated.
    public static int countRotation(int[] arr, int target){
        return findPivot(arr, target) + 1;
    }

    public static int findPivot(int[] arr, int target){
        // this won't work for duplicate values if it is in the array
        int start = 0; int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }else if(arr[mid] > arr[start]){
                start = mid + 1;
            }else if(arr[mid] <= arr[start]){
                end = mid - 1;
            }
        }
        return -1;
    }
}
