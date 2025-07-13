package DataStructures.Graphs.Algorithms.Sorting;

import java.util.*;

class TopologicalSort {

  // https://www.geeksforgeeks.org/problems/topological-sort/1
  static Stack<Integer> st = new Stack<>();
  public static ArrayList<Integer> topoSort(int V, int[][] edges) {
      // code here
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
      for(int[] edge : edges){
          adj.get(edge[0]).add(edge[1]);
      }
      boolean[] visited = new boolean[V];
      for(int i = 0; i < V; i++){
          if(!visited[i]) dfs(i, adj, visited);
      }
      ArrayList<Integer> ans = new ArrayList<>();
      while(!st.isEmpty()){
          ans.add(st.pop());
      }
      return ans;
  }

  static void dfs(int node, List<List<Integer>> adj, boolean[] visited){
      visited[node] = true;
      for(int nei : adj.get(node)){
          if(!visited[nei]) dfs(nei, adj, visited);
      }
      st.push(node);
  }


  public static ArrayList<Integer> KahnsAlgo(int V, int[][] edges) {
      // code here
      int[] inDegree = new int[V];
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < V; i++) adj.add(new ArrayList<>());
      for(int[] edge : edges){
          adj.get(edge[0]).add(edge[1]);
          inDegree[edge[1]]++;
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < V; i++){
          if(inDegree[i] == 0) q.offer(i);
      }
      ArrayList<Integer> ans = new ArrayList<>();
      while(!q.isEmpty()){
          int node = q.poll();
          ans.add(node);
          for(int nei : adj.get(node)){
              inDegree[nei]--;
              if(inDegree[nei] == 0) q.offer(nei);
          }
      }
      return ans;
  }
}