import java.util.Scanner;

public class pizza {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int flavors = input.nextInt();
        int k = input.nextInt();
        int[] pizza = new int[flavors];
        for(int i = 0; i < flavors; i++){
            pizza[i] = input.nextInt();
        }
        System.out.println(distinct(pizza, k));
        input.close();
    }
    static int distinct(int[] arr, int k){
        int l , r; l = r = 0; int ans = 0;
        int lk = 0;
        while(r < arr.length && l < arr.length){
            if(arr[l] == arr[r]){
                lk += arr[r];
                r++;
            }else{
                if(lk <= k)
                    ans = Math.max(ans, r - l);
                l = r;
            }
        }
        return ans;
    }
}
