package BackTracking.NKnights;

import java.util.*;

public class Nknights {
    public static void main(String[] args) {
        List<List<String>> ans = solveNKnights(4);
        for(int i = 0; i < ans.size(); i++){
            List<String> board = ans.get(i);
            System.out.println(board);
            System.out.println();
        }
    }

    static boolean isSafe(List<String> board, int row, int col){
        if(row - 2 >= 0){
            String line = board.get(row - 2);
            if(col - 1 >= 0 && line.charAt(col - 1) == '$'){
                return false;
            }
            if(col + 1 < board.size() && line.charAt(col + 1) == '$'){
                return false;
            }
        }
        if(row - 1 >= 0){
            String line = board.get(row - 1);
            if(col - 2 >= 0 && line.charAt(col - 2) == '$'){
                return false;
            }
            if(col + 2 < board.size() && line.charAt(col + 2) == '$'){
                return false;
            }
        }

        return true;
    }

    static List<List<String>> backTrackNKnights(List<String> board, List<List<String>> ans, int row, int col, int knights){
        if(knights == 0){
            ans.add(board);
            return ans;
        }
        if(isSafe(board, row, col)){
            String intial = board.get(row);
            String update = intial.substring(0, col) + "$" + intial.substring(col+1);
            board.set(row, update);
            if(col < board.size() - 1){
                ans.addAll(backTrackNKnights(board, ans, row, col + 1, knights - 1));
            }else{
                ans.addAll(backTrackNKnights(board, ans, row + 1, 0, knights - 1));
            }
            board.set(row, intial);
        }else{
            if(col < board.size() - 1){
                ans.addAll(backTrackNKnights(board, ans, row, col + 1, knights - 1));
            }else{
                ans.addAll(backTrackNKnights(board, ans, row + 1, 0, knights - 1));
            }
        }
        return ans;
    }

    static List<List<String>> solveNKnights(int n){
    List<List<String>> ans = new ArrayList<>();
    List<String> board = new ArrayList<>();
    for(int i = 0; i < n; i++){
        char[] row = new char[n];
        Arrays.fill(row, '.');
        board.add(new String(row));
    }
    return backTrackNKnights(board, ans, 0, 0, n);
}

}
