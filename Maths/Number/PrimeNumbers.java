package Number;

public class PrimeNumbers {
    public static void main(String[] args) {
        int n = 1331;
        System.out.println(isPrimeNumber(n));
        sieveOfEratosthenes(n);
        
    }

    static boolean isPrimeNumber(int n){
        if(n <= 1){
            // 1 is neither prime nor composite
            return false;
        }
        // i * i < n is same as i < sqrt(n)
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static void sieveOfEratosthenes(int n){
        // all the values in the initial array is false
        boolean isPrime[]= new boolean[n];
        // assume all the elements in the array to be prime
        // a.k.a true
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= n; i++){
            if(isPrime[i]){
                // if the number is prime
                for(int j = 2 * i; j < n; j = j + i){
                    // set it's multiple of that number to be not prime
                    isPrime[j] = false;
                }
                
            }
        }
        System.out.print("[");
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                System.out.printf("%d, ", i);
            }
        }
        System.out.print("]");
    }

    
    // Medium
    // https://leetcode.com/problems/count-primes
    public int countPrimes(int n) {
        if(n < 2){
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        for(int i = 2; i < n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i * i < n; i++){
            if(isPrime[i]){
                for(int j = 2 * i; j < n; j = j + i){
                    isPrime[j] = false;
                }
            }
        }
        int c = 0;
        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                c++;
            }
        }
        return c;
    }
}
