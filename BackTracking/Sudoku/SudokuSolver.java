package BackTracking.Sudoku;

import java.util.*;

// Hard
// https://leetcode.com/problems/sudoku-solver/description/

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        for(int i = 0; i < board.length; i++){
            System.out.println(Arrays.toString(board[i]));
        }

    }

    static boolean isSafe(char[][] board, int row, int col, int num){
        // Column Check
        for(int i = 0; i < board.length; i++){
            if(board[i][col] - '0' == num){
                return false;
            }
        }
        // Row Check
        for(int j = 0; j < board[0].length; j++){
            if(board[row][j] - '0' == num){
                return false;
            }
        }
        int gridRow = row - row % 3; int gridCol = col - col % 3;
        for(int i = gridRow; i < gridRow + 3; i++){
            for(int j = gridCol; j < gridCol + 3; j++){
                if(board[i][j] - '0' == num){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean backTrackSudoku(char[][] board, int ROW, int COL) {
        if (ROW == board.length) return true; // Solution found
        if (COL == board[0].length) return backTrackSudoku(board, ROW + 1, 0);
        if (board[ROW][COL] != '.') return backTrackSudoku(board, ROW, COL + 1);
    
        for (int i = 1; i < 10; i++) {
            if (isSafe(board, ROW, COL, i)) {
                board[ROW][COL] = (char) ('0' + i);
                if (backTrackSudoku(board, ROW, COL + 1)) return true; // Stop further recursion
                board[ROW][COL] = '.'; // Undo
            }
        }
        return false; // No solution found for this path
    }

    public static void solveSudoku(char[][] board) {
        backTrackSudoku(board, 0, 0);
        return;
    }
}
