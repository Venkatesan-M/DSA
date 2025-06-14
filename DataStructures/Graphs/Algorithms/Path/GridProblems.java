package DataStructures.Graphs.Algorithms.Path;

import java.util.*;

class GridProblems{

  // https://leetcode.com/problems/shortest-path-in-binary-matrix/
  int[][] directions8D = {
    {1, 0}, {0, 1}, {-1, 0}, {0, -1},
    {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
  };

  public int shortestPathBinaryMatrix(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    if (grid[0][0] != 0 || grid[m - 1][n - 1] != 0) return -1;

    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[m][n];
    q.offer(new int[]{0, 0, 1}); // x, y, distance
    visited[0][0] = true;

    while (!q.isEmpty()) {
        int[] cur = q.poll();
        int x = cur[0], y = cur[1], dist = cur[2];

        if (x == m - 1 && y == n - 1) return dist;

        for (int[] dir : directions8D) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
    }

    return -1;
  }


  // https://leetcode.com/problems/path-with-minimum-effort/
  int[][] directions4D = {
    {0, 1}, {1, 0}, {0, -1}, {-1, 0}
  };

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length, n = heights[0].length;
    int[][] effort = new int[m][n];
    for (int[] row : effort) Arrays.fill(row, Integer.MAX_VALUE);
    effort[0][0] = 0;

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    pq.offer(new int[]{0, 0, 0}); // {effort, x, y}

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int dis = curr[0], x = curr[1], y = curr[2];

        if (x == m - 1 && y == n - 1) return dis;

        for (int[] dir : directions4D) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                int nextEffort = Math.max(dis, Math.abs(heights[x][y] - heights[nx][ny]));
                if (nextEffort < effort[nx][ny]) {
                    effort[nx][ny] = nextEffort;
                    pq.offer(new int[]{nextEffort, nx, ny});
                }
            }
        }
    }

    return -1; // unreachable (though the problem guarantees it is reachable)
  }
}