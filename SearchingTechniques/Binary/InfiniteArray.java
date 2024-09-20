package SearchingTechniques.Binary;

// https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=5701s
public class InfiniteArray{
    public static void main(String[] args) {

        int[] infiniteArr = {0,3,5,7,9,11,13,17,19,23,29,31,37,41,43,47,53,57,59,61,67,71,73,79,83,87,89,91,93,97};
        int target = 67;
        int result = infiniteArray(infiniteArr, target);
        System.out.println(result);
    }

    static int infiniteArray(int[] arr, int target){
        // start with the box of size 2
        int start = 0; int end = 1;

        // condition for the target to lie in range
        while(target > arr[end]){
            int newStart = end + 1;
            // double the box value
            // end = prevEnd + twice the length of the Box;
            end = end + ( end - start + 1) * 2;
            start = newStart;
        }

        return infiniteArrayBinarySearch(arr, target, start, end);
    }

    public static int infiniteArrayBinarySearch(int arr[],  int target, int start, int end){
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