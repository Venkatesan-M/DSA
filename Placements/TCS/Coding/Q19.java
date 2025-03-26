public class Q19 {
    public static void main(String[] args) {
        int n = 5;
        int fac = factorial(n);
        int ans = 0;
        while(fac > 0 && ans == 0){
            ans = fac % 10;
            fac = fac / 10;
        }
        System.out.println(ans);
    }

    static int factorial(int n){
        if(n == 1 || n == 0) return 1;
        return n * factorial(n-1);
    }
}
