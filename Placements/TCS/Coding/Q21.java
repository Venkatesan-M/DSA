public class Q21 {
    public static void main(String[] args) {
        int[] arr = {9, -3, 8, -6, -7, 8, 10};
        int max1 = arr[0]; int max2 = Integer.MIN_VALUE;
        for(int i : arr){
            if(max1 < i){
                max2 = max1;
                max1 = i;
            }
        }
        System.out.println(max1 + max2);
    }
}
