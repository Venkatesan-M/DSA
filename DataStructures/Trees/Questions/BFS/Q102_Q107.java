package DataStructures.Trees.Questions.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_Q107 {
    // Medium
    // https://leetcode.com/problems/binary-tree-level-order-traversal/
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < lvl; i++){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < lvl; i++){
                TreeNode t = q.poll();
                temp.add(t.val);
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
            ans.add(temp);
        }
        Collections.reverse(ans);
        return ans;
    }


    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);
                
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            
            if (!flag) {
                Collections.reverse(level);
            }
            
            ans.add(level);
            
            flag = !flag;
        }
        
        return ans;
    }
}
