package DataStructures.Trees.Questions.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class Q993 {
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

    // https://leetcode.com/problems/cousins-in-binary-tree/description/
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int lvlSize = q.size();
            TreeNode xParent = null, yParent = null;

            for (int i = 0; i < lvlSize; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.offer(node.left);
                    if (node.left.val == x) xParent = node;
                    if (node.left.val == y) yParent = node;
                }

                if (node.right != null) {
                    q.offer(node.right);
                    if (node.right.val == x) xParent = node;
                    if (node.right.val == y) yParent = node;
                }
            }

            if (xParent != null && yParent != null) {
                return xParent != yParent; // Same level, different parents
            }

            if (xParent != null || yParent != null) {
                return false; // One found but not the other at this level
            }
        }

        return false;
    }
}
