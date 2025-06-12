package DataStructures.Graphs.Learning;

import java.util.*;

class MutliSourceDFS {

  // https://leetcode.com/problems/surrounded-regions/
  int m, n;
  int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  public void solve(char[][] board) {
      m = board.length; n = board[0].length;
      boolean[][] visited = new boolean[m][n];
      for(int i = 1; i < n-1; i++){
          if(board[0][i] == 'O' && !visited[0][i]) dfs(0, i, board, visited);
          if(board[m - 1][i] == 'O' && !visited[m - 1][i]) dfs(m-1, i, board, visited);
      }
      for(int i = 0; i < m; i++){
          if(board[i][0] == 'O' && !visited[i][0]) dfs(i, 0, board, visited);
          if(board[i][n - 1] == 'O' && !visited[i][n - 1]) dfs(i, n - 1, board, visited);
      }
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(!visited[i][j] && board[i][j] == 'O'){
                  board[i][j] = 'X';
              }
          }
      }
  }

  void dfs(int i, int j, char[][] board, boolean[][] visited){
      if(i >= m || i < 0 || j >= n || j < 0 || board[i][j] == 'X' || visited[i][j]) return;
      visited[i][j] = true;
      dfs(i + 1, j, board, visited);
      dfs(i - 1, j, board, visited);
      dfs(i, j + 1, board, visited);
      dfs(i, j - 1, board, visited);
  }


  // https://leetcode.com/problems/number-of-enclaves/
  public int numEnclaves(int[][] grid) {
    m = grid.length; n = grid[0].length;
    for(int i = 0; i < m; i++){
        if(grid[i][0] == 1) dfs(i, 0, grid);
        if(grid[i][n-1] == 1) dfs(i, n-1, grid);
    }
    for(int j = 0; j < n; j++){
        if(grid[0][j] == 1) dfs(0, j, grid);
        if(grid[m-1][j] == 1) dfs(m - 1, j, grid);
    }
    int cnt = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            cnt += grid[i][j];
        }
    }
    return cnt;
  }

  void dfs(int x, int y, int[][] grid){
    if(x >= m || x < 0 || y >= n || y < 0 || grid[x][y] == 0) return;
    grid[x][y] = 0;
    for(int[] dir : directions){
        int newX = x + dir[0], newY = y + dir[1];
        dfs(newX, newY, grid);
    }
  }

  // https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
  int countDistinctIslands(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    boolean[][] visited = new boolean[m][n];
    Set<List<List<Integer>>> set = new HashSet<>();

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1 && !visited[i][j]) {
                List<List<Integer>> shape = new ArrayList<>();
                dfs(i, j, i, j, grid, visited, shape);
                shape.sort((a, b) -> {
                    if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
                    return a.get(1) - b.get(1);
                });
                set.add(shape);
            }
        }
    }

    return set.size();
  }

  void dfs(int x, int y, int baseX, int baseY, int[][] grid, boolean[][] visited, List<List<Integer>> shape) {
    visited[x][y] = true;
    shape.add(Arrays.asList(x - baseX, y - baseY));

    for (int[] dir : directions) {
        int newX = x + dir[0], newY = y + dir[1];
        if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
            grid[newX][newY] == 1 && !visited[newX][newY]) {
            dfs(newX, newY, baseX, baseY, grid, visited, shape);
        }
    }
  }
}