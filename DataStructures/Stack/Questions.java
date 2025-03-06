package DataStructures.Stack;

import java.util.Stack;

public class Questions {
    public static void main(String[] args) {
        // MyQueue queue = new MyQueue();
    }

    // Google - Implement Queue using two stacks
    // Easy
    // https://leetcode.com/problems/implement-queue-using-stacks/description/
    static class MyQueue {
        Stack<Integer> st;
        public MyQueue() {
            this.st = new Stack<>();
        }

        // // Insertion O(1) and deletion or peek takes O(N)
        // public void push(int x) {
        //     st.push(x);
        // }

        // public int pop() {
        //     Stack<Integer> temp = new Stack<>();
        //     while(!st.isEmpty()){
        //         temp.push(st.pop());
        //     }
        //     int popped = temp.pop();
        //     while(!temp.isEmpty()){
        //         st.push(temp.pop());
        //     }
        //     temp = null;
        //     System.gc();
        //     return popped;
        // }

        // public int peek() {
        //     Stack<Integer> temp = new Stack<>();
        //     while(!st.isEmpty()){
        //         temp.push(st.pop());
        //     }
        //     int peek = temp.peek();
        //     while(!temp.isEmpty()){
        //         st.push(temp.pop());
        //     }
        //     return peek;
        // }

        // Insertion O(N) but deletion or peek is O(1)
        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            while(!st.isEmpty()){
                temp.push(st.pop());
            }
            st.push(x);
            while(!temp.isEmpty()){
                st.push(temp.pop());
            }
        }

        public int pop() {
            return st.pop();
        }

        public int peek() {
            return st.peek();
        }

        public boolean empty() {
            return st.isEmpty();
        }
    }


    // Hard - Google
    // https://leetcode.com/problems/largest-rectangle-in-histogram/
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        st.push(max);

        for(int i = 1; i < heights.length; i++){
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                max = getMax(heights, st, max, i);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            max = getMax(heights, st, max, heights.length);
        }
        return max;
    }

    static int getMax(int[] arr, Stack<Integer> st, int max, int i){
        int area;
        int popped = st.pop();
        if(st.isEmpty()){
            area = arr[popped] * i;
        }else{
            area = arr[popped] * (i - 1 - st.peek());
        }
        return Math.max(max, area);
    }

    // // Brute Force
    // // Time Time Limit Exceeded
    // public int largestRectangleArea(int[] height) {
    //     int ans = height[0]; int n = height.length;
    //     for(int i = 0; i < n; i++){
    //         int left = i; int right = i;
    //         while(left >= 0 && height[left] >= height[i]){
    //             left--;
    //         }
    //         while(right < n && height[right] >= height[i]){
    //             right++;
    //         }
    //         ans = Math.max(ans, (right - left - 1) * height[i]);
    //     }
    //     return ans;
    // }


    // Easy
    // https://leetcode.com/problems/valid-parentheses/
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    return false;
                }
                char top = st.pop();
                if ((ch == ')' && top != '(') || 
                    (ch == ']' && top != '[') || 
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }


    // Medium
    // https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == ')'){
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
            else{
                st.push(ch);
           }      
        }
        return st.size();
    }

    // Medium
    // https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0;
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    // Valid "))" pair found
                    i++; 
                } else {
                    // Single ')' found, needs one more to form "))"
                    insertions++;
                }

                // Match this closing pair with an open '(' if available
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    // No matching '(', so we need an extra '(' before this "))"
                    insertions++;
                }
            }
            i++;
        }

        // Any remaining open '(' each requires two ')'
        insertions += stack.size() * 2;

        return insertions;
    }
}
