package STS;

import java.util.*;

public class euclidsAlgorithm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = input.nextInt();
        int num2 = input.nextInt();
        int gcdNum = greatestCommonDivisor(num1, num2);
        System.out.println(gcdNum);
        input.close();
    }
    public static int greatestCommonDivisor(int a, int b){
        if(b==0){
            return a;
        }
        return greatestCommonDivisor(b, a%b);
    }
}
