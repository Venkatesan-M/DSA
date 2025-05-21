package DataStructures.Trees.Questions.DFS;

class Q543{
    
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

    // https://leetcode.com/problems/diameter-of-binary-tree/description/
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    int depth(TreeNode node){
        if (node == null) return 0;
        // post order traversal + DFS
        int left = depth(node.left);
        int right = depth(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}