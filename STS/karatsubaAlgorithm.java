package STS;

public class karatsubaAlgorithm {
    public static void main(String[] args) {

        long x = 123456789;
        long y = 987654321;
        long result = karatsuba(x, y);
        System.out.println("Result: " + result);
    }

    public static long karatsuba(long x, long y) {
        // Base case for recursion
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Calculate the maximum length of the two numbers
        int maxLength = Math.max(Long.toString(x).length(), Long.toString(y).length());
        int halfLength = maxLength / 2;

        // Split the numbers based on half length
        long power = (long) Math.pow(10, halfLength);

        long a = x / power;
        long b = x % power;
        long c = y / power;
        long d = y % power;

        // Recursively calculate three products
        long z0 = karatsuba(b, d);
        long z1 = karatsuba(a + b, c + d);
        long z2 = karatsuba(a, c);

        // Combine the results using Karatsuba's formula
        return (z2 * (long) Math.pow(10, 2 * halfLength)) + 
               ((z1 - z2 - z0) * (long) Math.pow(10, halfLength)) + 
               z0;
    }
}
