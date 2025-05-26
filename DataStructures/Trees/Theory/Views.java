package DataStructures.Trees.Theory;

import java.util.*;

class Views{
    private class TreeNode{
        int val; 
        TreeNode right, left;
        TreeNode(int val){
            this.val = val;
        }
    }
    
    // https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
    // Time: O(N), Space: O(H) for recursion stack
    ArrayList<Integer> boundaryTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null) return ans;
        
        if (!isLeaf(node)) ans.add(node.val);
        
        addLeftBoundary(node.left, ans);
        addLeaves(node, ans);
        addRightBoundary(node.right, ans);
        
        return ans;
    }
    
    void addLeftBoundary(TreeNode node, ArrayList<Integer> ans) {
        while (node != null) {
            if (!isLeaf(node)) ans.add(node.val);
            if (node.left != null) node = node.left;
            else node = node.right;
        }
    }

    void addRightBoundary(TreeNode node, ArrayList<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            if (node.right != null) node = node.right;
            else node = node.left;
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }

    void addLeaves(TreeNode node, ArrayList<Integer> ans) {
        if (node == null) return;
        if (isLeaf(node)) {
            ans.add(node.val);
            return;
        }
        addLeaves(node.left, ans);
        addLeaves(node.right, ans);
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    // https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    // Time: O(N log N), Space: O(N) - TreeMap + PriorityQueue operations
    TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans; 
        map.clear(); // Clear for multiple calls
        dfs(root, 0, 0);
        for(int col : map.keySet()){
            List<Integer> lvl = new ArrayList<>();
            for(int row : map.get(col).keySet()){
                PriorityQueue<Integer> pq = map.get(col).get(row);
                while(!pq.isEmpty()){
                    lvl.add(pq.poll());
                }
            }
            ans.add(lvl);
        }
        return ans;
    }

    void dfs(TreeNode node, int col, int row){
        if(node == null) return;
        if(map.containsKey(col)){
            if(map.get(col).containsKey(row)){
                map.get(col).get(row).offer(node.val);
            }else{
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                pq.offer(node.val);
                map.get(col).put(row, pq);
            }
        }else{
            TreeMap<Integer, PriorityQueue<Integer>> tm = new TreeMap<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(node.val);
            tm.put(row, pq);
            map.put(col, tm);
        }
        if(node.left != null) dfs(node.left, col - 1, row + 1);
        if(node.right != null) dfs(node.right, col + 1, row + 1);
    }

    // https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    // DFS approach: Time: O(N log N), Space: O(N) for TreeMap
    ArrayList<Integer> topView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, int[]> map = new TreeMap<>();
        findTop(root, 0, 0, map);

        for (int[] val : map.values()) {
            ans.add(val[0]);
        }
        return ans;
    }

    void findTop(TreeNode node, int col, int depth, TreeMap<Integer, int[]> map) {
        if (node == null) return;

        // for top view: check if depth is smaller (closer to root)
        if (!map.containsKey(col) || depth < map.get(col)[1]) {
            map.put(col, new int[]{node.val, depth});
        }

        findTop(node.left, col - 1, depth + 1, map);
        findTop(node.right, col + 1, depth + 1, map);
    }

    // BFS Solution for Top View
    // Time: O(N), Space: O(N) for queue and map
    ArrayList<Integer> topViewBFS(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        q.offer(root); 
        col.offer(0);
        
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i = 0; i < lvl; i++){
                TreeNode curr = q.poll();
                int coli = col.poll();
                // level order ensures first occurrence is the topmost
                if(!map.containsKey(coli)) map.put(coli, curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                    col.offer(coli - 1);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    col.offer(coli + 1);
                }
            }
        }
        for(int i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }

    // https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    // Time: O(N log N), Space: O(N) for TreeMap
    public ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, int[]> map = new TreeMap<>();
        bottom(root, 0, 0, map);

        for (int[] val : map.values()) {
            ans.add(val[1]);
        }
        return ans;
    }

    void bottom(TreeNode node, int col, int depth, TreeMap<Integer, int[]> map) {
        if (node == null) return;
        
        // for bottom view: update if depth is greater or equal (farther from root)
        if (!map.containsKey(col)) {
            map.put(col, new int[]{depth, node.val});
        } else {
            if (depth >= map.get(col)[0]) {
                map.put(col, new int[]{depth, node.val});
            }
        }
        bottom(node.left, col - 1, depth + 1, map);
        bottom(node.right, col + 1, depth + 1, map);
    }

    // BFS for Bottom View
    // Time: O(N), Space: O(N) for queue and map
    public ArrayList<Integer> bottomViewBFS(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        q.offer(root); 
        col.offer(0);
        
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i = 0; i < lvl; i++){
                TreeNode curr = q.poll();
                int coli = col.poll();
                // level order ensures last occurrence is the bottommost
                map.put(coli, curr.val);
                if(curr.left != null){
                    q.offer(curr.left);
                    col.offer(coli - 1);
                }
                if(curr.right != null){
                    q.offer(curr.right);
                    col.offer(coli + 1);
                }
            }
        }
        for(int i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }

    // for sideways view, be it right or left view of the binary tree
    // BFS is not prefered as it takes all the nodes into consideration O(N)
    // if DFS is used the Time complexity equals to the height of the Tree O(logn)
    
    // https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1
    // https://leetcode.com/problems/binary-tree-right-side-view/description/
    // Time: O(H) where H is height, Space: O(H) for recursion stack
    public List<Integer> rightSideView(TreeNode root) { 
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        rightPreorder(root, res, 0);
        return res;
    }
    
    private void rightPreorder(TreeNode root, List<Integer> res, int level){
        if(root == null) return;
        // first time coming to that level (right side) so add, remaining are ignored
        if(res.size() == level) res.add(root.val);
        rightPreorder(root.right, res, level + 1);
        rightPreorder(root.left, res, level + 1);
    }

    // https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1
    // Time: O(H) where H is height, Space: O(H) for recursion stack
    ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        leftPreorder(root, 0, ans);
        return ans;
    }
    
    void leftPreorder(TreeNode node, int lvl, ArrayList<Integer> ans){
        if(node == null) return;
        // first time coming to that level (left side) so add, remaining are ignored
        if(ans.size() == lvl) ans.add(node.val);
        leftPreorder(node.left, lvl + 1, ans);
        leftPreorder(node.right, lvl + 1, ans);
    }

    // Helper method to create sample tree
    TreeNode createSampleTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        return root;
    }

    public static void main(String[] args){
        Views v = new Views();
        TreeNode root = v.createSampleTree();
        
        System.out.println("Sample Tree Structure:");
        System.out.println("       1");
        System.out.println("      / \\");
        System.out.println("     2   3");
        System.out.println("    / \\ / \\");
        System.out.println("   4  5 6  7");
        System.out.println("  / \\");
        System.out.println(" 8   9");
        System.out.println();
        
        System.out.println("Boundary Traversal: " + v.boundaryTraversal(root));
        System.out.println("Top View: " + v.topView(root));
        System.out.println("Top View BFS: " + v.topViewBFS(root));
        System.out.println("Bottom View: " + v.bottomView(root));
        System.out.println("Bottom View BFS: " + v.bottomViewBFS(root));
        System.out.println("Left View: " + v.leftView(root));
        System.out.println("Right View: " + v.rightSideView(root));
        System.out.println("Vertical Traversal: " + v.verticalTraversal(root));
    }
}