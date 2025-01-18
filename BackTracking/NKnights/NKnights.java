package BackTracking.NKnights;

import java.util.*;

public class NKnights {
    public static void main(String[] args) {
        List<List<String>> ans = solveNKnights(4);
        for (List<String> board : ans) {
            for (String line : board) {
                System.out.println(line);
            }
            System.out.println();
        }
    }

    static boolean isSafe(List<String> board, int row, int col) {
        int n = board.size();
        
        // Check all 8 possible knight moves for safety
        int[] rowMoves = {-2, -2, -1, -1};
        int[] colMoves = {-1, 1, -2, 2};

        for (int i = 0; i < rowMoves.length; i++) {
            int newRow = row + rowMoves[i];
            int newCol = col + colMoves[i];
            if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n) {
                if (board.get(newRow).charAt(newCol) == '$') {
                    return false;
                }
            }
        }
        return true;
    }

    static void backTrackNKnights(List<String> board, List<List<String>> ans, int row, int col, int knights) {
        int n = board.size();
        
        if (knights == 0) {
            // Add a deep copy of the board to the answer
            ans.add(new ArrayList<>(board));
            return;
        }
        
        if (row >= n) return;

        // Move to the next row if column exceeds the board size
        if (col >= n) {
            backTrackNKnights(board, ans, row + 1, 0, knights);
            return;
        }

        // Try placing a knight if it is safe
        if (isSafe(board, row, col)) {
            String initial = board.get(row);
            board.set(row, initial.substring(0, col) + "$" + initial.substring(col + 1));
            backTrackNKnights(board, ans, row, col + 1, knights - 1); // Move to the next column
            board.set(row, initial); // Backtrack
        }

        // Try without placing a knight
        backTrackNKnights(board, ans, row, col + 1, knights);
    }

    static List<List<String>> solveNKnights(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        
        // Initialize the board with empty positions
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }
        
        backTrackNKnights(board, ans, 0, 0, n);
        return ans;
    }
}
