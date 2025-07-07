import java.util.ArrayList;
 class MyQueue {
        private ArrayList<Integer> arr;
        private int front;
    
        public MyQueue() {
            arr = new ArrayList<>();
            front = 0;
        }
    
        public void push(int x) {
            arr.add(x);
        }
    
        public int pop() {
            if (empty()) {
                throw new IllegalStateException("Queue is empty");
            }
            int frontElement = arr.get(front);
            front += 1;
            return frontElement;
        }
    
        public int peek() {
            if (empty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return arr.get(front);
        }
    
        public boolean empty() {
            return front == arr.size();
        }
    }
    
    public class Implementation {
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
    

