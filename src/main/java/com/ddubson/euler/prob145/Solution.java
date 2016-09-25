package com.ddubson.euler.prob145;

import static java.lang.Integer.reverse;

/**
 * Author: ddubson
 */
public class Solution {
    public static void main(String[] args) {
        // sum ( n + reverse(n) ) = consists entirely of odd digits;
        int N = 100;

        for(int i = 1; i <= N; i++) {
            System.out.println(i + " | " + reverse(i));
            int sum = i + reverse(i);
            System.out.println(sum);
        }
    }
}
