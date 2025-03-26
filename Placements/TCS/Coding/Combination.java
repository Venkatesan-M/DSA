import java.util.Scanner;

public class Combination{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n1 = scan.nextInt();
        int n2 = scan.nextInt();

        int r1 = scan.nextInt();
        int r2 = scan.nextInt();

        System.out.println("Selecting only Pencil: "+combination(n1, r1));
        System.out.println("Selecting only Erasor: "+combination(n2, r2));

        System.out.println("Selecting Pencil and Erasor: "+ combination(n1, r1) * combination(n2, r2));
        scan.close();
    }

    static int combination(int n, int r){
        // formula ncr = ((n)!/(r)!*(n-r)!)
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    static int factorial(int n){
        int ans = 1;
        for(int i = 1; i <= n; i++){
            ans *= i;
        }
        return ans;
    }
}