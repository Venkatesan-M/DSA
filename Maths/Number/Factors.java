package Number;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Factors {
    public static void main(String[] args) {
        int n = 20;
        int[] ans = getFactors(n);
        System.out.println(Arrays.toString(ans));  
    }

    static int[] getFactors(int n){
        List<Integer> temp = new ArrayList<>();
        // i < Math.sqrt(n)
        for(int i = 1; i * i < n; i++){
            if(n % i == 0){
                temp.add(i);
                // to avoid duplicates
                if(n / i != i){
                    temp.add(n / i);
                }
            }
        }
        temp.sort(null);
        int[] ans = new int[temp.size()]; int j = 0;
        for(int i : temp){
            ans[j] = i;
            j++;
        }
        return ans;
    }

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        // a * b = HFC * LCM
        return a * b / gcd(a, b);
    }
}
