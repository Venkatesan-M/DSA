package DataStructures.Trees.Questions.Striver;

import java.util.*;

class Hard{

    private class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1
    static ArrayList<ArrayList<Integer>> ans;
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, new ArrayList<>());
        return ans;
    }
    
    static void dfs(Node node, ArrayList<Integer> temp){
        temp.add(node.data);
        if(node.right == null && node.left == null){
            ans.add(new ArrayList<>(temp));
        }else{
            if(node.left != null) dfs(node.left, temp);
            if(node.right != null) dfs(node.right, temp);
        }
        temp.remove(temp.size() - 1);
        return;
    }

    // https://www.youtube.com/watch?v=fmflMqVOC7k
    static boolean getPath(Node node, List<Integer> ans, int tar){
        if(node == null) return false;
        ans.add(node.data);
        if(node.data == tar) return true;
        if(getPath(node.left, ans, tar) || getPath(node.right, ans, tar)) return true;
        ans.remove(ans.size() - 1);
        return false;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q) return node;

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if(left != null && right != null) return node;
        return left == null ? right : left;
    }

    // https://leetcode.com/problems/maximum-width-of-binary-tree/
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        int size = 0;
        q.add(root);
        idx.add(0);
        
        while (!q.isEmpty()) {
            int lvl = q.size();
            int minIndex = idx.peek(); // normalize indices to prevent overflow
            int start = 0, end = 0;
            
            for (int i = 0; i < lvl; i++) {
                TreeNode curr = q.poll();
                int index = idx.poll() - minIndex; // avoid large numbers
                if (i == 0) start = index;
                if (i == lvl - 1) end = index;
                
                if (curr.left != null) {
                    q.add(curr.left);
                    idx.add(2 * index + 1);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                    idx.add(2 * index + 2);
                }
            }
            size = Math.max(size, end - start + 1);
        }
        
        return size;
    }


    // https://www.youtube.com/watch?v=fnmisPM6cVo
    public void changeTree(Node root) {
        if (root == null) return;

        int childSum = 0;
        if (root.left != null) childSum += root.left.data;
        if (root.right != null) childSum += root.right.data;

        if (childSum >= root.data) {
            root.data = childSum;
        } else {
            // Propagate root.data down to children
            if (root.left != null) root.left.data = root.data;
            if (root.right != null) root.right.data = root.data;
        }

        // Re-check after potential propagation
        changeTree(root.left);
        changeTree(root.right);

        // Update root data to be sum of children if they exist
        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;

        // Avoid leaf update
        if (root.left != null || root.right != null) {
            root.data = total;
        }
    }
    public static void main(String[] args) {
        
    }



}



