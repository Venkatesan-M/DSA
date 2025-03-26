public class Q60 {
    public static void main(String[] args) {
        int n = -4512;
        boolean negative = false;
        if(n < 0){
            negative = true;
            n *= -1;
        }
        int ans = 0;
        while(n > 0){
            ans = 10 * ans + n % 10;
            n = n / 10;
        }
        if(negative) ans *= -1;
        System.out.println(ans);
    }
}
