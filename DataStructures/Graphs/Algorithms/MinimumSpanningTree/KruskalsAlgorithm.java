package DataStructures.Graphs.Algorithms.MinimumSpanningTree;

import java.util.*;

class KruskalsAlgorithm {

  // https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
  static class DisjointSet{
    int[] size, parent;

    DisjointSet(int v){
        size = new int[v]; parent = new int[v];
        for(int i = 0; i < v; i++){
            parent[i] = i; size[i] = 1;
        }
    }

    int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    void join(int x, int y){
        int ux = find(x), uy = find(y);
        if(ux == uy) return;
        if(size[ux] > size[uy]){
            parent[uy] = ux;
            size[ux] += size[uy];
        }else{
            parent[ux] = uy;
            size[uy] += size[ux]; 
        }
    }

    boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
  }

  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    List<int[]> edges = new ArrayList<>();

    // Collect all unique edges from adjacency list
    for (int u = 0; u < V; u++) {
        for (int[] neighbor : adj.get(u)) {
            int v = neighbor[0], w = neighbor[1];
            edges.add(new int[]{u, v, w});
        }
    }

    // Sort edges by weight
    Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

    // Kruskal's algorithm
    DisjointSet ds = new DisjointSet(V);
    int sum = 0;

    for (int[] edge : edges) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (!ds.isConnected(u, v)) {
            ds.join(u, v);
            sum += w;
        }
    }

    return sum;
  }

  // https://leetcode.com/problems/number-of-operations-to-make-network-connected/
  public int makeConnected(int n, int[][] connections) {
    int cables = connections.length; 
    if (cables < n - 1) return -1; // Not enough cables to connect all

    DisjointSet djs = new DisjointSet(n);

    for (int[] connection : connections) {
        int u = connection[0], v = connection[1];
        djs.join(u, v);
    }

    // Count unique components
    int components = 0;
    for (int i = 0; i < n; i++) {
        if (djs.find(i) == i) components++;
    }

    return components - 1;
  }
}