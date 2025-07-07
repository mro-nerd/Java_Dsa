/*Implement Queue using Stack */
import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1, s2;

    private void transfer() {
        while (s1.size() > 0) {
            s2.push(s1.peek());
            s1.pop();
        }
    }

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.size() == 0)
            transfer();
        if (s2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int frontElement = s2.peek();
        s2.pop();
        return frontElement;
    }

    public int peek() {
        if (s2.size() == 0)
            transfer();
        if (s2.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.size() == 0 && s2.size() == 0;
    }
}

public class queueUsingStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test cases
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println("Peek: " + queue.peek()); 
        System.out.println("Pop: " + queue.pop());  
        System.out.println("Pop: " + queue.pop());  

        queue.push(40);
        System.out.println("Peek: " + queue.peek()); 
        System.out.println("Pop: " + queue.pop());  
        System.out.println("Pop: " + queue.pop()); 

        System.out.println("Is Empty: " + queue.empty());
    }
}


