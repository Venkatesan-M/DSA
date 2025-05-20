package DataStructures.Trees.Questions.BFS;

public class Q116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    
        public Node() {}
        
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public Node connect(Node root) {
        if(root == null) return root;
        Node leftptr = root;
        while(leftptr.left != null){
            Node curr = leftptr;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftptr = leftptr.left;
        }
        return root;
    }
}
