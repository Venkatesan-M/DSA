package DataStructures.LinkedList.SinglyLinkedList;

public class LinkedList {
    public static void main(String[] args) {
        Node head = new Node(0); 
        for (int i = 1; i < 10; i++) { 
            head.append(i);
        }
        head.insert(10, 10);
        head = head.remove(head, 10);
        head.printList(head);
        System.out.println(head.size(head));
        System.out.println(head.search(head, 5));
        head = head.reverse(head);
        head.printList(head);
        System.out.println(head.get(head, 3));
    }
}
