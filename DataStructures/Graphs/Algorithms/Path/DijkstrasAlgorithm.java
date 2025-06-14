package DataStructures.Graphs.Learning.Algorithms.Sorting.Path;

import java.util.*;

class DijkstrasAlgorithm {


   // https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1

  // Edge class to store node and weight
  class Edge{
    int node, weight;
    Edge(int node, int wei){
        this.node = node; this.weight = wei;
    }
  }
  
  public int[] dijkstra(int V, int[][] edges, int src) {
    // Create adjacency list
    List<List<Edge>> adj = new ArrayList<>();
    int[] dis = new int[V];
    for(int i = 0; i < V; i++){
        adj.add(new ArrayList<>());
        dis[i] = Integer.MAX_VALUE;
    }
    for(int[] edge : edges){
        adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
        adj.get(edge[1]).add(new Edge(edge[0], edge[2]));
    }

    // Create priority queue to store nodes with their distances
    PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
        return e1.weight - e2.weight;
    });
    dis[src] = 0;
    pq.offer(new Edge(src, 0));

    // Process nodes in priority queue
    while(!pq.isEmpty()){
        Edge edge = pq.poll();
        int node = edge.node;
        int distance = edge.weight;

        // Update distances of neighboring nodes
        for(Edge nei : adj.get(node)){
          // If we find a shorter path to a neighboring node, update the distance and add the node to the priority queue
            int adjNode = nei.node; int edgeWeight = nei.weight;
            if(dis[adjNode] > distance + edgeWeight){
                dis[adjNode] = distance + edgeWeight;
                pq.offer(new Edge(adjNode, dis[nei.node]));
            }
        }
    }
    return dis;
  }

  
  class Pair implements Comparable<Pair> {
    int node, dist;
    Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }

    public int compareTo(Pair other) {
        if (this.dist != other.dist)
            return Integer.compare(this.dist, other.dist);
        return Integer.compare(this.node, other.node); // Ensure uniqueness
    }
  }

  public int[] dijkstraSet(int V, int[][] edges, int src) {
    List<List<Edge>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        adj.add(new ArrayList<>());
    }

    for (int[] edge : edges) {
        adj.get(edge[0]).add(new Edge(edge[1], edge[2]));
        adj.get(edge[1]).add(new Edge(edge[0], edge[2])); // For undirected graph
    }

    int[] dist = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;

    TreeSet<Pair> set = new TreeSet<>();
    set.add(new Pair(src, 0));

    while (!set.isEmpty()) {
        Pair current = set.pollFirst();
        int u = current.node;

        for (Edge e : adj.get(u)) {
            int v = e.node;
            int weight = e.weight;

            if (dist[u] + weight < dist[v]) {
                set.remove(new Pair(v, dist[v])); // Remove old pair if exists
                dist[v] = dist[u] + weight;
                set.add(new Pair(v, dist[v]));
            }
        }
    }

    return dist;
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
          int d = curr.dist;

          for (Pair nei : adj.get(u)) {
              int v = nei.node, w = nei.dist;
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