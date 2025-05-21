package DataStructures.Trees.Questions.DFS;

public class Q236 {
    
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

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null || node == p || node == q) return node;

        TreeNode left = lowestCommonAncestor(node.left, p, q);
        TreeNode right = lowestCommonAncestor(node.right, p, q);

        if(left != null && right != null) return node;
        return left == null ? right : left;
    }


    // // my solution
    // public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
    //     if(inReach(node.left, p) && inReach(node.left, q)){
    //         return lowestCommonAncestor(node.left, p, q);
    //     }
    //     if((inReach(node.right, p) && inReach(node.right, q))){
    //         return lowestCommonAncestor(node.right, p, q);
    //     }
    //     return node;
    // }

    // boolean inReach(TreeNode node, TreeNode des){
    //     if(node == null) return false;
    //     if(node == des) return true;
    //     return inReach(node.left, des) || inReach(node.right, des);
    // }
}
