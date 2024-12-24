package SortingTechniques.CyclicSort;

import java.util.Arrays;


public class CyclicSort {
    public static void main(String args[]){
        // the given array of size N contain 1-N natural numbers
        int[] arr = {3, 5, 2, 1, 4};
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void cyclicSort(int arr[]){
        int index = 0;
        while(index < arr.length){
            int correctPosition = arr[index] - 1;
            if(arr[index] != arr[correctPosition]){
                swap(arr, index, correctPosition);
            }
            else{
                index++;
            }
        }
    }
}