package DataStructures.LinkedList.DoublyLinkedList;

public class DLL {
    private Node head;
    private Node tail;
    private int size;

    DLL() {
        size = 0;
    }

    // Insert at the beginning
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;

        if (head != null) {
            head.prev = node;
        } else {
            tail = node; 
        }

        head = node;
        size++;
    }

    // Insert at the end
    public void insertLast(int val) {
        Node node = new Node(val);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }

    // Insert at a specific index
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
        node.prev = temp;

        if (temp.next != null) {
            temp.next.prev = node;
        }

        temp.next = node;
        size++;
    }

    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            return;
        }

        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null; // If the list becomes empty
        }
        size--;
    }

    // Delete last node
    public void deleteLast() {
        if (tail == null) {
            return;
        }

        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // If the list becomes empty
        }
        size--;
    }

    // Delete at a specific index
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
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    // Search for a value
    public boolean search(int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Reverse the list
    public void reverse() {
        Node current = head;
        Node prev = null;
        tail = head;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }

        if (prev != null) {
            head = prev.prev;
        }
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node node = head;
        System.out.print("null <--> ");
        while (node != null) {
            System.out.print(node.data + " <--> ");
            node = node.next;
        }
        System.out.println("null");
    }

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int val) {
            this.data = val;
        }
    }
}
