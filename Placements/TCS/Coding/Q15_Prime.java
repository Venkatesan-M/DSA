import java.util.*;

public class Q15_Prime {
    public static void main(String[] args) {
        int N = 50;
        int a = 20;
        int b = 2;
        int c = 9;
        int d = 28;
        Set<Integer> ans = new HashSet<>();
        for(int i = 1; i < N; i++){
            int s1 = An(b, a, i);
            int s2 = An(d, c, i);
            if(ans.contains(s1)){
                System.out.println(s1);
                break;
            }
            if(ans.contains(s2)){
                System.out.println(s2);
                break;
            }
            ans.add(s1);
            ans.add(s2);
        }
    }

    static int An(int a, int d, int n){
        return a + (n-1) * d;
    }
}
