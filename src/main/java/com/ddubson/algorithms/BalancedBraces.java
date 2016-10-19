package com.ddubson.algorithms;

import java.util.Stack;

/**
 * Created by ddubs on 10/19/2016.
 */
public class BalancedBraces {
    public static boolean isBalanced(String str) {
        if(str.length()==1) {
            return false;
        }

        String OPEN = "{[(";
        String CLOSED = "}])";

        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(OPEN.indexOf(c) != -1) {
                stack.push(c);
            }

            if(CLOSED.indexOf(c) != -1) {
                if(stack.isEmpty()) {
                    return false;
                }

                int index = CLOSED.indexOf(c);
                if(stack.peek() == OPEN.charAt(index)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
