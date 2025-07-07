import java.util.*;

class MyStack {
    private ArrayList<Integer> arr;
    int len;

    public MyStack() {
        arr = new ArrayList<>();
        len = 0;
    }
    
    public void push(int x) {
        arr.add(x);
        len += 1;
    }
    
    public int pop() {
        if(len == 0)
            return -1;
        int ans = arr.get(len - 1);
        arr.remove(len - 1);
        len -= 1;
        return ans;
    }
    
    public int top() {
        if(len == 0)
            return -1;
        return arr.get(len - 1);
    }
    
    public boolean empty() {
        return len == 0;
    }

    public void clear() {
        while(!empty())
            pop();
    }
}

public class implementation {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(5);
        s.push(4);
        s.push(3);
        System.out.println(s.top());
    }
}