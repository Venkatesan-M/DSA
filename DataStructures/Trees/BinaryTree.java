package DataStructures.Trees;

import java.util.*;

class BinaryTree {

    public static class TreeNode {
        int val;
        TreeNode right, left;

        TreeNode(int val) {
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    private static TreeNode root;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter root value: ");
        int val = inp.nextInt();
        root = new TreeNode(val);
        populate(root, inp);
        
        System.out.println("\nLevel Order Traversal:");
        displaybfs(root);
        
        System.out.println("\nIndented Tree Structure:");
        display(root, "");

        System.out.println("\nRight View:");
        displayPretty(root, 0);
        
        inp.close();
    }

    static void populate(TreeNode node, Scanner scanner) {
        System.out.print("Do you want to add left child for node " + node.val + "? (1 for yes / 0 for no): ");
        int l = scanner.nextInt();
        if (l == 1) {
            System.out.print("Enter value of left child: ");
            int val = scanner.nextInt();
            node.left = new TreeNode(val);
            populate(node.left, scanner);
        }

        System.out.print("Do you want to add right child for node " + node.val + "? (1 for yes / 0 for no): ");
        int r = scanner.nextInt();
        if (r == 1) {
            System.out.print("Enter value of right child: ");
            int val = scanner.nextInt();
            node.right = new TreeNode(val);
            populate(node.right, scanner);
        }
    }

    static void display(TreeNode node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.val);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    static void displaybfs(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = q.poll();
                System.out.print(current.val + " ");
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
            System.out.println(); 
        }
    }

    static void displayPretty(TreeNode node, int lvl){
        if(node == null) return;
        displayPretty(node.right, lvl + 1);
        if(lvl != 0){
            for(int i = 0; i < lvl - 1; i++){
                System.out.print("|\t\t");
            }
            System.out.println("|----->" + node.val);
        } else{
            System.out.println(node.val);
        }
        displayPretty(node.left, lvl + 1);
    }
}
