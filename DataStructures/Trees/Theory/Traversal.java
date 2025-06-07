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

    private static class Pair {
        TreeNode node;
        int num;
    
        Pair(TreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    

    // Recursive DFS traversals
    static void preOrder(TreeNode node) {
        // Node, Left, Right
        if (node == null) return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    static void preOrderStack(TreeNode node) {
        // Node, Left, Right
        Stack<TreeNode> st = new Stack<>();
        st.push(node);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            System.out.print(curr.val + " ");
            // STACK-->LIFO, so left should be on top to resolve it first
            if(curr.right != null) st.push(curr.right);
            if(curr.left != null) st.push(curr.left);
        }
        return;
    }

    public static void MorrisPreOrder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;  // Create thread
                    System.out.print(curr.val + " ");
                    curr = curr.left;
                } else {
                    pre.right = null;  // Remove thread
                    curr = curr.right;
                }
            }
        }

    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }

    static void inOrderStack(TreeNode node){
        Stack<TreeNode> st = new Stack<>();
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()) break; // all nodes processed
                node = st.pop(); // poping the last node that was not null
                System.out.print(node.val + " ");
                node = node.right; // process the right part, then go left until left is complete in that subtree
            }
            return;
        }
    }

    public static void MorrisInOrder(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                System.out.print(curr.val + " ");
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;  // Create thread
                    curr = curr.left;
                } else {
                    pre.right = null;  // Remove thread
                    System.out.print(curr.val + " ");
                    curr = curr.right;
                }
            }
        }

    }

    static void postOrder(TreeNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }

    static void postOrderTwoStacks(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            // st2 hold the nodes in post order
            st2.push(curr);
            if(curr.left != null) st1.push(curr.left);
            if(curr.right != null) st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            System.out.print(st2.pop().val + " ");
        }
        return;
    }

    static void postOrderStack(TreeNode root) {
        if (root == null) return;
    
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisited = null;
    
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null || temp == lastVisited) {
                    temp = st.pop();
                    System.out.print(temp.val + " ");
                    lastVisited = temp;
                } else {
                    curr = temp;
                }
            }
        }
    }

    static void PreInPostOrder(TreeNode root) {
        if (root == null) return;
    
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Stack<Pair> st = new Stack<>();
    
        st.push(new Pair(root, 1));
    
        while (!st.isEmpty()) {
            Pair p = st.pop();
    
            if (p.num == 1) {
                // 1st time visiting the node, so add node in pre order and go left
                preOrder.add(p.node.val);
                p.num++;
                st.push(p);  // Push back with incremented stage
                if (p.node.left != null) {
                    st.push(new Pair(p.node.left, 1));
                }
            } else if (p.num == 2) {
                // 2nd time visiting the node, so add node in in order and go right
                inOrder.add(p.node.val);
                p.num++;
                st.push(p);  // Push back with incremented stage
                if (p.node.right != null) {
                    st.push(new Pair(p.node.right, 1));
                }
            } else {
                // 3rd time visiting the node, so add node in post order and don't push again
                postOrder.add(p.node.val);
            }
        }
    
        // Print results
        System.out.print("Pre-order (1-pass): ");
        for (int val : preOrder) System.out.print(val + " ");
        System.out.println();
    
        System.out.print("In-order (1-pass): ");
        for (int val : inOrder) System.out.print(val + " ");
        System.out.println();
    
        System.out.print("Post-order (1-pass): ");
        for (int val : postOrder) System.out.print(val + " ");
        System.out.println();
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

        System.out.print("Pre-order (Iterative): ");
        preOrderStack(root);
        System.out.println();

        System.out.print("Pre-order Morris Traversal: ");
        MorrisPreOrder(root);
        System.out.println();

        System.out.print("In-order: ");
        inOrder(root);
        System.out.println();

        System.out.print("In-order (Iterative): ");
        inOrderStack(root);
        System.out.println();

        System.out.print("In-order Morris Traversal: ");
        MorrisInOrder(root);
        System.out.println();

        System.out.print("Post-order: ");
        postOrder(root);
        System.out.println();

        System.out.print("Post-order (Iterative): ");
        postOrderTwoStacks(root);
        System.out.println();

        System.out.print("Post-order (two stacks): ");
        postOrderTwoStacks(root);
        System.out.println();

        PreInPostOrder(root);

        System.out.print("BFS (Level-order): ");
        bfs(root);
        System.out.println();

        System.out.print("DFS (Iterative Pre-order): ");
        dfs(root);
        System.out.println();
    }
}
