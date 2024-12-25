package Bitwise.Questions;

public class XORQuestions {
    public static void main(String[] args) {
        
    }

    static int xor(int a){
        // calculates the XOR operations of a natural numbers
        if (a % 4 == 0) {
            return a;
        }
        if (a % 4 == 1){
            return 1;
        }
        if(a % 4 == 2){
            return a + 1;
        }
        return 0;
    }

    static int xorRange(int a, int b){
        // range xor for a, b = xor(b) ^ xor(a-1)
        return xor(b) ^ xor(a-1); 
    }

    
    // Easy
    // https://leetcode.com/problems/xor-operation-in-an-array/
    public int xorOperation(int n, int start) {
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = ans ^ (start + 2 * i);
        }
        return ans;
    }

    // https://leetcode.com/problems/xor-queries-of-a-subarray/
    // Medium
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int j = queries[i][0]; int k = queries[i][1];
            int a = 0;
            while(j <= k){
                a = a ^ arr[j];
                j++;
            }
            ans[i] = a;
        }
        return ans;
    }
}
