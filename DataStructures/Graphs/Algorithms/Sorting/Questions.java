package DataStructures.Graphs.Learning.Algorithms.Sorting;

import java.util.*;

class Questions {

  // https://leetcode.com/problems/course-schedule/
  // https://www.geeksforgeeks.org/problems/prerequisite-tasks/1
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      int[] inDegree = new int[numCourses];
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
      for(int[] pair : prerequisites){
          adj.get(pair[0]).add(pair[1]);
          inDegree[pair[1]]++;
      }
      int count = 0; Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < numCourses; i++){
          if(inDegree[i] == 0) q.offer(i);
      }
      while(!q.isEmpty()){
          count++;
          int node = q.poll();
          for(int nei : adj.get(node)){
              inDegree[nei]--;
              if(inDegree[nei] == 0)q.offer(nei);
          }
      }
      return count == numCourses;
  }
  
  public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

    for (int[] pair : prerequisites) {
        adj.get(pair[1]).add(pair[0]); // course depends on prerequisite
    }

    int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited

    for (int i = 0; i < numCourses; i++) {
        if (hasCycle(i, adj, state)) return false;
    }

    return true;
  }

  private boolean hasCycle(int node, List<List<Integer>> adj, int[] state) {
    if (state[node] == 1) return true;  // cycle found
    if (state[node] == 2) return false; // already visited

    state[node] = 1; // mark as visiting
    for (int neighbor : adj.get(node)) {
        if (hasCycle(neighbor, adj, state)) return true;
    }
    state[node] = 2; // mark as visited
    return false;
  }


  // https://leetcode.com/problems/course-schedule-ii/description/
 // https://www.geeksforgeeks.org/problems/course-schedule/1
  public int[] findOrder(int numCourses, int[][] prerequisites) {
      int[] inDegree = new int[numCourses];
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

      for(int[] pair : prerequisites){
          adj.get(pair[1]).add(pair[0]); // correct direction
          inDegree[pair[0]]++;
      }

      Queue<Integer> q = new LinkedList<>();
      for(int i = 0; i < numCourses; i++){
          if(inDegree[i] == 0) q.offer(i);
      }

      int[] ans = new int[numCourses];
      int idx = 0;

      while(!q.isEmpty()){
          int node = q.poll();
          ans[idx++] = node;
          for(int nei : adj.get(node)){
              inDegree[nei]--;
              if(inDegree[nei] == 0) q.offer(nei);
          }
      }

      return idx == numCourses ? ans : new int[0];
  }
  
  // in DFS, cycle can't checked with stack size unlike bfs as dfs may not go to all nodes
  Stack<Integer> st = new Stack<>();
  public int[] findOrderDFS(int numCourses, int[][] prerequisites) {
      List<List<Integer>> adj = new ArrayList<>();
      for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

      for(int[] pair : prerequisites){
          adj.get(pair[1]).add(pair[0]);
      }
      boolean[] visited = new boolean[numCourses];
      boolean[] path = new boolean[numCourses];
      for(int i = 0; i < numCourses; i++){
          if(!visited[i]){
              if(hasCycle(i, adj, visited, path)){
                  return new int[0];
              }
          }
      }
      int[] ans = new int[numCourses]; int c = 0;
      while(!st.isEmpty())ans[c++] = st.pop();
      return ans;
  }

  boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] path){
      visited[node] = true;
      path[node] = true;
      for(int nei : adj.get(node)){
          if(!visited[nei]){
              if(hasCycle(nei, adj, visited, path)) return true;
          }
          if(path[nei]) return true;
      }
      path[node] = false;
      st.push(node);
      return false;
  }


    // https://leetcode.com/problems/find-eventual-safe-states/
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] indegree = new int[n];

        // Initialize the reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        // Build the reverse graph and compute indegree
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u); // reverse edge: v → u
                indegree[u]++; // count how many nodes u points to
            }
        }

        // Queue for nodes with indegree 0 (i.e., terminal in original graph)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i); // safe terminal node
            }
        }

        boolean[] safe = new boolean[n];

        // Kahn's algorithm on reverse graph
        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;
            for (int prev : reverseGraph.get(node)) {
                indegree[prev]--;
                if (indegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        // Collect all safe nodes
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) result.add(i);
        }

        return result;
    }


    // https://www.geeksforgeeks.org/problems/alien-dictionary/1
    public String findOrder(String[] words) {
        // Step 1: Initialize graph and in-degree array
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[26];
        boolean[] present = new boolean[26];

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Mark all characters that are present in the input
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }

        // Step 3: Build the graph
        for (int i = 0; i < words.length - 1; i++) {
            if (!addEdge(words[i], words[i + 1], adj, inDegree)) {
                return "";
            }
        }

        // Step 4: Topological sort using Kahn's algorithm
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append((char)(node + 'a'));

            for (int nei : adj.get(node)) {
                inDegree[nei]--;
                if (inDegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        // Step 5: If result length is less than total unique chars, there's a cycle
        for (int i = 0; i < 26; i++) {
            if (present[i] && inDegree[i] > 0) return "";
        }

        return sb.toString();
    }

    // Helper to add an edge from first different char in adjacent words
    boolean addEdge(String a, String b, List<List<Integer>> adj, int[] inDegree) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            char c1 = a.charAt(i), c2 = b.charAt(i);
            if (c1 != c2) {
                int u = c1 - 'a', v = c2 - 'a';
                adj.get(u).add(v);
                inDegree[v]++;
                return true;
            }
        }

        // Invalid case: prefix problem (e.g., "abc" before "ab")
        return a.length() <= b.length();
    }
}