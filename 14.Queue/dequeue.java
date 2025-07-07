import java.util.LinkedList;

class MyQueue {
    LinkedList<Integer> ll;

    public MyQueue() {
        ll = new LinkedList<>();
    }

    public void push_back(int x) {
        ll.addLast(x);
    }

    public void push_front(int x) {
        ll.addFirst(x);
    }

    public int pop_back() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return ll.pollLast();
    }

    public int pop_front() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return ll.pollFirst();
    }

    public int peek_back() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return ll.getLast();
    }

    public int peek_front() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return ll.getFirst();
    }

    public boolean empty() {
        return ll.size() == 0;
    }
}

public class dequeue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        // Test cases
        queue.push_back(10);
        queue.push_back(20);
        queue.push_front(5);

        System.out.println("Peek Front: " + queue.peek_front()); 
        System.out.println("Peek Back: " + queue.peek_back());   

        System.out.println("Pop Front: " + queue.pop_front());   
        System.out.println("Pop Back: " + queue.pop_back());     

        System.out.println("Is Empty: " + queue.empty());       

        queue.pop_front();
        System.out.println("Is Empty: " + queue.empty());       
    }
}
