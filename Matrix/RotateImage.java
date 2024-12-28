
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
            {5,1,9,11},
            {2,4,8,10},
            {13,3,6,7},
            {15,14,12,16}};

        rotate(matrix);
        for(int[] arr: matrix){
            for(int i: arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    // Medium
    // https://leetcode.com/problems/sort-an-array
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Loop through each layer of the matrix
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                // Save the top element
                int top = matrix[first][i];

                // Move left to top
                matrix[first][i] = matrix[last - offset][first];

                // Move bottom to left
                matrix[last - offset][first] = matrix[last][last - offset];

                // Move right to bottom
                matrix[last][last - offset] = matrix[i][last];

                // Move top to right
                matrix[i][last] = top;
            }
        }
    }
}