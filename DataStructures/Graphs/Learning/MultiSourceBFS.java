package DataStructures.Graphs.Learning;

import java.util.*;

class MultiSourceBFS {


  // https://leetcode.com/problems/01-matrix/description/
  int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
  int m, n;

  public int[][] updateMatrix(int[][] mat) {
      m = mat.length;
      n = mat[0].length;
      int[][] dis = new int[m][n];
      Queue<int[]> q = new LinkedList<>();

      // Initialize distances and add all 0s to the queue
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (mat[i][j] == 0) {
                  q.offer(new int[]{i, j});
                  dis[i][j] = 0;
              } else {
                  dis[i][j] = -1; // Mark as unvisited or a large value
              }
          }
      }

      while (!q.isEmpty()) {
          int[] current = q.poll();
          int r = current[0];
          int c = current[1];

          for (int[] dir : direction) {
              int nr = r + dir[0];
              int nc = c + dir[1];

              // Check bounds and if the neighbor is unvisited
              if (nr >= 0 && nr < m && nc >= 0 && nc < n && dis[nr][nc] == -1) {
                  dis[nr][nc] = dis[r][c] + 1;
                  q.offer(new int[]{nr, nc});
              }
          }
      }
      return dis;
  }


  // https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1

  public int[][] nearest(int[][] grid) {
      m = grid.length; n = grid[0].length;
      int[][] dis = new int[m][n];

      Queue<int[]> q = new LinkedList<>();

      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              if(grid[i][j] == 1){
                  dis[i][j] = 0;
                  q.offer(new int[]{i, j});
              }else{
                  dis[i][j] = -1;
              }
          }
      }

      while(!q.isEmpty()){
          int size = q.size();
          for(int i = 0; i < size; i++){
              int[] coor = q.poll();
              int x = coor[0], y = coor[1];
              for(int[] dir : direction){
                  int nr = dir[0] + x, nc = dir[1] + y;
                  if((nr < m && nr > -1) && (nc < n && nc > -1) && dis[nr][nc] == -1){
                      dis[nr][nc] = dis[x][y] + 1;
                      q.offer(new int[]{nr, nc});
                  }
              }
          }
      }
      return dis;

  }

  // https://leetcode.com/problems/number-of-enclaves/
  public int numEnclaves(int[][] grid) {
      m = grid.length;
      n = grid[0].length;
      Queue<int[]> q = new LinkedList<>();

      // Add all boundary land cells to the queue
      for (int i = 0; i < m; i++) {
          if (grid[i][0] == 1) q.offer(new int[]{i, 0});
          if (grid[i][n - 1] == 1) q.offer(new int[]{i, n - 1});
      }
      for (int j = 0; j < n; j++) {
          if (grid[0][j] == 1) q.offer(new int[]{0, j});
          if (grid[m - 1][j] == 1) q.offer(new int[]{m - 1, j});
      }

      // BFS to remove all reachable land from the boundary
      while (!q.isEmpty()) {
          int[] cell = q.poll();
          int x = cell[0], y = cell[1];
          if (grid[x][y] == 0) continue;
          grid[x][y] = 0;
          for (int[] dir : direction) {
              int nx = x + dir[0], ny = y + dir[1];
              if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                  q.offer(new int[]{nx, ny});
              }
          }
      }

      // Count remaining land cells
      int count = 0;
      for (int[] row : grid) {
          for (int cell : row) {
              count += cell;
          }
      }

      return count;
  }
}