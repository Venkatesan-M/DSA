import java.util.Arrays;


public class BinarySearch {
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

    // Time Complexity -> log(n) + log(m)
    public static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart) / 2;
            if(matrix[row][mid]==target){
                return new int[] {row, mid};
            }
            else if (matrix[row][mid] < target){
                cStart = mid + 1;
            }
            else{
                cEnd = mid - 1;
            }
        }
        return new int[] {-1,-1};
    }

    public static int[] search(int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if(rows == 1){
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }
        int rStart = 0; int rEnd = rows - 1; int cMid = cols / 2;

        while(rStart < (rEnd - 1)) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if(matrix[rMid][cMid] == target){
                return new int[] {rMid, cMid};
            }
            else if (matrix[rMid][cMid] < target){
                rStart = rMid;
            }else{
                rEnd = rMid;
            }
        }
        
        if(matrix[rStart][cMid] == target){
            return new int[] {rStart, cMid};
        }
        else if(matrix[rStart + 1][cMid] == target){
            return new int[] {rStart + 1, cMid};
        }
        // search in 1st half
        if (target <= matrix[rStart][cMid - 1]){
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }
        // search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]){
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }
        // search in 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]){
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        // search in 4th half
        else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }    
}
