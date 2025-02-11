package DataStructures.LinkedList.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CLL list = new CLL();

        list.insertFirst(3);
        list.insertFirst(2);
        list.insertFirst(1);
        list.insertLast(4);
        list.insertLast(5);
        list.insertAtIndex(100, 2);

        System.out.println("List after insertions:");
        list.display();

        list.deleteFirst();
        list.deleteLast();
        list.deleteAtIndex(2);

        System.out.println("List after deletions:");
        list.display();

        System.out.println("Search 100: " + list.search(100));
        System.out.println("Search 4: " + list.search(4));

        System.out.println("Size of list: " + list.getSize());
    }
}
