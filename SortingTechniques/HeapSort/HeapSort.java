import java.util.*;


class HeapSort{
    public static void main(String[] args){
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j]; arr[j] = temp;
    }

    static void heapSort(int[] arr){
        int n = arr.length;
        for(int i = n/2 - 1; i >=0; i--){
            heapify(arr, n, i);
        }
        for(int i = n - 1; i > 0; i--){
            swap(arr, i, 0);
            heapify(arr, i, 0);
        }
    }

    static void heapify(int[] arr, int n, int i){
        int lar = i;
        int l = 2 * i + 1; int r = l + 1;
        if(l < n && arr[l] > arr[lar]){
            lar = l;
        }
        if(r < n && arr[r] > arr[lar]){
            lar = r;
        }
        if(lar != i){
            swap(arr, i, lar);
            heapify(arr, n, lar);
        }
    }
}