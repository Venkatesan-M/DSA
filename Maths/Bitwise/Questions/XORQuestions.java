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
    // Medium
    // https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n = 0; int n1 = nums1.length; int n2 = nums2.length;
        // if the length of any array is even, it will make pairs in 2 array combination.
        //nums1[0] ^ nums2[0], nums1[0] ^ num [1], 
        // nums1[1] ^ nums2[0], and nums1[1] ^ nums2[1].
        // here both are even so both cancel out
        if((n1 & 1) == 1){
            // consider the array values if the mapped array size is old
            // because that will give only one combination
            for(int i : nums2){
                n = n ^ i;
            }
        }
        if((n2 & 1) == 1){
            for(int i : nums1){
                n = n ^ i;
            }
        }
        return n;
    }

    // https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/
    // Easy
    public int subsetXORSum(int[] nums) {
        return getXorTotal(nums, 0, 0);
    }

    static int getXorTotal(int[] arr, int i, int total) {
        if (i == arr.length) {
            return total; // Return the XOR total of the current subset.
        }
        // Accumulate the results using addition.
        return getXorTotal(arr, i + 1, total ^ arr[i]) // Include the current element.
                + getXorTotal(arr, i + 1, total);     // Exclude the current element.
    }

    // https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
    // Medium
    public int countTriplets(int[] arr) {
        int n = arr.length; int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j; k < n; k++){
                    if(getXor(arr , i, j - 1) == getXor(arr , j, k)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    static int getXor(int[] arr, int a, int b){
        int r = 0;
        for(int i = a; i < b + 1; i++){
            r = r ^ arr[i];
        }
        return r;
    }

    // https://leetcode.com/problems/find-the-original-array-of-prefix-xor/description/
    // Medium
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n]; arr[0] = pref[0];
        // pref[i] = arr[0]^...^arr[i]
        // pref[i-1] = arr[0]^...$arr[i-1]
        // we know pairs in ^ will cancel out
        for(int i = 1; i < n; i++){
            // pref[i-1]^pref[i] -> 
            // (arr[0]^arr[0])^...^(arr[n-1]^arr[n-1]) this will come out as 0
            // arr[i] only be left out, as arr[i]^0 = arr[i]
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }
}
