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

    // Easy Question

    // https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static int peakIndexInMountainArray(int[] arr){
        int start = 0; int end = arr.length - 1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                // you're in dsc part of the array
                // this maybe the ans, but look left once
                // this is why end != mid - 1
                end = mid;
            }
            else{
                // you're in asc part of the array
                // we know mid + 1 element > mid element
                start = mid + 1;
            }
        }
        // start == end
        // start and end are always trying to find the maximum element
        return start;
    }

    // Medium Question

    // https://leetcode.com/problems/find-peak-element/
    public int findPeakElement(int[] arr) {
        int start = 0; int end = arr.length - 1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if(arr[mid] > arr[mid + 1]){
                // you're in dsc part of the array
                // this maybe the ans, but look left once
                // this is why end != mid - 1
                end = mid;
            }
            else{
                // you're in asc part of the array
                // we know mid + 1 element > mid element
                start = mid + 1;
            }
        }
        // start == end
        // start and end are always trying to find the maximum element
        return start; 
    }
}
