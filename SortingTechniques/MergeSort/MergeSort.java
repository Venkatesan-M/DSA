package SortingTechniques.MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
<<<<<<< HEAD
        int[] arr = {-1, 2, -3, 1, 5, 6, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
    // Medium
    // https://leetcode.com/problems/sort-an-array/description/
=======
        int[] arr = {5,2,4,3,1,6,7,8,9,0};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

>>>>>>> 0de712f9155907db2f79df1495931df1cc6228c6
    static void mergeSort(int[] arr, int l, int r){
        if (l < r){
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1; int n2 = r - m; 
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l+i];
        }
        for(int j = 0; j < n2; j++){
            R[j] = arr[m+1+j];
        }
        int i = 0; int j = 0; int k = l;
        while(i < n1 && j < n2){
            if(L[i]<=R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while(i < n1){
            arr[k++] = L[i++];
        }
        while(j < n2){
            arr[k++] = R[j++];
        }
    }
    
<<<<<<< HEAD
}
=======
    public int[] sortArray(int[] nums) {
        if(nums.length < 2){
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        
        return forge(left, right);
	}

	static int[] forge(int[] left, int[] right){
	    int[] mix = new int[left.length + right.length];
	    int i = 0; int j = 0; int k = 0;
	    while(i < left.length && j < right.length){
	        if(left[i] < right[j]){
	            mix[k++] = left[i++];
	        }else{
	            mix[k++] = right[j++];
	        }
	    }
	    while(i < left.length){
	        mix[k++] = left[i++];
	    }
	    while(j < right.length){
	        mix[k++] = right[j++];
	    }
	    return mix;
	}
}
>>>>>>> 0de712f9155907db2f79df1495931df1cc6228c6
