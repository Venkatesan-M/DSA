package SearchingTechniques.Binary;

public class RotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2}; int target = 3;
        int output = search(nums, target);
        System.out.println(output);
    }

    // https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public static int search(int[] arr, int target) {
        if(arr[0] == target){
            return 0;
        }
        if(arr.length - 1 == 0){
            return -1;
        }
        int pivot = findPivot(arr, target);
        if(pivot == -1){
            //normal binary search, elements is not rotated
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        if(arr[pivot] == target){
            return pivot;
        }
        if(arr[0] <= target){
            return binarySearch(arr, target, 0, pivot);
        }
        return binarySearch(arr, target, pivot + 1, arr.length - 1);

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

    public static int findPivotWithDuplicates(int[] arr, int target){
        // this work for duplicate values if it is in the array
        int start = 0; int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // Note: what if these elements at start and end are pivots??
                // check if start is pivot?
                if(arr[start] > arr[start + 1]){
                    return start;
                }

                start++; 
                
                //check if end is pivot??
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int arr[],  int target, int start, int end){
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
