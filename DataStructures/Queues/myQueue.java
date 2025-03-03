package DataStructures.Queues;

import java.util.Arrays;

public class myQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int end;

    myQueue(){
        this(DEFAULT_SIZE);
    }

    myQueue(int size){
        this.data = new int[size];
        this.end = -1;
    }

    private boolean isFull(){
        return end == data.length - 1;
    }

    boolean isEmpty(){
        return end == -1;
    }

    boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[++end] = item;
        return true;
    }
    int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
        for(int i = 0; i < end; i++){
            data[i] = data[i+1];
        }
        data[end] = 0;
        end--;
        return removed;
    }

    void display(){
        System.out.println(Arrays.toString(data));
        return;
    }
}
