package DataStructures.Trees.Questions.DFS;

import java.util.ArrayList;
import java.util.List;

public class Q98_Q230 {
    

    private int count = 0;
    private int result = 0;
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

    // https://leetcode.com/problems/validate-binary-search-tree/description/

    // public boolean isValidBST(TreeNode root) {
    //     return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }
    boolean validate(TreeNode node, long min, long max){
        if(node == null) return true;
        if(node.val < max && node.val > min){
            return validate(node.right, node.val, max) && validate(node.left, min, node.val);
        }
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> a = pre(root);
        for(int i = 1; i < a.size(); i++){
            if(a.get(i-1) >= a.get(i)) return false;
        }
        return true;
    }

    List<Integer> pre(TreeNode node){
        List<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        ans.addAll(pre(node.left));
        ans.add(node.val);
        ans.addAll(pre(node.right));
        return ans;
    }


    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    private void inorder(TreeNode node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }


    // public int kthSmallest(TreeNode root, int k) {
    //     List<Integer> a = pre(root);
    //     return a.get(k-1);
    // }
}
