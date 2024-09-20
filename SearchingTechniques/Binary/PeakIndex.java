package SearchingTechniques.Binary;

public class PeakIndex {
    public static void main(String[] args) {
        // int[] arr = {0,1,0};
        // int[] arr = {0,2,1,0};
        // int[] arr = {3,5,3,2,0};
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
        int output = peakIndexInMountainArray(arr);
        System.out.println(output);
    }

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static int peakIndexInMountainArray(int[] arr) {
        return getTarget(arr);
    }

    public static int getTarget(int[] arr){
        int target = arr[0]; int ind = 0;
        int start = 0; int end = arr.length - 1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                target = arr[mid]; ind = mid;
                if(arr[mid] > arr[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(target > arr[mid]){
                if(arr[mid] < arr[end]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
                
            }
            else{
                return mid - 1;
            }
        }
        return ind;
    }

    public static int binarySearch(int arr[],  int target){
        int start = 0;
        int end = arr.length - 1;
        // int mid = (int) ((start + end)/2); // the (start + end) can exceed the Integer.MAX_VALUE
        // better way to find mid is start + (end - start)/2
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
