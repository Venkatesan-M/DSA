package DataStructures.Trees.Questions.DFS;

public class Q226 {
    

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // https://leetcode.com/problems/invert-binary-tree/description/
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }


    // DFS + Post-Order Traversal
    void invert(TreeNode node){
        if(node == null) return;
        TreeNode left = node.left; TreeNode right = node.right;
        node.left = right; node.right = left;
        invert(left); invert(right);
    }
}
