package DataStructures.Stack;

import java.util.Stack;


public class StackDemo {
    public static void main(String[] args) throws Exception {
        // Generics can be passed to define the items that are going to be stored in the stack.
        Stack<Integer> st = new Stack<>();
        // Last In, First Out (LIFO) 
        st.push(1);
        st.push(2);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());

        myStack my = new myStack();
        my.push(10);
        my.push(20);
        while(!my.isEmpty()){
            System.out.println(my.pop());
        }
    }
}
