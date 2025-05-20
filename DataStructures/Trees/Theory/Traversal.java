package DataStructures.Trees.Theory;

import java.util.*;

public class Traversal {

    private static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Recursive DFS traversals
    static void preOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    // Breadth-First Search (Level-order)
    static void bfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    // Iterative Depth-First Search (Pre-order)
    static void dfs(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            // Push right first so that left is processed first
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \   \
          4   5   6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.print("Pre-order: ");
        preOrder(root);
        System.out.println();

        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();

        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();

        System.out.print("BFS (Level-order): ");
        bfs(root);
        System.out.println();

        System.out.print("DFS (Iterative Pre-order): ");
        dfs(root);
        System.out.println();
    }
}
