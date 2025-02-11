package DataStructures.LinkedList.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DLL list = new DLL();
        
        // Insert elements
        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(4);
        list.insertLast(5);
        list.insertAtIndex(100, 2);

        System.out.println("List after insertions:");
        list.display();

        // Delete elements
        list.deleteFirst();
        list.deleteLast();
        list.deleteAtIndex(2);

        System.out.println("List after deletions:");
        list.display();

        // Search for an element
        System.out.println("Search 100: " + list.search(100));
        System.out.println("Search 4: " + list.search(4));

        // Reverse the list
        list.reverse();
        System.out.println("Reversed List:");
        list.display();

        // Get size
        System.out.println("Size of list: " + list.getSize());
    }
}
