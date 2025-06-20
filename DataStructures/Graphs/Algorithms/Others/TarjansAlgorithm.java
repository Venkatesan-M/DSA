package DataStructures.Graphs.Algorithms.Others;

import java.util.*;

class TarjansAlgorithm {

  // bridges in graph
  // https://leetcode.com/problems/critical-connections-in-a-network/
  private int time = 0;

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
      List<List<Integer>> res = new ArrayList<>();
      List<List<Integer>> adj = new ArrayList<>();

      for (int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());
      }

      for (List<Integer> conn : connections) {
          int u = conn.get(0), v = conn.get(1);
          adj.get(u).add(v);
          adj.get(v).add(u);
      }

      int[] disc = new int[n]; // discovery time
      int[] low = new int[n];  // lowest discovery time reachable
      Arrays.fill(disc, -1);

      dfs(0, -1, disc, low, adj, res);
      return res;
  }

  private void dfs(int u, int parent, int[] disc, int[] low, List<List<Integer>> adj, List<List<Integer>> res) {
      disc[u] = low[u] = time++;
      for (int v : adj.get(u)) {
          if (v == parent) continue;
          if (disc[v] == -1) {
              dfs(v, u, disc, low, adj, res);
              low[u] = Math.min(low[u], low[v]);
              if (low[v] > disc[u]) {
                  res.add(Arrays.asList(u, v)); // this is a bridge
              }
          } else {
              low[u] = Math.min(low[u], disc[v]);
          }
      }
  }


  // https://www.geeksforgeeks.org/problems/articulation-point-1/1
  int timer = 0;
  public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
      int[] disc = new int[V];
      int[] low = new int[V];
      boolean[] visited = new boolean[V];
      boolean[] isArticulation = new boolean[V];

      Arrays.fill(disc, -1);
      Arrays.fill(low, -1);

      for (int i = 0; i < V; i++) {
          if (!visited[i]) {
              dfs(i, -1, adj, visited, disc, low, isArticulation);
          }
      }

      ArrayList<Integer> ans = new ArrayList<>();
      for (int i = 0; i < V; i++) {
          if (isArticulation[i]) ans.add(i);
      }
      if (ans.size() == 0) ans.add(-1);
      return ans;
  }

  void dfs(int u, int parent, ArrayList<ArrayList<Integer>> adj,
           boolean[] visited, int[] disc, int[] low, boolean[] isArticulation) {
      visited[u] = true;
      disc[u] = low[u] = timer++;
      int children = 0;

      for (int v : adj.get(u)) {
          if (v == parent) continue;

          if (!visited[v]) {
              children++;
              dfs(v, u, adj, visited, disc, low, isArticulation);
              low[u] = Math.min(low[u], low[v]);

              if (parent != -1 && low[v] >= disc[u]) {
                  isArticulation[u] = true;
              }
          } else {
              low[u] = Math.min(low[u], disc[v]);
          }
      }

      if (parent == -1 && children > 1) {
          isArticulation[u] = true;
      }
  }
}

