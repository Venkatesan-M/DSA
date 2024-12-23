package SortingTechniques.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String args[]){
        int[] arr = {3, 2, 5, 7, 1, 8, 9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int arr[]){
        int n = arr.length;
        for(int i = 0; i < n - 1; i++){
            boolean isSorted = true;
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // swapping happened
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
