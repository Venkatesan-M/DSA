package Bitwise;


public class BitwiseOperaters{
    public static void main(String[] args) {

        int n = 69;
        System.out.println(isOdd(n));

        // 6 alone doesn't have a pair in this array
        int arr[] = {2, 3, 4, 1, 2, 1, 3, 6, 4};
        
        // find the element which doesn't have the pair.
        int ans = findMissingTwin(arr);
        System.out.println(ans);
        
    }

    static int twosComplement(int n){
        // return the inverse of the 256 bits in INT
        // ~ 00000101 = 11111010 (5 -> 246)
        //  The 2’s complement of 246 is -6.
        return ~n;
    }

    // Unsigned Right shift operator (>>>)
    // Arithmetic shift 1011 >> 1  →  1101
    // Logical shift 1111 >>> 1  →  0111
    static int rightShiftNTimes(int num, int n){
        //  number shift_op number_of_places_to_shift;
        return num >> n;
    }

    static int leftShiftNTimes(int num, int n){
        //  number shift_op number_of_places_to_shift;
        return num << n;
    }

    static int AND(int num, int mask){
        return num & mask;
    }

    static int OR(int num, int mask){
        return num | mask;
    }

    static int XOR(int num, int mask){
        return num ^ mask;
    }

    static boolean isOdd(int n){
        // This checks the Least Significant bit of the Number
        return (n & 1) == 1;
    }

    static int NofDigits(int n){
        // get the number of digits in any base by the formulae
        // n = log(num) / log(base)
        return (int)(Math.log(n) / Math.log(2)) + 1;
    }

    static int findMissingTwin(int arr[]){
        int ans = 0; // a ^ 0 = a
        for(int i = 0; i < arr.length; i++){
            // a ^ a = 0 & a ^ 0 = a
            ans = ans ^ arr[i];
            // the twins will be club together and becomes 0.
        }
        return ans;
    }

    // Pascal's Triangle
    //     1 
    //    1 1
    //   1 2 1
    //  1 3 3 1
    // 1 4 6 4 1
    
    // get the sum of nth row

    static int pascalTriangleRowSum(int n){
        // sum of each row = nC0 + nC1 + nC2 + . . . + nCn = 2 ^ n - 1
        return 1 << (n - 1);
    }

    static boolean isNumberPowerOf2(int num) {
        // A power of 2 must be greater than 0 and have only one bit set.
        // num = 8 (binary 1000):
        // num - 1 = 7 (binary 0111)
        // num & (num - 1) = 1000 & 0111 = 0000
        return num > 0 && (num & (num - 1)) == 0;
    }

    // Calculating the Power operation in O(log(n)) instead of O(n)
    static int Expower(int base, int power){
        int ans = 1;

        while(power > 0){
            if((power & 1) == 1){
                ans = ans * base;
            }

            base = base * base;
            power = power >> 1;
        }

        return ans;
    }
    
}