package com.ddubson.algorithms.stacks_queues;

import java.util.Scanner;
import java.util.Stack;

/**
 * Author: ddubson
 */
public class QueueWithTwoStacks {
    static final int ENQUEUE = 1, DEQUEUE = 2, PRINT = 3;

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int command = scanner.nextInt();

            if (command == ENQUEUE) {
                int intToPush = scanner.nextInt();
                queue.enqueue(intToPush);
            } else if (command == DEQUEUE) {
                queue.dequeue();
            } else if (command == PRINT) {
                System.out.println(queue.peek());
            }
        }
    }

    public static class Queue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void enqueue(int i) {
            stack.push(i);
        }

        public int dequeue() {
            rebalance();
            return stack2.pop();
        }

        public int peek() {
            rebalance();
            return stack2.peek();
        }

        private void rebalance() {
            if(stack2.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
            }
        }
    }
}
