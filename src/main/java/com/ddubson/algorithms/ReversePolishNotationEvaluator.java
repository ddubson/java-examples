package com.ddubson.algorithms;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ddubson on 6/2/2016.
 */
public class ReversePolishNotationEvaluator {
    public static void main(String... args) {
        evaluate();
    }

    public static void evaluate() {
        String expression = "2 1 + 3 *";
        System.out.println("Expression: " + expression);
        String operators = "+-*/";
        int value = -1;

        StringTokenizer tokenizer = new StringTokenizer(expression, " ");
        Stack<String> stack = new Stack<>();
        while(tokenizer.hasMoreElements()) {
            String str = tokenizer.nextToken();
            if(!operators.contains(str)) {
                stack.push(str);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

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
        value = Integer.valueOf(stack.pop());

        System.out.println("Expression evaluated: " + value);
    }
}
