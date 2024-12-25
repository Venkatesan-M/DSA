package Bitwise.Questions;

public class NumofSetbits {
    public static void main(String[] args) {
        int n = 2147483645;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(hammingWeight(n));
    }

    // Easy
    // https://leetcode.com/problems/number-of-1-bits/

    public static int hammingWeight(int n) {
        int count = 0;
        // 1st n = 1001 -> n - 1 = 1000, (n & (n - 1)) -> 1000 -> n (counted once)
        // 2nd n = 1000 -> n - 1 = 0111 -> (n & (n - 1)) -> 0 -> n (Terminated)
        // therefore the answer is 2 (count) 

        while(n > 0){
            count++;
            n = n & (n - 1);
        }

        return count;
    }
}
