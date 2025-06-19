package DataStructures.Graphs.Algorithms.MinimumSpanningTree;

import java.util.*;

class PrimsAlgorithm{


  // https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
  static class Triplet {
    int weight, node, parent;
    Triplet(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
  }

  static int spanningTree(int V, int E, List<List<int[]>> adj) {
    boolean[] visited = new boolean[V];
    PriorityQueue<Triplet> pq = new PriorityQueue<>((p1, p2) -> p1.weight - p2.weight);
    int sum = 0;

    // Initialize MST adjacency list
    List<List<int[]>> mstAdj = new ArrayList<>();
    for (int i = 0; i < V; i++) {
        mstAdj.add(new ArrayList<>());
    }

    pq.offer(new Triplet(0, 0, -1));

    // O(ElogE)
    while (!pq.isEmpty()) {
        Triplet t = pq.poll();
        int currNode = t.node, currWeight = t.weight, currParent = t.parent;

        if (!visited[currNode]) {
            visited[currNode] = true;
            sum += currWeight;

            if (currParent != -1) {
                // Add undirected edge to MST
                mstAdj.get(currNode).add(new int[]{currParent, currWeight});
                mstAdj.get(currParent).add(new int[]{currNode, currWeight});
            }

            for (int[] next : adj.get(currNode)) {
                int nextNode = next[0], nextWeight = next[1];
                if (!visited[nextNode]) {
                    pq.offer(new Triplet(nextWeight, nextNode, currNode));
                }
            }
        }
    }

    return sum;
  }
}