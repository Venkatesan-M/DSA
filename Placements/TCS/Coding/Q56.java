import java.util.*;

public class Q56 {
    public static void main(String[] args) {
        int n = 34201;
        int len = (int)Math.log10(n) + 1;
        int[] arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = n % 10;
            n /= 10;
        }
        if(arr[0] == 0) swap(arr, 0, 1);
        int ans = 0;
        for(int i = 0; i < len; i++){  
            ans = ans * 10 + arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
