package DataStructures.Trees;

public class BinarySearchTree {
    private static class TreeNode {
        int val, height;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.height = 1;
        }
    }

    private TreeNode root;

    // Insert a value into the BST
    public void insert(int val) {
        root = insertRecursive(root, val);
    }

    private TreeNode insertRecursive(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (val < node.val) {
            node.left = insertRecursive(node.left, val);
        } else if (val > node.val) {
            node.right = insertRecursive(node.right, val);
        }

        int leftHeight = node.left != null ? node.left.height : 0;
        int rightHeight = node.right != null ? node.right.height : 0;
        node.height = Math.max(leftHeight, rightHeight) + 1;

        return node;
    }

    // Search for a value in the BST
    public boolean search(int val) {
        return searchRecursive(root, val);
    }

    private boolean searchRecursive(TreeNode node, int val) {
        if (node == null) {
            return false;
        }
        if (val == node.val) {
            return true;
        }
        return val < node.val ? searchRecursive(node.left, val) : searchRecursive(node.right, val);
    }

    // In-order traversal (sorted order)
    public void inorderTraversal() {
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(TreeNode node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.val + " ");
            inorderRecursive(node.right);
        }
    }

    // Check if the tree is balanced
    public boolean isBalanced() {
        return checkBalanced(root) != -1;
    }

    private int checkBalanced(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkBalanced(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalanced(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("In-order Traversal: ");
        bst.inorderTraversal();

        int searchValue = 40;
        System.out.println("Search " + searchValue + ": " + bst.search(searchValue));
        System.out.println("Is Balanced: " + bst.isBalanced());
    }
}
