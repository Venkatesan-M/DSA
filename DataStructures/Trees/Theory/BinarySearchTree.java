package DataStructures.Trees.Theory;

import java.util.Arrays;
import java.util.Stack;

public class BinarySearchTree {
    private static class TreeNode {
        int val, height;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.height = 1;
        }
    }

    private static void printInorder(TreeNode node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.val + " ");
            printInorder(node.right);
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

    // https://leetcode.com/problems/search-in-a-binary-search-tree/description/
    public TreeNode searchBST(TreeNode root, int val) {
        // if(root == null) return root;
        // if(root.val > val) return searchBST(root.left, val);
        // if(root.val < val) return searchBST(root.right, val);
        // return root;
        while (root != null && root.val != val) {
            root = (root.val > val) ? root.left : root.right;
        }
        return root;
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

    // https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode curr = root;
        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new TreeNode(val);
                    break;
                }
                curr = curr.left;
            } else {
                if (curr.right == null) {
                    curr.right = new TreeNode(val);
                    break;
                }
                curr = curr.right;
            }
        }
        return root;
    }

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
    // Ceil(X) is a number that is either equal to X or is immediately greater than X.
    int findCeil(Node root, int key) {
        int ceil = -1;
        Node curr = root;
        while (curr != null) {
            if (key == curr.data) return key;
            if (curr.data > key) {
                ceil = curr.data;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ceil;
    }

    // https://www.geeksforgeeks.org/problems/floor-in-bst/1
    public static int floor(Node root, int x) {
        int floor = -1;
        Node curr = root;
        while (curr != null) {
            if (curr.data == x) return x;
            if (curr.data < x) {
                floor = curr.data;
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return floor;
    }

    // https://leetcode.com/problems/delete-node-in-a-bst/
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) return fix(root);
        TreeNode node = root;
        while (node != null) {
            if (node.val > key) {
                // child exist on left
                if (node.left != null && node.left.val == key) {
                    node.left = fix(node.left);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                // child exist on right
                if (node.right != null && node.right.val == key) {
                    node.right = fix(node.right);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }

    TreeNode fix(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;
        TreeNode leftSubtree = node.left;
        TreeNode rightSubtree = node.right;
        TreeNode rightMostNode = leftSubtree;
        while (rightMostNode.right != null) {
            rightMostNode = rightMostNode.right;
        }
        rightMostNode.right = rightSubtree;
        return leftSubtree;
    }

    // https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    static int res = 0;
    static int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderForKth(root);
        return res;
    }

    private void inorderForKth(TreeNode node) {
        if (node == null) return;

        inorderForKth(node.left);
        count--;
        if (count == 0) {
            res = node.val;
            return;
        }
        inorderForKth(node.right);
    }

    // https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    // https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return LCA(root, p.val, q.val);
    }

    TreeNode LCA(TreeNode node, int a, int b) {
        if (node == null) return null;
        if (a < node.val && b < node.val) return LCA(node.left, a, b);
        if (a > node.val && b > node.val) return LCA(node.right, a, b);
        return node;
    }

    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        if (n == 0) return null;
        TreeNode node = new TreeNode(preorder[0]);
        int cut = 1; // 0 is excluded
        while (cut < n) {
            if (preorder[cut] > node.val) break;
            cut++;
        }
        node.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, cut));
        node.right = bstFromPreorder(Arrays.copyOfRange(preorder, cut, n));
        return node;
    }

    // https://leetcode.com/problems/binary-search-tree-iterator/
    class BSTIterator {
        Stack<TreeNode> st;

        public BSTIterator(TreeNode root) {
            st = new Stack<>();
            pushAllLeftNodes(root);
        }

        void pushAllLeftNodes(TreeNode node) {
            if (node == null) return;
            st.push(node);
            pushAllLeftNodes(node.left);
        }

        public int next() {
            TreeNode topNode = st.pop();
            if (topNode.right != null) pushAllLeftNodes(topNode.right);
            return topNode.val;
        }

        public boolean hasNext() {
            return !st.isEmpty();
        }
    }

    // https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
    // Space Complexity is reduced to 2 X O(H), if inorder na it's O(N)
    // Time Complexity is O(N)
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        TreeNode left = root, right = root;

        // initialize leftStack for inorder (min)
        while (left != null) {
            leftStack.push(left);
            left = left.left;
        }

        // initialize rightStack for reverse inorder (max)
        while (right != null) {
            rightStack.push(right);
            right = right.right;
        }

        TreeNode low = getNext(leftStack, true);
        TreeNode high = getNext(rightStack, false);

        while (low != high) {
            int sum = low.val + high.val;
            if (sum == k) return true;
            else if (sum < k) low = getNext(leftStack, true);
            else high = getNext(rightStack, false);
        }

        return false;
    }

    // direction: true = inorder (left to right), false = reverse inorder
    private TreeNode getNext(Stack<TreeNode> stack, boolean direction) {
        TreeNode node = stack.pop();
        TreeNode next = direction ? node.right : node.left;
        while (next != null) {
            stack.push(next);
            next = direction ? next.left : next.right;
        }
        return node;
    }

    // https://leetcode.com/problems/recover-binary-search-tree/
    // Brute Force: to traverse inorder and store all sorted nodes
    //              find which ones is not sorted and swap
    //              Time -> O(N) Space -> O(N)
    //
    // Optimised : no need to store inorder, trace the prev nodes which violates
    //             the BST property in first and second node pointers and swap.
    //              Time -> O(N) Space -> O(1)

    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        checkViolation(root);
        // Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void checkViolation(TreeNode root) {
        if (root == null) return;

        checkViolation(root.left);

        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            // The first node (first) is always assigned as prev — the one that should be smaller but is too big.
            // The second node (second) is assigned as root — the one that is too small, i.e., violates the expected order after prev.
            second = root;
            // Because root is the one currently being visited, and it's the smaller value in the invalid pair (prev > root). 
            // We need to swap the larger value (prev) with the smaller one (root), so:
            // first = prev (wrong large value)
            // second = root (wrong small value)
        }

        prev = root;

        checkViolation(root.right);
    }

    // https://www.geeksforgeeks.org/problems/largest-bst/1
    private static class BSTInfo {
        int size;
        int max;
        int min;

        BSTInfo() {
            this.size = 0;
            this.max = Integer.MIN_VALUE;
            this.min = Integer.MAX_VALUE;
        }

        BSTInfo(int size, int min, int max) {
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    static int largestBst(Node root) {
        BSTInfo result = postOrderValidation(root);
        return result.size;
    }

    static BSTInfo postOrderValidation(Node node) {
        if (node == null) return new BSTInfo();

        BSTInfo leftSubtree = postOrderValidation(node.left);
        BSTInfo rightSubtree = postOrderValidation(node.right);

        // Check if the current subtree (rooted at 'node') can be a BST
        // This fails if:
        // 1. Left subtree's max is >= current node's data (violates BST left property)
        // 2. Right subtree's min is <= current node's data (violates BST right property)
        if (leftSubtree.max >= node.data || rightSubtree.min <= node.data) {
            // This subtree (rooted at 'node') is NOT a BST.
            // We need to return info that signals invalidity to the parent
            // AND propagates the largest BST size found among its children.
            int maxBstInSubtree = Math.max(leftSubtree.size, rightSubtree.size);
            // Return an "invalid" BSTInfo to its parent.
            // By setting min to Integer.MIN_VALUE and max to Integer.MAX_VALUE (or any range where min > max),
            // we ensure that any parent trying to include this subtree will fail its BST check.
            return new BSTInfo(maxBstInSubtree, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            int currentBstSize = 1 + leftSubtree.size + rightSubtree.size;
            int currentMin = Math.min(node.data, leftSubtree.min);
            int currentMax = Math.max(node.data, rightSubtree.max);

            return new BSTInfo(currentBstSize, currentMin, currentMax);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree Operations Demo ===\n");

        BinarySearchTree bst = new BinarySearchTree();

        // 1. Insert operations
        System.out.println("1. INSERT OPERATIONS:");
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        System.out.print("Inserting values: ");
        for (int val : values) {
            System.out.print(val + " ");
            bst.insert(val);
        }
        System.out.println();

        System.out.print("In-order Traversal (sorted): ");
        bst.inorderTraversal();
        System.out.println();

        // 2. Search operations
        System.out.println("2. SEARCH OPERATIONS:");
        int[] searchValues = {40, 90, 10, 100};
        for (int val : searchValues) {
            System.out.println("Search " + val + ": " + bst.search(val));
        }

        // Test searchBST method
        TreeNode found = bst.searchBST(bst.root, 40);
        System.out.println("SearchBST for 40: " + (found != null ? "Found node with value " + found.val : "Not found"));
        System.out.println();

        // 3. Insert into BST (LeetCode method)
        System.out.println("3. INSERT INTO BST (LeetCode):");
        TreeNode newRoot = bst.insertIntoBST(bst.root, 55);
        System.out.print("After inserting 55: ");
        bst.inorderTraversal();
        System.out.println();

        // 4. Balance check
        System.out.println("4. BALANCE CHECK:");
        System.out.println("Is tree balanced: " + bst.isBalanced());
        System.out.println();

        // 5. Ceil and Floor operations
        System.out.println("5. CEIL AND FLOOR OPERATIONS:");
        // Create a separate tree for Node operations
        Node rootNode = new Node(50);
        rootNode.left = new Node(30);
        rootNode.right = new Node(70);
        rootNode.left.left = new Node(20);
        rootNode.left.right = new Node(40);
        rootNode.right.left = new Node(60);
        rootNode.right.right = new Node(80);

        int[] ceilFloorTests = {25, 45, 65, 15, 85};
        for (int val : ceilFloorTests) {
            int ceil = bst.findCeil(rootNode, val);
            int floor = BinarySearchTree.floor(rootNode, val);
            System.out.println("Key: " + val + " | Ceil: " + (ceil == -1 ? "None" : ceil) +
                              " | Floor: " + (floor == -1 ? "None" : floor));
        }
        System.out.println();

        // 6. Kth Smallest Element
        System.out.println("6. KTH SMALLEST ELEMENT:");
        for (int k = 1; k <= 5; k++) {
            bst.res = 0; // Reset static variable
            int kthSmallest = bst.kthSmallest(bst.root, k);
            System.out.println(k + "th smallest element: " + kthSmallest);
        }
        System.out.println();

        // 7. Validate BST
        System.out.println("7. VALIDATE BST:");
        System.out.println("Is valid BST: " + bst.isValidBST(bst.root));
        System.out.println();

        // 8. Lowest Common Ancestor
        System.out.println("8. LOWEST COMMON ANCESTOR:");
        TreeNode node20 = new TreeNode(20);
        TreeNode node40 = new TreeNode(40);
        TreeNode node60 = new TreeNode(60);
        TreeNode node80 = new TreeNode(80);

        TreeNode lca1 = bst.lowestCommonAncestor(bst.root, node20, node40);
        TreeNode lca2 = bst.lowestCommonAncestor(bst.root, node60, node80);
        TreeNode lca3 = bst.lowestCommonAncestor(bst.root, node20, node80);

        System.out.println("LCA of 20 and 40: " + (lca1 != null ? lca1.val : "null"));
        System.out.println("LCA of 60 and 80: " + (lca2 != null ? lca2.val : "null"));
        System.out.println("LCA of 20 and 80: " + (lca3 != null ? lca3.val : "null"));
        System.out.println();

        // 9. Construct BST from Preorder
        System.out.println("9. CONSTRUCT BST FROM PREORDER:");
        int[] preorder = {8, 5, 1, 7, 10, 12};
        System.out.print("Preorder: ");
        for (int val : preorder) System.out.print(val + " ");
        System.out.println();

        TreeNode preorderRoot = bst.bstFromPreorder(preorder);
        System.out.print("Constructed BST inorder: ");
        printInorder(preorderRoot);
        System.out.println("\n");

        // 10. BST Iterator
        System.out.println("10. BST ITERATOR:");
        BSTIterator iterator = bst.new BSTIterator(bst.root);
        System.out.print("Iterator traversal: ");
        int count = 0;
        while (iterator.hasNext() && count < 8) { // Limit output
            System.out.print(iterator.next() + " ");
            count++;
        }
        System.out.println("...\n");

        // 11. Two Sum in BST
        System.out.println("11. TWO SUM IN BST:");
        int[] targets = {90, 110, 150, 200};
        for (int target : targets) {
            boolean f = bst.findTarget(bst.root, target);
            System.out.println("Target " + target + ": " + (f ? "Found pair" : "No pair found"));
        }
        System.out.println();

        // 12. Delete Node
        System.out.println("12. DELETE NODE:");
        System.out.print("Before deleting 30: ");
        bst.inorderTraversal();

        bst.root = bst.deleteNode(bst.root, 30);
        System.out.print("After deleting 30: ");
        bst.inorderTraversal();
        System.out.println();

        // 13. Recover BST (demonstration with manually corrupted tree)
        System.out.println("13. RECOVER BST:");
        TreeNode corruptedRoot = new TreeNode(1);
        corruptedRoot.left = new TreeNode(3);
        corruptedRoot.right = new TreeNode(2);

        System.out.print("Corrupted BST inorder: ");
        printInorder(corruptedRoot);
        System.out.println();

        // Create a new instance for recover tree to avoid static variable conflicts
        BinarySearchTree recoverBST = new BinarySearchTree();
        recoverBST.first = null;
        recoverBST.second = null;
        recoverBST.prev = null;
        recoverBST.recoverTree(corruptedRoot);
        System.out.print("Recovered BST inorder: ");
        printInorder(corruptedRoot);
        System.out.println("\n");

        // 14. Largest BST Subtree
        System.out.println("14. LARGEST BST SUBTREE:");
        // Create a mixed tree (some parts BST, some not)
        Node mixedRoot = new Node(50);
        mixedRoot.left = new Node(30);
        mixedRoot.right = new Node(60);
        mixedRoot.left.left = new Node(5);
        mixedRoot.left.right = new Node(20); // This makes left subtree invalid BST
        mixedRoot.right.left = new Node(45);
        mixedRoot.right.right = new Node(70);
        mixedRoot.right.left.left = new Node(40);
        mixedRoot.right.left.right = new Node(50);

        int largestBSTSize = BinarySearchTree.largestBst(mixedRoot);
        System.out.println("Size of largest BST subtree: " + largestBSTSize);

    }
}