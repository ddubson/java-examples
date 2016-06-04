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
        // Reverse Polish Notation
        String expression = "2 1 + 3 *";
        System.out.println("Expression: " + expression);

        // Operators that can potentially exist in the expression
        String operators = "+-*/";
        int value;

        // Tokenize the string by spaces (" ")
        StringTokenizer tokenizer = new StringTokenizer(expression, " ");

        // Create new stack objet
        Stack<String> stack = new Stack<>();

        // Parse through each element
        while(tokenizer.hasMoreElements()) {
            String str = tokenizer.nextToken();
            if(!operators.contains(str)) {
                // If string is NOT an operator, push it to the stack
                stack.push(str);
            } else {
                // If string is an operator, pop the last two ints off the stack
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());

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

        // Get the final resultant value
        value = Integer.valueOf(stack.pop());

        System.out.println("Expression evaluated: " + value);
    }
}
