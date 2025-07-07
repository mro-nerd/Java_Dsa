/*evaluate given postfix expression using stack */

import java.util.Stack;

public class postfixEval {
    private int evaluate(int a, int b, String op) {
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("*"))
            return a * b;

        return a / b;
    }

    public int eval(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = s.pop();
                int a = s.pop();
                s.push(evaluate(a, b, token));
            } else { // it's an operand
                s.push(Integer.parseInt(token));
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        postfixEval evaluator = new postfixEval();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};  // Example postfix expression
        int result = evaluator.eval(tokens);
        System.out.println("Result: " + result);
    }
}
