package DataStructures.Trees.Questions.DFS;

public class Q114 {
    
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

    // https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }

        current.right = right;
    }

    // https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node, check if the value matches
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Recur for left and right with reduced target
        int newTarget = targetSum - root.val;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }


    // https://leetcode.com/problems/sum-root-to-leaf-numbers/
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    int sum(TreeNode node, int s){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return 10 * s + node.val;
        s = 10 * s + node.val;
        return sum(node.left, s) + sum(node.right, s);
    }
}
