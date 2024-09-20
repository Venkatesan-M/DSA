package SearchingTechniques.Binary;

public class Examples {
    public static void main(String args[]){
        System.out.println();
        int arr[] = {0,1,4,7,8,16,27};
        // int arr[] = {9,8,7,6,5,4,3,2,1,0};
        int target = 15;
        int ans = floorNumber(arr, target);
        System.out.println(ans);
    }

    // https://youtu.be/f6UU7V3szVw?si=7rI4ZfIGl5KrCf5J
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

    // the smallest number which is greater or equal to the target
    public static int ceilingNumber(int arr[], int target){
        if(target > arr[arr.length - 1]){
            // if the target number is the largest number 
            return -1;
        }
        int start = 0; int end = arr.length - 1; int mid = start + (end - start) /2 ;
        while(start <= end){
            mid = start + (end - start) /2 ;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                return arr[mid];
            }
        }
        return arr[start];
    }

    // the greatest number which is smaller or equal to the target
    public static int floorNumber(int arr[], int target){
        if(target < arr[0]){
            return -1;
        }
        int start = 0; int end = arr.length - 1; int mid = start + (end - start) /2 ;
        while(start <= end){
            mid = start + (end - start) /2 ;
            if(target < arr[mid]){
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else{
                return arr[mid];
            }
        }
        return arr[end];
    }
}
