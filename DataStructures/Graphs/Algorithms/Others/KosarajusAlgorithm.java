package DataStructures.Graphs.Algorithms.Others;

import java.util.*;

class KosarajusAlgorithm {

  // https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1
  Stack<Integer> st;

  public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
      int n = adj.size();
      st = new Stack<>();

      // Step 1: Build reversed graph
      ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
      for (int i = 0; i < n; i++) rev.add(new ArrayList<>());
      for (int u = 0; u < n; u++) {
          for (int v : adj.get(u)) {
              rev.get(v).add(u);
          }
      }

      // Step 2: DFS on original graph to fill stack
      boolean[] vis1 = new boolean[n];
      for (int i = 0; i < n; i++) {
          if (!vis1[i]) dfs(i, adj, vis1);
      }

      // Step 3: DFS on reversed graph
      boolean[] vis2 = new boolean[n];
      int scc = 0;
      while (!st.isEmpty()) {
          int node = st.pop();
          if (!vis2[node]) {
              dfsRev(node, rev, vis2);
              scc++;
          }
      }

      return scc;
  }

  void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
      vis[u] = true;
      for (int nei : adj.get(u)) {
          if (!vis[nei]) dfs(nei, adj, vis);
      }
      st.push(u);
  }

  void dfsRev(int u, ArrayList<ArrayList<Integer>> rev, boolean[] vis) {
      vis[u] = true;
      for (int nei : rev.get(u)) {
          if (!vis[nei]) dfsRev(nei, rev, vis);
      }
  }
}