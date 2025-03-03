package DataStructures.Stack;

public class myStack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int top;

    myStack(){
        this(DEFAULT_SIZE);
    }

    myStack(int size){
        this.data = new int[size];
        this.top = -1;
    }

    private boolean isFull(){
        return top == data.length - 1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    void push(int i) throws Exception{
        if(isFull()){
            throw new Exception("Stack is full");
        }
        data[++top] = i; 
    }

    int pop() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return data[top--];
    }

    int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("Stack is Empty");
        }
        return data[top];
    }
}
