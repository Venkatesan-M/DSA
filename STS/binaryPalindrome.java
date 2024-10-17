package STS;

import java.util.*;

public class binaryPalindrome{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if(isBinaryPalindrome(num)){
            System.out.println("Given Number is Binary Palindrome");
        }else{
            System.out.println("Given Number is not a Binary Palindrome");
        }
        input.close();
    }
    public static boolean isBinaryPalindrome(int num){
        String binaryString = Integer.toBinaryString(num);
        int start = 0; int end = binaryString.length() - 1;
        while(start < end){
            if(binaryString.charAt(start)!=binaryString.charAt(end)){
                return false;
            }
            start++; end--;
        }
        return true;
    }
}