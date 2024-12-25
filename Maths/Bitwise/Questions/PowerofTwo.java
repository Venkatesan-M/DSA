package Bitwise.Questions;

// Easy
// https://leetcode.com/problems/power-of-two/description/
public class PowerofTwo {
    
    public boolean isPowerOfTwo(int n) {
        // A power of 2 must be greater than 0 and have only one bit set.
        // n = 8 (binary 1000):
        // n - 1 = 7 (binary 0111)
        // n & (n - 1) = 1000 & 0111 = 0000
        return n > 0 && (n & (n - 1)) == 0;
    }
}
