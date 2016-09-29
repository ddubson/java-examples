package com.ddubson.algorithms;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReversePolishNotationEvaluator {
    private static final String OPERATORS = "+-*/";

    public int evaluate(String expression) {
        int value;
        StringTokenizer tokenizer = new StringTokenizer(expression, " ");
        Stack<String> stack = new Stack<>();

        while (tokenizer.hasMoreElements()) {
            String str = tokenizer.nextToken();
            if (isNotAnOperator(str)) {
                stack.push(str);
            } else {
                int a = getIntValue(stack);
                int b = getIntValue(stack);

                // Execute operation based on type of operator
                switch (str) {
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }

        return getIntValue(stack);
    }

    private Integer getIntValue(Stack<String> stack) {
        return Integer.valueOf(stack.pop());
    }

    private boolean isNotAnOperator(String str) {
        return !OPERATORS.contains(str);
    }
}
