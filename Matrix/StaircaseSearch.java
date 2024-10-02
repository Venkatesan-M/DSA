import java.util.Arrays;


public class StaircaseSearch {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        int[] res = search(matrix, 2);
        System.out.print(Arrays.toString(res));
    }

    // Time Complexity -> n + m
    public static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from top-right corner
        int row = 0;
        int col = cols - 1;

        // "Staircase Search" logic
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return new int[] {row, col};  // Target found
            } else if (matrix[row][col] > target) {
                col--;  // Move left
            } else {
                row++;  // Move down
            }
        }

        // Target not found
        return new int[] {-1, -1};
    }
}
