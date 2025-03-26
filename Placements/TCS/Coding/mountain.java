// import java.util.Scanner;

public class mountain {
    public static void main(String[] args) {
        // Scanner input = new Scanner(System.in);
        // int n = input.nextInt();
        // int i = input.nextInt();
        // int x = input.nextInt();
    }

    static int countClimingWays(int n, int i, int x){
        int[] ways = new int[n + 1];
        ways[i] = 1;
        ways[i-1] = 1;
        for(i = i + 1; i <= n; i++){
            ways[i] = 0;
            for(int j = 1; j <=x & i-j >=1; j++){
                ways[j] += ways[i-j]; 
            }
        }
        return ways[n];
    } 
}
