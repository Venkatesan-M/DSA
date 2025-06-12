package DataStructures.Graphs.Learning;

import java.util.*;

class BipartiteGraph {

  // https://leetcode.com/problems/is-graph-bipartite/description/
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    boolean[] color = new boolean[n];
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            if (!dfs(i, true, graph, color, visited)) {
                return false;
            }
        }
    }
    return true;
  }

  boolean dfs(int node, boolean c, int[][] graph, boolean[] color, boolean[] visited) {
    visited[node] = true;
    color[node] = c;

    for (int nei : graph[node]) {
        if (!visited[nei]) {
            if (!dfs(nei, !c, graph, color, visited)) {
                return false;
            }
        } else {
            if (color[node] == color[nei]) {
                return false;
            }
        }
    }

    return true;
  }

  // BFS

  public boolean isBipartiteBFS(int[][] graph) {
      int n = graph.length;
      int[] color = new int[n]; // 0: unvisited, 1 and -1: colors

      for (int i = 0; i < n; i++) {
          if (color[i] != 0) continue;

          Queue<Integer> q = new LinkedList<>();
          q.offer(i);
          color[i] = 1;

          while (!q.isEmpty()) {
              int node = q.poll();
              for (int nei : graph[node]) {
                  if (color[nei] == 0) {
                      color[nei] = -color[node];
                      q.offer(nei);
                  } else if (color[nei] == color[node]) {
                      return false; // adjacent nodes with same color
                  }
              }
          }
      }

      return true;
  }
  
}