package DataStructures.LinkedList.CircularLinkedList;

public class CLL {
    private Node head;
    private Node tail;
    private int size;

    CLL() {
        size = 0;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
            node.next = head; // Circular link
        } else {
            node.next = head;
            tail.next = node;
            head = node;
        }
        size++;
    }

    public void insertLast(int val) {
        if (head == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void insertAtIndex(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size) {
            insertLast(val);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        if (head == tail) { // Single node case
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
        size--;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        }
        if (head == tail) { // Single node case
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
        size--;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public boolean search(int val) {
        if (head == null) {
            return false;
        }

        Node temp = head;
        do {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        } while (temp != head);

        return false;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        System.out.print("Head -> ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("Head");
    }

    private class Node {
        int data;
        Node next;

        Node(int val) {
            this.data = val;
        }
    }
}
