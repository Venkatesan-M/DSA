package SearchingTechniques.Binary;

public class MAIN {
    public static void main(String args[]){
        System.out.println();
        int arr[] = {0,1,2,3,4,5,6,7,8,9};
        // int arr[] = {9,8,7,6,5,4,3,2,1,0};
        int target = 3;
        int ans = orderAgnosticBinarySearch(arr, target);
        System.out.println(ans);
    }

    public static int binarySearchInc(int arr[],  int target){
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

    public static int binarySearchDsc(int arr[],  int target){
        int start = 0;
        int end = arr.length - 1;
        // int mid = (int) ((start + end)/2); // the (start + end) can exceed the Integer.MAX_VALUE
        // better way to find mid is start + (end - start)/2
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target > arr[mid]){
                end = mid - 1;
            }
            else if (target < arr[mid]){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }

    public static int orderAgnosticBinarySearch(int arr[], int target){
        // we don't know in which order the input arr is sorted, here we compare 1st and last element
        // of the array
        int start = 0;
        int end = arr.length - 1;
        // int mid = (int) ((start + end)/2); // the (start + end) can exceed the Integer.MAX_VALUE
        // better way to find mid is start + (end - start)/2
        boolean isAsc = arr[start] < arr[end];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(target == arr[mid]){
                return mid;
            }
            else if(isAsc){
                if(target < arr[mid]){
                    end = mid - 1;
                }
                else if (target > arr[mid]){
                    start = mid + 1;
                }
            }
            else{
                if(target > arr[mid]){
                    end = mid - 1;
                }
                else if (target < arr[mid]){
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

}
