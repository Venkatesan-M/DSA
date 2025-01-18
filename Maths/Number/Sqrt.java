package Number;


// Easy
// https://leetcode.com/problems/sqrtx/description/
public class Sqrt {
    public static void main(String[] args) {
        Sqrt solution = new Sqrt();
        
        // Test cases
        int[] testCases = {0, 1, 4, 8, 16, 25, 2147395599};
        
        System.out.println("Binary Search Method Results:");
        for (int x : testCases) {
            System.out.println("sqrt(" + x + ") = " + solution.mySqrt(x));
        }
        
        System.out.println("\nNewton-Raphson Method Results:");
        for (int x : testCases) {
            System.out.println("sqrt(" + x + ") = " + solution.sqrt(x));
        }
    }

    /**
     * Binary Search Method for Square Root
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * 
     * Key Concepts:
     * 1. Binary search works by repeatedly dividing search interval in half
     * 2. For a number x, its square root lies in range [1, x]
     * 3. To avoid integer overflow, we use division instead of multiplication
     * 4. We check if mid is the square root by ensuring:
     *    - mid ≤ x/mid (current number is small enough)
     *    - (mid + 1) > x/(mid + 1) (next number is too large)
     */
    public int mySqrt(int x) {
        // Handle base cases
        if (x == 0) return 0;
        
        // Initialize search range [1, x]
        int start = 1;
        int end = x;
        
        while (start <= end) {
            // Calculate middle point
            // Using (start + end) / 2 might cause overflow
            int mid = start + (end - start) / 2;
            
            // Check if mid is the square root
            // Using division instead of multiplication (mid * mid <= x) to avoid overflow
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
                return mid;
            }
            
            // If mid is too small, search in right half
            if (mid <= x / mid) {
                start = mid + 1;
            } 
            // If mid is too large, search in left half
            else {
                end = mid - 1;
            }
        }
        
        return end;
    }

    /**
     * Newton-Raphson Method for Square Root
     * Time Complexity: O(log n) - but converges faster than binary search
     * Space Complexity: O(1)
     * 
     * Mathematical Concept:
     * 1. To find sqrt(x), we need to find r where r² = x
     * 2. This is equivalent to finding root of f(r) = r² - x
     * 3. Newton's method formula: r_next = r - f(r)/f'(r)
     * 4. f'(r) = 2r
     * 5. Substituting: r_next = r - (r² - x)/(2r) = (r + x/r)/2
     * 
     * Advantages:
     * - Faster convergence than binary search
     * - More precise with floating-point arithmetic
     * - Fewer iterations needed
     */
    public int sqrt(int x) {
        // Handle base cases
        if (x == 0) return 0;
        if (x == 1) return 1;
        
        // Initialize variables
        double epsilon = 0.1;  // Desired precision
        double guess = x;      // Initial guess (can also use x/2 for optimization)
        
        // Apply Newton's method until desired precision is reached
        while (Math.abs(guess * guess - x) > epsilon) {
            guess = (guess + x/guess) / 2.0;
        }
        
        // Return floor value as per requirement
        return (int)guess;
    }
}