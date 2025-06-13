package DataStructures.Graphs.Learning;
import java.util.*;
class Cycles{
    // https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1 
  public boolean isCycle(int V, int[][] edges) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

    for (int[] edge : edges) {
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
        if (!visited[i]) {
            if (dfsCycleCheck(i, -1, visited, adj)) {
                return true;
            }
            if (bfsCycleCheck(i, visited, adj)) {
                return true;
            }
        }
    }
    return false;
  }

  private boolean dfsCycleCheck(int start, int prev, boolean[] visited, List<List<Integer>> adj) {
    visited[start] = true;
    for (int nei : adj.get(start)) {
        if (!visited[nei]) {
            // If a cycle is found in the recursive call, propagate true
            if (dfsCycleCheck(nei, start, visited, adj)) {
                return true;
            }
        } else if (nei != prev) {
            // Found a visited neighbor that is not the parent, hence a cycle
            return true;
        }
    }
    // No cycle found through any path from this 'start' node
    return false;
  }

  
  private boolean bfsCycleCheck(int start, boolean[] visited, List<List<Integer>> adj) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{start, -1});
    visited[start] = true;

    while (!q.isEmpty()) {
        int[] node = q.poll();
        int curr = node[0];
        int parent = node[1];

        for (int nei : adj.get(curr)) {
            if (!visited[nei]) {
                visited[nei] = true;
                q.offer(new int[]{nei, curr});
            } else if (nei != parent) {
                return true; // cycle detected
            }
        }
    }
    return false;
  }

  // https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
  public boolean isCyclic(int V, int[][] edges) {
    // code here
    boolean[] visited = new boolean[V];
    boolean[] path = new boolean[V];
    List<List<Integer>> adj = new ArrayList<>();
    for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
    for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
    }
    for(int i = 0; i < V; i++){
        if(!visited[i]){
            if(dfsCycleChecker(i, adj, visited, path)){
                return true;
            }
        }
    }
    return false;
  }

  boolean dfsCycleChecker(int node, List<List<Integer>> adj, boolean[] visited, boolean[] path){
    visited[node] = true;
    path[node] = true;
    for(int nei : adj.get(node)){
        if(!visited[nei]){
            if(dfsCycleChecker(nei, adj, visited, path)) return true;
        }
        if(path[nei]) return true;
    }
    path[node] = false;
    return false;
  }

    public boolean isCyclicBFS(int V, int[][] edges) {
        int[] inDegree = new int[V];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inDegree[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            count++;
            int node = q.poll();
            for(int nei : adj.get(node)){
                inDegree[nei]--;
                if(inDegree[nei] == 0)q.offer(nei);
            }
        }
        return count != V;
    }
}