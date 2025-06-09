package DataStructures.Graphs.Learning;

import java.util.ArrayList;

public class DFS {
    
    // https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0, adj, visited, ans);
        return ans;
    }
    void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,  ArrayList<Integer> ans){
        ans.add(node);
        visited[node] = true;
        for(int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(nei, adj, visited, ans);
            }
        }
        return;
    }


    // https://leetcode.com/problems/flood-fill/
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if (original == color) return image; // Avoid infinite recursion

        dfs(image, sr, sc, original, color);
        return image;
    }

    private void dfs(int[][] image, int x, int y, int original, int color) {
        // Base case: out of bounds or already visited or different color
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length ||
            image[x][y] != original) return;

        image[x][y] = color; // Fill the pixel

        // Explore 4 directions
        dfs(image, x + 1, y, original, color);
        dfs(image, x - 1, y, original, color);
        dfs(image, x, y + 1, original, color);
        dfs(image, x, y - 1, original, color);
    }
}
