/*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"] */

import java.util.*;

public class parenthesisPermutaions {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            list.add(str);
            return;
        }

        if (open < n)
            backtrack(list, str + "(", open + 1, close, n);
        if (close < open)
            backtrack(list, str + ")", open, close + 1, n);
    }

    public static void main(String[] args) {
        parenthesisPermutaions obj=new parenthesisPermutaions();

        int n = 3; // Try different values here
        List<String> result = obj.generateParenthesis(n);

        System.out.println("Well-formed parentheses combinations for n = " + n + ":");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
