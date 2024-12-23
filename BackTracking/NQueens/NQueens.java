package BackTracking.NQueens;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        int n = 4; // For example
        List<List<String>> solutions = solveNQueens(n);
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int row, int col, List<String> board, int n) {
        // Check the upper-left diagonal, current column, and upper-right diagonal

        // Check left side in the same row (no need to check below the current row, since we're placing queens row-wise)
        for (int i = col; i >= 0; i--) {
            if (board.get(row).charAt(i) == 'Q') {
                return false;
            }
        }

        // Check the upper-left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        // Check the lower-left diagonal
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void backTrackNQueens(int col, List<String> board, List<List<String>> ans, int n) {
        if (col == n) {
            ans.add(new ArrayList<>(board));  // Make a deep copy of the board
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(row, col, board, n)) {
                // Place a queen on the board
                String str = board.get(row);
                str = str.substring(0, col) + 'Q' + str.substring(col + 1);
                board.set(row, str);

                // Recurse to place the rest of the queens
                backTrackNQueens(col + 1, board, ans, n);

                // Backtrack: remove the queen from the board
                str = board.get(row);
                str = str.substring(0, col) + '.' + str.substring(col + 1);
                board.set(row, str);
            }
        }
    }

    // 51 Hard
    // https://leetcode.com/problems/n-queens/description/
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();  // Initialize the answer list
        List<String> board = new ArrayList<>();
        String col = ".".repeat(n);

        for (int i = 0; i < n; i++) {
            board.add(col);  // Create an empty board
        }

        backTrackNQueens(0, board, ans, n);
        return ans;
    }
}
