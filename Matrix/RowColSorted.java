import java.util.Arrays;

public class RowColSorted {
    public static void main(String[] args) {
        // Matrix is sorted in row wise and column wise
        int[][] matrix = {
            {10, 20, 30, 40},
            {11, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        int[] res = searchMatrix(matrix, 20);
        System.out.print(Arrays.toString(res));
    }

    public static int[] searchMatrix(int[][] matrix, int target){
        int rows = 0;
        int columns = matrix[0].length - 1;
        while(rows < matrix.length && columns !=-1 ){
            int lb = matrix[rows][columns];
            if(target < lb){
                columns--;
            }
            else if(target > lb){
                rows++;
            }
            else{
                return new int[] {rows,columns};
            }
        }
        return new int[] {-1,-1};
    }
}