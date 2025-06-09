package DataStructures.Graphs.Learning;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    // https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0); ans.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int nei : adj.get(node)){
                if(!visited[nei]){
                    visited[nei] = true;
                    ans.add(nei);
                    q.offer(nei);
                }
            }
        }
        return ans;
    }

    // https://leetcode.com/problems/rotting-oranges/description/
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;

        // Count fresh oranges and enqueue rotten ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) q.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        // If no fresh oranges at all
        if (fresh == 0) return 0;

        int time = -1;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] d : dirs) {
                    int x = curr[0] + d[0], y = curr[1] + d[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
