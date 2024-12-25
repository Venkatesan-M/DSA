package Bitwise.Questions;

public class FlipImage {
    public static void main(String[] args) {
        
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // https://leetcode.com/problems/flipping-an-image/
    // Easy

    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        for(int i = 0; i < n; i++){
            int j = 0; int k = n - 1;
            // Flipping the array
            // two pointer
            while(j < k){
                swap(image[i], j, k);
                // inverting the bits
                image[i][j] = (image[i][j] & 1) ^ 1;
                image[i][k] = (image[i][k] & 1) ^ 1;
                j++; k--;
            }
            if(j == k){
                // inverting the middle bit if it is present 
                // (as it didn't take part in flipping)
                image[i][k] = (image[i][k] & 1) ^ 1;
            }
        }
        return image;
    }
}
