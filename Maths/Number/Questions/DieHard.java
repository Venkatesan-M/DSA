package Number.Questions;

public class DieHard {
    public static void main(String[] args) {
        
    }

    // Medium
    // https://leetcode.com/problems/water-and-jug-problem/
    public boolean canMeasureWater(int x, int y, int target) {
        // Handle edge cases
        if (target < 0) return false;
        if (target == 0) return true;
        if (x + y < target) return false;
        
        // If either jug is 0, target must be divisible by the non-zero jug
        if (x == 0) return y == target;
        if (y == 0) return x == target;
        
        // Check if target is divisible by GCD of x and y
        int fac = gcd(x, y);
        return target % fac == 0;
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
