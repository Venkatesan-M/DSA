package DataStructures.LinkedList.DoublyLinkedList;

class LRUCache {

    // https://leetcode.com/problems/lru-cache/
    private class Node {
        int key;
        int val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = this.next = null;
        }
    }

    HashMap<Integer, Node> map;
    Node head, tail;
    int cap;

    void insert(Node node) {
        Node next = this.head.next;
        node.next = next;
        next.prev = node;
        node.prev = this.head;
        this.head.next = node;
    }

    void pop(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
        node.next = null;
        node.prev = null;
    }

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        pop(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            pop(node);
            node.val = value;
            insert(node);
        } else {
            if (map.size() >= cap) {
                Node del = tail.prev;
                if (del != head) {
                    map.remove(del.key);
                    pop(del);
                }
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            insert(newNode);
        }
    }
}