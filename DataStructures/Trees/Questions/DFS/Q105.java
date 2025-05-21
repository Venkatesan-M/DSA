package DataStructures.Trees.Questions.DFS;

import java.util.Arrays;

public class Q105 {

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

    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int r = preorder[0];
        int idx = 0;
        while(inorder[idx] != r) idx++;
        TreeNode node = new TreeNode(r);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, idx + 1), Arrays.copyOfRange(inorder, 0, idx));
        node.right = buildTree(Arrays.copyOfRange(preorder,idx + 1, preorder.length), Arrays.copyOfRange(inorder, idx + 1, inorder.length));
        return node;
    }
}
