package DataStructures.Graphs.Learning.Algorithms.Sorting.Path;


import java.util.*;

class BellmanFordAlgorithm {

  // https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
  static final int INF = (int)1e8;

  public int[] bellmanFord(int V, int[][] edges, int src) {
    static final int INF = (int) 1e8;

    public int[] bellmanFord(int V, int[][] edges, int src) {
        int[] dis = new int[V];
        int[] parent = new int[V];
        Arrays.fill(dis, INF);
        Arrays.fill(parent, -1);
        dis[src] = 0;

        // Standard Bellman-Ford: Relax edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dis[u] != INF && dis[u] + w < dis[v]) {
                    dis[v] = dis[u] + w;
                    parent[v] = u;
                }
            }
        }

        // One more pass to detect negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (dis[u] != INF && dis[u] + w < dis[v]) {
                // Negative cycle found. Reconstruct the cycle
                int x = v;
                for (int i = 0; i < V; i++) {
                    x = parent[x];
                }

                List<Integer> cycle = new ArrayList<>();
                int curr = x;
                do {
                    cycle.add(curr);
                    curr = parent[curr];
                } while (curr != x && curr != -1); // Prevent infinite loops
                cycle.add(x);
                Collections.reverse(cycle);

                System.out.println("Negative weight cycle detected:");
                for (int node : cycle) {
                    System.out.print(node + " ");
                }
                System.out.println();

                return new int[]{-1}; // Still return -1 as per original logic
            }
        }

        return dis;
    }
}