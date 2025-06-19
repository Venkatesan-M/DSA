package DataStructures.Graphs.Algorithms.MinimumSpanningTree;

import java.util.*;

class DisjointSetSize {

  int size;
  int[] parent;
  int[] setSize;

  DisjointSetSize(int size) {
      this.size = size;
      parent = new int[size];
      setSize = new int[size];
      for (int i = 0; i < size; i++) {
          parent[i] = i;
          setSize[i] = 1; // each set starts with size 1
      }
  }

  int find(int node) {
      if (parent[node] != node) {
          parent[node] = find(parent[node]); // path compression
      }
      return parent[node];
  }

  void union(int x, int y) {
      int rootX = find(x), rootY = find(y);
      if (rootX == rootY) return;

      // Union by size: attach smaller tree to larger
      if (setSize[rootX] < setSize[rootY]) {
          parent[rootX] = rootY;
          setSize[rootY] += setSize[rootX];
      } else {
          parent[rootY] = rootX;
          setSize[rootX] += setSize[rootY];
      }
  }

  boolean isConnected(int x, int y) {
      return find(x) == find(y);
  }

  int getSetSize(int x) {
      return setSize[find(x)];
  }
}

class Main{
    // https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
    public int removeStones(int[][] stones) {
        int maxRow = 0, maxCol = 0;

        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        // Initialize DSU large enough to cover all rows and offset columns
        DisjointSetSize dsu = new DisjointSetSize(maxRow + maxCol + 2);

        Set<Integer> uniqueNodes = new HashSet<>();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + maxRow + 1; // Offset columns to avoid overlap

            dsu.union(row, col);
            // Track unique nodes for final calculation
            uniqueNodes.add(row);
            uniqueNodes.add(col);
        }

        Set<Integer> rootSet = new HashSet<>();
        for (int node : uniqueNodes) {
            // finding the unique roots of the connected components
            rootSet.add(dsu.find(node));
        }

        return stones.length - rootSet.size();
    }
}