package DataStructures.Trees.Questions.DFS;

public class Q108 {
    
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

    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        return divcon(nums, 0, nums.length - 1);
    }

    TreeNode divcon(int[] nums, int l, int r){
        if(l == r){
            return new TreeNode(nums[l]);
        }
        if(l + 1 == r){
            return new TreeNode(nums[r], new TreeNode(nums[l]), null);
        }
        int mid = l + (r - l) / 2;
        TreeNode left = divcon(nums, l, mid - 1);
        TreeNode right = divcon(nums, mid + 1, r);
        return new TreeNode(nums[mid], left, right);
    }
}
