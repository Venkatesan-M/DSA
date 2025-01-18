package Recursion.Arrays;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -3, 1, 5, 6, 10};
        selectionSort(arr, 0, 0, 0);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr, int pass ,int row){
        if(pass == arr.length - 1 || arr.length == 0){
            return;
        }
        if(row < arr.length - 1 - pass){
            if(arr[row] > arr[row + 1]){
                swap(arr, row, (row + 1));
            }
            bubbleSort(arr, pass, row + 1);
        }
        else{
            bubbleSort(arr, pass + 1, 0);
        }
    }

    static void selectionSort(int[] arr, int pass, int row, int maxIndex){
        if(pass == arr.length - 1 || arr.length == 0){
            return;
        }
        if(row == arr.length - pass){
            swap( arr, maxIndex, arr.length - pass - 1);
        }
        if(row < arr.length - pass){
            if(arr[row] > arr[maxIndex]){
                maxIndex = row;
            }
            selectionSort(arr, pass, row + 1, maxIndex);
        }else{
            selectionSort(arr, pass + 1, 0, 0);
        }
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
