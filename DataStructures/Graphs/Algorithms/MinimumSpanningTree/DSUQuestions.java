package DataStructures.Graphs.Algorithms.MinimumSpanningTree;

import java.util.*;

class DisjointSet{
  int[] size, parent;
  
  DisjointSet(int n){
      size = new int[n]; parent = new int[n];
      for(int i = 0; i < n; i++){
          size[i] = 1; parent[i] = i;
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
  
  int sizeOf(int x){
      return size[find(x)];
  }
  
}


class DSUQuestions {

  // https://leetcode.com/problems/accounts-merge/description/
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    int n = accounts.size();
    Map<String, Integer> map = new HashMap<>();
    Map<Integer, List<String>> con = new HashMap<>();
    DisjointSet ds = new DisjointSet(n);
    for(int i = 0; i < n; i++){
        for(int j = 1; j < accounts.get(i).size(); j++){
            String email = accounts.get(i).get(j);
            if(map.containsKey(email)){
                ds.join(map.get(email), i);
            }else{
                map.put(email, i);
            }
        }
    }
    for(String email : map.keySet()){
        int num = map.get(email);
        int parent = ds.find(num);
        if(con.containsKey(parent)){
            con.get(parent).add(email);
        }else{
            List<String> temp = new ArrayList<>();
            temp.add(email); con.put(parent, temp);
        }
    }
    for(Integer i : con.keySet()){
        Collections.sort(con.get(i));
    }
    List<List<String>> ans = new ArrayList<>();
    for(Integer i : con.keySet()){
        String name = accounts.get(i).get(0);
        List<String> temp = new ArrayList<>(); temp.add(name);
        temp.addAll(con.get(i));
        ans.add(temp);
    }
    return ans;
  }


  // https://www.geeksforgeeks.org/problems/number-of-islands/1
  public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
      List<Integer> ans = new ArrayList<>();
      DisjointSet ds = new DisjointSet(rows * cols);
      int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
      int comp = 0;
      boolean[] visited = new boolean[rows * cols];

      for(int[] op : operators){
          int x = op[0], y = op[1];
          int node = cols * x + y;
          if(!visited[node]){
              visited[node] = true;
              comp++;
              for(int[] dir : directions){
                  int newX = x + dir[0], newY = y + dir[1];
                  int newNode = cols * newX + newY;
                  if((newX < rows && newX > -1) && (newY < cols && newY > -1) && visited[newNode]){
                      if(!ds.isConnected(node, newNode)){
                          ds.join(node, newNode);
                          comp--;
                      }
                  }
              }
          }
          ans.add(comp);
      }
      return ans;
  }


  // https://leetcode.com/problems/making-a-large-island/
  public int largestIsland(int[][] grid) {
      int r = grid.length; int c = grid[0].length;
      DisjointSet ds = new DisjointSet(r * c);
      int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
      int zeros = 0;
      for(int i = 0; i < r; i++){
          for(int j = 0; j < c; j++){
              if(grid[i][j] == 1){
                  int node = i * r + j;
                  for(int[] dir : directions){
                      int ni = i + dir[0], nj = j + dir[1];
                      if((ni < r && ni > -1) && (nj < c && nj > -1) && grid[ni][nj] == 1){
                          int nextNode = ni * r + nj;
                          ds.join(node, nextNode);
                      }
                  }
              }else{
                  zeros++;
              }
          }
      }
      if(zeros == 0) return r * c;
      int ans = 0;
      for(int i = 0; i < r; i++){
          for(int j = 0; j < c; j++){
              if(grid[i][j] == 0){
                  Set<Integer> set = new HashSet<>();
                  int size = 1;
                  for(int[] dir : directions){
                      int ni = i + dir[0], nj = j + dir[1];
                      if((ni < r && ni > -1) && (nj < c && nj > -1) && grid[ni][nj] == 1){
                          int nextNode = ni * r + nj;
                          set.add(ds.find(nextNode));
                      }
                  }
                  for(int parents : set){
                      size+=ds.sizeOf(parents);
                  }
                  ans = Math.max(ans, size);
              }
          }
      }
      return ans;
  }


  // https://leetcode.com/problems/swim-in-rising-water/

  /*
  Create a list of all grid cells, each as (elevation, x, y).
  Sort the list by elevation (this simulates the rising water).
  Initialize a Union-Find data structure for all n * n cells.
  Iterate through the sorted list, for each (elevation, x, y):
  Mark the cell as "flooded"/active.
  Union it with already-flooded neighbors.
  After each union, check if (0, 0) and (n-1, n-1) are connected.
  If yes, return the current elevation as the answer.
  */
  public int swimInWater(int[][] grid) {
      int n = grid.length;
      int total = n * n;
      int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
      DisjointSet dsu = new DisjointSet(total);
      boolean[][] visited = new boolean[n][n];

      // Create list of (elevation, x, y)
      List<int[]> cells = new ArrayList<>();
      for (int i = 0; i < n; i++)
          for (int j = 0; j < n; j++)
              cells.add(new int[]{grid[i][j], i, j});
      // Sort by elevation
      Collections.sort(cells, (a, b) -> Integer.compare(a[0], b[0]));

      for (int[] cell : cells) {
          int elev = cell[0], x = cell[1], y = cell[2];
          visited[x][y] = true;
          int id1 = x * n + y;
          for (int[] d : dirs) {
              int nx = x + d[0], ny = y + d[1];
              if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny]) {
                  int id2 = nx * n + ny;
                  dsu.join(id1, id2);
              }
          }
          if (dsu.isConnected(0, n * n - 1))
              return elev;
      }
      return -1;
  }
}