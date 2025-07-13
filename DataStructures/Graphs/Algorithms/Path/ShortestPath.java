package DataStructures.Graphs.Algorithms.Path;

import java.util.*;

class ShortestPath {

  // https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
  public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
      int n = adj.size();
      int[] ans = new int[n];
      Arrays.fill(ans, -1);
      boolean[] visited = new boolean[n];
      Queue<Integer> q = new LinkedList<>();

      q.offer(src);
      visited[src] = true;  
      ans[src] = 0;

      while (!q.isEmpty()) {
          int node = q.poll();
          for (int nei : adj.get(node)) {
              if (!visited[nei]) {
                  visited[nei] = true;    
                  ans[nei] = ans[node] + 1;
                  q.offer(nei);
              }
          }
      }
      return ans;
  }


  // D A G


  // https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
  public int[] shortestPath(int V, int E, int[][] edges) {
    List<List<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    for (int[] edge : edges) {
        adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
    }

    boolean[] visited = new boolean[V];
    Stack<Integer> st = new Stack<>(); 
    for (int i = 0; i < V; i++) {
        if (!visited[i]) dfs(i, adj, visited, st);
    }

    int[] dis = new int[V];
    Arrays.fill(dis, -1);
    dis[0] = 0;

    while (!st.isEmpty()) {
        int node = st.pop();
        int distance = dis[node];
        if (distance == -1) continue;

        for (int[] nei : adj.get(node)) {
            int next = nei[0], weight = nei[1];
            if (dis[next] == -1 || dis[next] > distance + weight) {
                dis[next] = distance + weight;
            }
        }
    }

    return dis;
  }

  static void dfs(int node, List<List<int[]>> adj, boolean[] visited, Stack<Integer> st) {
    visited[node] = true;
    for (int[] nei : adj.get(node)) {
        if (!visited[nei[0]]) dfs(nei[0], adj, visited, st);
    }
    st.push(node);
  }



    static class Pair {
        int node, wei;
        Pair(int node, int wei) {
            this.node = node;
            this.wei = wei;
        }
    }

    // https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
    public List<Integer> shortestPathWeighted(int n, int m, int[][] edges) {
        // Step 1: Initialize graph
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        // Step 2: Dijkstra setup
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wei - b.wei);
        dist[1] = 0;
        pq.offer(new Pair(1, 0));

        // Step 3: Dijkstra’s algorithm
        // O(elogv)
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.wei;

            for (Pair nei : adj.get(u)) {
                int v = nei.node, w = nei.wei;
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }

        // Step 4: Reconstruct path
        if (dist[n] == Integer.MAX_VALUE) {
            return Arrays.asList(-1);
        }

        // O(N)
        List<Integer> path = new ArrayList<>();
        int node = n;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);

        List<Integer> result = new ArrayList<>();
        result.add(dist[n]); // total weight
        result.addAll(path); // path nodes
        return result;
    }
}