package DataStructures.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) throws Exception {
        // here Queue is not a class, but a interface, it can be implemented by linkedlist
        Queue<Integer> q = new LinkedList<>();
        // First-in-first-out (FIFO)
        q.add(1);
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.isEmpty());

        myQueue mq = new myQueue(10);
        mq.insert(0);
        mq.insert(1);
        mq.insert(3);
        mq.insert(4);
        mq.display();
        mq.remove();
        mq.display();

        CircularQueue cq = new CircularQueue(5);
        
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();

        cq.enqueue(60); // Should print "Queue is full!"

        System.out.println("Dequeued: " + cq.dequeue());
        System.out.println("Dequeued: " + cq.dequeue());

        cq.display();

        cq.enqueue(60);
        cq.enqueue(70);

        cq.display();

        System.out.println("Front element: " + cq.peek());
    }
}
