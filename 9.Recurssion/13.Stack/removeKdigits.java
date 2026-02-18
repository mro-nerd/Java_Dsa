/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer(without changing sequence/order of given number) after removing k digits from num .

Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0. */

import java.util.*;
public class removeKdigits {
    

    public static String removeKdigit(String num, int k) {
        if (num.length() == k)
            return "0";
        
        // get all eligible elements in a stack(min possible elements)
        Stack<Character> s = new Stack<>();
        for (char c : num.toCharArray()) {
            while (k > 0 && !s.isEmpty() && s.peek() > c) {
                s.pop();
                k--;
            }
            s.push(c);
        }
        
        // if still no change in k then remove k elements
        if (k > 0) {
            while (k-- > 0) {
                s.pop();
            }
        }
        
        // remove leading 0s, if present
        Stack<Character> t = new Stack<>();
        while (!s.isEmpty()) {
            t.push(s.pop());
        }
        while (!t.isEmpty() && t.peek() == '0') {
            t.pop();
        }
        
        // return the answer
        StringBuilder result = new StringBuilder();
        while (!t.isEmpty()) {
            result.append(t.pop());
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigit(num, k)); // Output: "1219"
    }
}


