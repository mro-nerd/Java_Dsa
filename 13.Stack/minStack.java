/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MiniStack class:

*MiniStack() initializes the stack object.
*void push(int val) pushes the element val onto the stack.
*void pop() removes the element on the top of the stack.
*int top() gets the top element of the stack.
*int getMin() retrieves the minimum element in the stack.
i.e all the stack's functionalities plus a getMin() function*/

import java.util.*;
 
 class MiniStack {
    Stack<Integer> actual;
    Stack<Integer> preMin;

    public MiniStack() {
        actual = new Stack<>();
        preMin = new Stack<>();
    }
    
    public void push(int val) {
        actual.push(val);
        if(!preMin.empty())
            preMin.push(Math.min(val, preMin.peek()));
        else
            preMin.push(val);
    }
    
    public void pop() {
        actual.pop();
        preMin.pop();
    }
    
    public int top() {
        return actual.peek();
    }
    
    public int getMin() {
        return preMin.peek();
    }
}

public class minStack {
    public static void main(String[] args) {
        MiniStack s = new MiniStack();
        s.push(5);
        s.push(2);
        s.push(3);
        s.push(1);
        s.push(6);
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.top());
        System.out.println(s.getMin());

    }
}
