package DataStructures.Trees;
import java.util.LinkedList;
import java.util.Queue;

public class SegmentTree {
    private static class TreeNode{
        int val; int start; int end;
        TreeNode left; TreeNode right;

        TreeNode(int val, int l, int r){
            this.val = val; this.start = l; this.end = r;
        }
    }

    static TreeNode insert(int[] arr){
        // bottom up approach
        int n = arr.length;
        Queue<TreeNode> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            q.add(new TreeNode(arr[i], i, i));
        }
        while(q.size() > 1){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            TreeNode t3 = new TreeNode(t1.val + t2.val, t1.start, t2.end);
            t3.left = t1; t3.right = t2;
            q.add(t3);
        }
        return q.poll();

    }

    static void update(TreeNode node, int index, int val) {
        if (node == null || index < node.start || index > node.end) return;
    
        // Leaf node: directly update value
        if (node.start == node.end && node.start == index) {
            node.val = val;
            return;
        }
    
        // Recurse into the correct child
        update(node.left, index, val);
        update(node.right, index, val);
    
        // Update this node's value after children updated
        node.val = (node.left != null ? node.left.val : 0) + 
                   (node.right != null ? node.right.val : 0);
    }
    

    static int query(TreeNode node, int start, int end) {
        if (node == null || start > node.end || end < node.start) {
            // No overlap
            return 0;
        }
    
        if (start <= node.start && node.end <= end) {
            // Total overlap
            return node.val;
        }
    
        // Partial overlap — go deeper
        return query(node.left, start, end) + query(node.right, start, end);
    }
    

    static void display(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int lvl = q.size();
            for(int i = 0; i < lvl; i++){
                TreeNode temp = q.poll();
                System.out.print("(val: "+ temp.val +", ["+temp.start+", "+temp.end+"]), " );
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 8, 7, 6, -2, -8, 4, 9};

        TreeNode root = insert(arr);
        display(root);
        System.out.println(query(root, 4, 5));
        update(root, 0, 1);
        display(root);
    }
}
