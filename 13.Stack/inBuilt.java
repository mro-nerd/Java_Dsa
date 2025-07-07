import java.util.*;
public class inBuilt {

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();

        s.push(1); // [1]
        s.push(2); // [1, 2]
        s.push(3); // [1, 2, 3]

        System.out.println(s.size());
        System.out.println(s.peek());
        s.pop(); // [1, 2]
        System.out.println(s.peek());
        System.out.println(s.empty());
        s.pop(); // [1]
        s.pop(); // []
        System.out.println(s.empty());
    }
}

