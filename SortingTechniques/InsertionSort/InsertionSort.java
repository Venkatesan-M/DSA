package SortingTechniques.InsertionSort;

import java.util.Arrays;


public class InsertionSort {
    public static void main(String args[]){
        int[] arr = {3, 2, 5, 7, 1, 8, 9};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int arr[]){
        int n = arr.length;
        for( int i = 1; i < n - 1; i++){
            int j = i - 1;
            int temp = arr[i];
            while( j > -1 && temp < arr[j] ){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }
}
