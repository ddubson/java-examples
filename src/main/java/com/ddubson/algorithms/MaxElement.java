package com.ddubson.algorithms;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by ddubs on 10/19/2016.
 */
public class MaxElement {
    Scanner scanner;
    Stack<Long> stack;
    Stack<Long> maxStack;

    public MaxElement(Scanner scanner) {
        this.scanner = scanner;
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void run() {
        int queries = scanner.nextInt();
        for (int i = 0; i < queries; i++) {
            int cmd = scanner.nextInt();
            if(cmd == 1) {
                // push next el into stack
                push(scanner.nextLong());
            } else if(cmd == 2) {
                // delete element at top of stack
                deleteOffTop();
            } else if(cmd == 3) {
                // print max element in stack.
                printMaxElement();
            }
        }
    }

    private void push(long n) {
        if(maxStack.isEmpty() || maxStack.peek() <= n) {
            maxStack.push(n);
        }

        stack.push(n);
    }

    private void deleteOffTop() {
        long n = stack.pop();
        if(!maxStack.isEmpty() && maxStack.peek() == n) {
            maxStack.pop();
        }
    }

    private void printMaxElement() {
        System.out.println(maxStack.peek());
    }

    public static void main(String[] args) {
        new MaxElement(new Scanner(System.in)).run();
    }
}
