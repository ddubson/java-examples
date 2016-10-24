package com.ddubson.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: ddubson
 */
public class FibonacciSequence {
    public static void main(String[] args) {
        // Recursive solution (O(1.618^n))
        System.out.println(fib(5));
        System.out.println(fib(10));

        // Iterative solution (O(N))
        System.out.println(ifib(5));
        System.out.println(ifib(10));

        // Recursive with Memoization (Memoized DP Algorithm)
        System.out.println(mfib(5));
        System.out.println(mfib(10));

        // Iterative with Memoization (Bottom Up DP Algorithm)
        System.out.println(imfib(5));
        System.out.println(imfib(10));
    }

    private static Map<Integer, Long> memo = new HashMap<>();

    private static long imfib(int i) {
        long[] fib = new long[i+1];
        for (int j = 1; j < fib.length; j++) {
            if (j <= 2)
                fib[j] = 1;
            else {
                fib[j] = fib[j-1]+fib[j-2];
            }
        }
        return fib[i];
    }


    private static long mfib(int i) {
        if(i <= 2) {
            return 1;
        }

        if(memo.containsKey(i)) {
            return memo.get(i);
        }

        long sum = mfib(i-1) + mfib(i-2);
        memo.put(i, sum);
        return sum;
    }

    public static long fib(long i) {
        return i <= 2 ? 1 : fib(i-1)+fib(i-2);
    }

    public static long ifib(long fibNumber) {
        int firstFib = 1;
        int secondFib = 1;
        int counter = 3;
        int sum = 0;
        while(counter <= fibNumber) {
            sum = firstFib + secondFib;
            firstFib = secondFib;
            secondFib = sum;
            counter++;
        }

        return sum;
    }
}
