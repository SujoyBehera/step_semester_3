package week12.class_problems;

public class PocketCalculator {

    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    /**
     * Converts an infix expression (single-digit operands, + - * / and round brackets)
     * into postfix (Reverse Polish Notation) using an array-based stack.
     *
     * Time Complexity (Conversion): O(n) where n is the length of the infix string
     * (each character is pushed and popped at most once).
     * Space Complexity (Conversion): O(n) for the operator stack and output StringBuilder.
     */
    public static String toPostfix(String infix) {
        if (infix == null || infix.isEmpty()) {
            return "";
        }

        char[] stack = new char[infix.length()];
        int top = -1;
        StringBuilder postfix = new StringBuilder(infix.length());

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            }
            if (Character.isDigit(c)) {
                postfix.append(c);
            } else if (c == '(') {
                stack[++top] = c;
            } else if (c == ')') {
                while (top >= 0 && stack[top] != '(') {
                    postfix.append(stack[top--]);
                }
                if (top >= 0 && stack[top] == '(') {
                    top--;
                }
            } else {
                while (top >= 0 && stack[top] != '(' && precedence(stack[top]) >= precedence(c)) {
                    postfix.append(stack[top--]);
                }
                stack[++top] = c;
            }
        }

        while (top >= 0) {
            if (stack[top] != '(') {
                postfix.append(stack[top]);
            }
            top--;
        }

        return postfix.toString();
    }

    /**
     * Evaluates a postfix expression with single-digit operands and integer arithmetic
     * using an array-based stack. Guards against division by zero.
     *
     * Time Complexity (Evaluation): O(n) where n is the length of the postfix expression.
     * Space Complexity (Evaluation): O(n) for the operand stack.
     */
    public static int evaluate(String postfix) {
        if (postfix == null || postfix.isEmpty()) {
            return 0;
        }

        int[] stack = new int[postfix.length()];
        int top = -1;

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                stack[++top] = c - '0';
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int right = stack[top--];
                int left = stack[top--];
                int result;
                switch (c) {
                    case '+':
                        result = left + right;
                        break;
                    case '-':
                        result = left - right;
                        break;
                    case '*':
                        result = left * right;
                        break;
                    case '/':
                        if (right == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        result = left / right;
                        break;
                    default:
                        result = 0;
                }
                stack[++top] = result;
            }
        }

        return top >= 0 ? stack[top] : 0;
    }

    public static String calculate(String infix) {
        String postfix = toPostfix(infix);
        int value = evaluate(postfix);
        return postfix + " = " + value;
    }
}
