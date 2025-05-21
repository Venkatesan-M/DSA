package DataStructures.Trees.Questions.DFS;

public class Q124 {
    private int maxSum = Integer.MIN_VALUE;
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


    // https://leetcode.com/problems/binary-tree-maximum-path-sum/
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Recursively get max gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0); // only add if positive
        int rightGain = Math.max(maxGain(node.right), 0);

        // Max path sum at the current node as the highest point (may include both subtrees)
        int currentPathSum = node.val + leftGain + rightGain;

        // Update global max
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the max gain from either left or right, plus current node value
        return node.val + Math.max(leftGain, rightGain);
    }
}
