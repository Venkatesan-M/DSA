package DynamicProgramming.Grids;

public class Square {
    
    // https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] squares = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0) squares[i][j] = matrix[i][j];
                else if(matrix[i][j] == 0) squares[i][j] = 0;
                else{
                    int top = squares[i][j-1], left = squares[i-1][j], dia = squares[i-1][j-1];
                    if(left == top && top == dia){
                        squares[i][j] = left + 1;
                    }else{
                        squares[i][j] = Math.min(top, Math.min(dia, left)) + 1;
                    }
                }
            }
        }
        int ans = 0;
        for(int[] sq : squares){
            for(int s : sq) ans+=s;
        }
        return ans;
    }
}
