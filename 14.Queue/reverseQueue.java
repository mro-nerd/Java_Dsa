import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class GfG {
    public Queue<Integer> rev(Queue<Integer> q) {
        Stack<Integer> st = new Stack<>();

        // Transfer elements from queue to stack
        while (!q.isEmpty()) {
            int element = q.poll();
            st.push(element);
        }

        // Transfer elements back from stack to queue
        while (!st.isEmpty()) {
            int top = st.pop();
            q.add(top);
        }

        return q;
    }
}

public class reverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        GfG gfg = new GfG();

        // Adding elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Original Queue: " + queue);

        // Reversing the queue
        Queue<Integer> reversedQueue = gfg.rev(queue);

        System.out.println("Reversed Queue: " + reversedQueue);
    }
}

