package Recursion.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Searching {
    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(isSorted(sortedArr, 0));
        System.out.println(binarySearch(sortedArr, 0, sortedArr.length - 1, 5));
        System.out.println(linearSearch(sortedArr, 0, 5));

        int[] s = {1, 2, 3};
        List<List<Integer>> subsets = new ArrayList<>();
        getSubsets(s, 0, new ArrayList<>(), subsets);
        System.out.println(subsets.toString());

        int[] arr = {5, 6, 7, 8, 9, 1, 2, 3};
        System.out.println(search(arr, 7, 0, arr.length - 1));  // Should print 2
        System.out.println(search(arr, 1, 0, arr.length - 1));  // Should print 5
        System.out.println(search(arr, 4, 0, arr.length - 1));  // Should print -1
    }

    static boolean isSorted(int arr[], int i){
        // full array is checked
        if(i == arr.length - 1){
            return true;
        }
        // the array is not sorted
        else if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i + 1);
    }

    static int linearSearch(int[] arr, int i, int target){
        if(i == arr.length - 1){
            return -1;
        }
        if(arr[i] == target){
            return i;
        }
        return linearSearch(arr, i + 1, target);
    }

    static int binarySearch(int[] arr, int l, int r, int target) {
        // Base case: search space is empty
        if (l > r) {
            return -1;
        }

        int m = l + (r - l) / 2;  // Calculate middle index

        if (arr[m] == target) {
            return m;  // Found the target
        }
        
        if (arr[m] < target) {
            // Search in right half
            return binarySearch(arr, m + 1, r, target);
        } else {
            // Search in left half
            return binarySearch(arr, l, m - 1, target);
        }
    }

    static void getSubsets(int[] arr, int i, List<Integer> subset, List<List<Integer>> subsets) {
        // Base case: reached end of array
        if (i == arr.length) {
            // Create a new ArrayList to store the current subset
            subsets.add(new ArrayList<>(subset));
            return;
        }
    
        // Exclude current element
        getSubsets(arr, i + 1, subset, subsets);
        
        // Include current element
        subset.add(arr[i]);
        getSubsets(arr, i + 1, subset, subsets);
        
        // Backtrack: remove the element for the next iteration
        subset.remove(subset.size() - 1);
    }

        /**
     * Searches for target in a rotated sorted array using recursive binary search
     * Time Complexity: O(log n)
     * Space Complexity: O(log n) due to recursive stack
     */
    static int search(int[] arr, int target, int start, int end) {
        // Base case: element not found
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        // Found the target
        if (arr[mid] == target) {
            return mid;
        }

        // If left half is sorted
        if (arr[start] <= arr[mid]) {
            // Check if target lies in the left half
            if (target >= arr[start] && target <= arr[mid]) {
                // Search in left half
                return search(arr, target, start, mid - 1);
            } else {
                // Search in right half
                return search(arr, target, mid + 1, end);
            }
        }
        // If right half is sorted
        else {
            // Check if target lies in the right half
            if (target >= arr[mid] && target <= arr[end]) {
                // Search in right half
                return search(arr, target, mid + 1, end);
            } else {
                // Search in left half
                return search(arr, target, start, mid - 1);
            }
        }
    }
}
