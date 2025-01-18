package SortingTechniques.QuickSort;

import java.util.*;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4, 6, 7, 8, 9, 10};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int s = l; int e = r;
            int pivot = s + (e - s) / 2;

            while(s<=e){
                while(arr[pivot] > arr[s]){
                    s++;
                }
                while(arr[pivot] < arr[e]){
                    e--;
                }
                if(s<=e){
                    swap(arr, s, e);
                    s++;
                    e--;
                }
            }
            quickSort(arr, l, e);
            quickSort(arr, s, r);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
