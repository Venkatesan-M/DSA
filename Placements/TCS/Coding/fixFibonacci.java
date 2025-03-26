import java.util.Arrays;

public class fixFibonacci {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4, 9, 11, 18};
        int fix = 0;
        for(int i = 2; i < arr.length; i++){
            int correctVal = arr[i-1] + arr[i-2];
            if(arr[i] != correctVal){
                fix++;
                arr[i] = correctVal;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(fix);
    }
}
