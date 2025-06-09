package DataStructures.Graphs.Learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Components {
    // https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                traverse(i, adj, visited, component);
                Collections.sort(component);
                ans.add(component);
            }
        }
        return ans;
    }

    private void traverse(int node, List<List<Integer>> adj, boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                traverse(nei, adj, visited, component);
            }
        }
    }


    // https://leetcode.com/problems/number-of-provinces/
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int node) {
        visited[node] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }

    // https://www.geeksforgeeks.org/problems/number-of-provinces/1
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, visited, i, V);
                count++;
            }
        }
        return count;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, int V) {
        visited[node] = true;
        for (int j = 0; j < V; j++) {
            if (adj.get(node).get(j) == 1 && !visited[j]) {
                dfs(adj, visited, j, V);
            }
        }
    }
}
