package DataStructures.LinkedList.SinglyLinkedList;

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
    void append(int val) {
        Node temp = new Node(val);
        Node traverse = this;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        traverse.next = temp;
    }

    void insert(int val, int index) {
        Node temp = new Node(val);
        if (index == 0) {
            temp.next = this.next;
            this.next = temp;
            return;
        }
        Node traverse = this;
        while (index > 1 && traverse.next != null) { 
            traverse = traverse.next;
            index--;
        }
        temp.next = traverse.next;
        traverse.next = temp;
    }

    Node remove(Node head, int val) {
        if (head == null) return null;

        if (head.data == val) {
            return head.next; 
        }

        Node traverse = head;
        while (traverse.next != null && traverse.next.data != val) {
            traverse = traverse.next;
        }

        if (traverse.next != null) {
            traverse.next = traverse.next.next;
        }

        return head; 
    }
    int size(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    boolean search(Node head, int val) {
        while (head != null) {
            if (head.data == val) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    int get(Node head, int index) {
        int count = 0;
        while (head != null) {
            if (count == index) {
                return head.data;
            }
            head = head.next;
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }
    
    boolean isEmpty(Node head) {
        return head == null;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev; // New head
    }
    

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" --> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}