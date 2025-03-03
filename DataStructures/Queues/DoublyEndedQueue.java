package DataStructures.Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoublyEndedQueue {
    public static void main(String[] args) {
        // Create a Deque of Strings
        Deque<String> d = new ArrayDeque<>();

        d.addFirst("1");
        d.addLast("2");

        String f = d.removeFirst();
        String l = d.removeLast();

        // Displaying the Deque
        System.out.println("First: " + f + ", Last: " + l);
    }
}
