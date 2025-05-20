package DataStructures.Trees.Theory;

public class AVLTree {
    private static class TreeNode{
        int val; int height;
        TreeNode left; TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    static TreeNode insert(TreeNode node, int val){
        if(node == null) return new TreeNode(val);

        if(val < node.val){
            node.left = insert(node.left, val);
        }
        if(val > node.val){
            node.right = insert(node.right, val);
        }
        int leftHeight = node.left != null ? node.left.height : 0;
        int rightHeight = node.right != null ? node.right.height : 0;
        node.height = Math.max(leftHeight, rightHeight) + 1;
        return rotate(node);
    }

    static TreeNode rotate(TreeNode node) {
        int balance = height(node.left) - height(node.right);
    
        if (balance > 1) {
            // Left heavy
            if (height(node.left.left) >= height(node.left.right)) {
                // Left-Left case
                return rightRotate(node);
            } else {
                // Left-Right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
    
        if (balance < -1) {
            // Right heavy
            if (height(node.right.right) >= height(node.right.left)) {
                // Right-Right case
                return leftRotate(node);
            } else {
                // Right-Left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }
    
        return node; // already balanced
    }
    


    static TreeNode leftRotate(TreeNode node){
        TreeNode p = node;
        TreeNode c = node.right;
        p.right = c.left;
        c.left = p;

        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    static TreeNode rightRotate(TreeNode node){
        TreeNode p = node; TreeNode c = node.left;
        p.left = c.right;
        c.right = p;
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        return c;
    }

    static boolean isBalanced(TreeNode node) {
        if (node == null) return true;
        int left = height(node.left);
        int right = height(node.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(node.left) && isBalanced(node.right);
    }
    
    private static int height(TreeNode node) {
        return node == null ? 0 : node.height;
    }    

    public static void main(String[] args) {
        TreeNode root = null;
    
        // int[] values = {30, 20, 40, 10, 25, 50, 5}; // Inserting in this order forces rotations
    
        // for (int val : values) {
        //     root = insert(root, val);
        //     System.out.println("Inserted: " + val + " | Is Balanced: " + isBalanced(root));
        // }
    

        for (int val = 0; val < 1000; val++) {
            root = insert(root, val);
            System.out.println("Inserted: " + val + " | Is Balanced: " + isBalanced(root));
        }
        // Final check
        System.out.println("\nFinal Tree is balanced: " + isBalanced(root));
        System.out.println("Final Root: " + root.val);
        System.out.println("Height of root: " + root.height);
    }
    
}
