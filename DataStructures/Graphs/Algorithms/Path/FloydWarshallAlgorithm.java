package DataStructures.Graphs.Learning.Algorithms.Path;

class FloydWarshallAlgorithm {

  // this algorithm is used to find the shortest path between all pairs of vertices in a graph
  // it is used to find the shortest path between all pairs of vertices in a graph
  // the time complexity of this algorithm is O(n^3)
  // we can use dijkstra's algorithm to find the shortest path between all pairs of vertices in a graph
  // it's faster than floyd warshall algorithm, dijkstra's -> O(V * ElogV) and floyd warshall -> O(V^3)
  // but dijkstra's algorithm can't detect negative weight cycles

  // https://www.geeksforgeeks.org/problems/implementing-floyd-warshall/1
  public void floydWarshall(int[][] dist) {
    int n = dist.length;
    int INF = 100000000;

    // Run Floyd-Warshall algorithm
    for (int via = 0; via < n; via++) {
        for (int src = 0; src < n; src++) {
            for (int dst = 0; dst < n; dst++) {
                if (dist[src][via] != INF && dist[via][dst] != INF) {
                    dist[src][dst] = Math.min(dist[src][dst], dist[src][via] + dist[via][dst]);
                }
            }
        }
    }
  }

  public boolean hasNegativeCycle(int[][] dist) {
    int n = dist.length;
    for (int i = 0; i < n; i++) {
        if (dist[i][i] < 0) {
            return true;
        }
    }
    return false;
  }



  // https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int INF = (int)1e9;
      int[][] dis = new int[n][n];

      // Initialize distance matrix
      for (int i = 0; i < n; i++) {
          Arrays.fill(dis[i], INF);
          dis[i][i] = 0;
      }

      // Add edges
      for (int[] edge : edges) {
          int u = edge[0], v = edge[1], w = edge[2];
          dis[u][v] = w;
          dis[v][u] = w;
      }

      // Floyd-Warshall
      for (int via = 0; via < n; via++) {
          for (int src = 0; src < n; src++) {
              for (int dst = 0; dst < n; dst++) {
                  if (dis[src][via] < INF && dis[via][dst] < INF) {
                      dis[src][dst] = Math.min(dis[src][dst], dis[src][via] + dis[via][dst]);
                  }
              }
          }
      }

      int minCount = INF, res = -1;
      for (int i = 0; i < n; i++) {
          int count = 0;
          for (int j = 0; j < n; j++) {
              if (i != j && dis[i][j] <= distanceThreshold) count++;
          }
          if (count <= minCount) {
              minCount = count;
              res = i;  // prefer larger index in case of tie
          }
      }

      return res;
  }
}