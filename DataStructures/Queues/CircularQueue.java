package DataStructures.Queues;

public class CircularQueue {
    int[] data;
    int front;
    int end;
    int size;

    CircularQueue(int size) {
        this.data = new int[size];
        this.front = 0;
        this.end = 0;
        this.size = 0;
    }

    boolean isFull() {
        return size == data.length;
    }

    boolean isEmpty() {
        return size == 0;
    }

    boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return false;
        }
        data[end] = value;
        end = (end + 1) % data.length;
        size++;
        return true;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int removed = data[front];
        front = (front + 1) % data.length;
        size--;
        return removed;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return data[front];
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[(front + i) % data.length] + " ");
        }
        System.out.println();
    }
}
