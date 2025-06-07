package DataStructures.Trees.Questions.Striver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Q863 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    Map<TreeNode, TreeNode> findMyParent;
    List<Integer> soln;
    Set<TreeNode> visited;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        findMyParent = new HashMap<>(); soln = new ArrayList<>(); visited = new HashSet<>();
        if(root == null) return soln;
        soln.add(target.val);
        if(k == 0) return soln;
        soln.remove(0); 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i = 0; i < lvl; i++){
                TreeNode curr = q.poll();
                if(curr.left != null){
                    findMyParent.put(curr.left, curr);
                    q.offer(curr.left);
                }
                if(curr.right != null){
                    findMyParent.put(curr.right, curr);
                    q.offer(curr.right);
                }
            }
        }
        travel(target, k);
        return soln;
    }
    void travel(TreeNode tar, int k){
        if(tar == null) return;
        if(!visited.contains(tar)){
            visited.add(tar);
            if(k == 0){
                soln.add(tar.val);
                return;
            }
            if(findMyParent.containsKey(tar)){
                travel(findMyParent.get(tar), k - 1);
            }
            travel(tar.left, k - 1);
            travel(tar.right, k - 1);
        }
    }


    private class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    }


    // https://www.geeksforgeeks.org/problems/burning-tree/1
    public static int minTime(Node root, int target) {
        Map<Node, Node> parent = new HashMap<>();
        Set<Node> visit = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        Node temp = null;
        
        q.offer(root);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.data == target) {
                temp = curr;
            }
            if (curr.left != null) {
                parent.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }

        int ans = -1;
        q.offer(temp);
        
        while (!q.isEmpty()) {
            int lvl = q.size();
            ans++;
            for (int i = 0; i < lvl; i++) {
                Node curr = q.poll();
                visit.add(curr);
                if (parent.containsKey(curr) && !visit.contains(parent.get(curr))) {
                    q.offer(parent.get(curr));
                }
                if (curr.left != null && !visit.contains(curr.left)) {
                    q.offer(curr.left);
                }
                if (curr.right != null && !visit.contains(curr.right)) {
                    q.offer(curr.right);
                }
            }
        }

        return ans;
    }


    // https://leetcode.com/problems/count-complete-tree-nodes/
    // O((logn)^2)
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        if (leftHeight == rightHeight) {
            // Full tree: 2^h - 1
            return (1 << leftHeight) - 1;
        } else {
            // Recurse
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }   

    int getLeftHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.left;
        }
        return h;
    }   

    int getRightHeight(TreeNode node) {
        int h = 0;
        while (node != null) {
            h++;
            node = node.right;
        }
        return h;
    }
}
