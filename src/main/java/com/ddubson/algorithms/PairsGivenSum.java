package com.ddubson.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddubson on 10/5/2016.
 */
public class PairsGivenSum {
    public static void main(String[] args) {
        // find pairs of numbers in sequence that add up to a given sum
        // sum = 10
        // seq = {1, 4, 6, 8, 10, 15, 22, 2}
        // constraints: unordered sequence

        int expectedSum = 10;
        int[] sequence = {1, 4, 6, 8, 10, 15, 22, 2};

        // brute force (run time: O(N*(N-1))
        for (int i = 0; i < sequence.length; i++) {
            for (int j = i+1; j < sequence.length; j++) {
                if(sequence[i] + sequence[j] == expectedSum) {
                    System.out.println(String.format("{%d, %d}", sequence[i], sequence[j]));
                }
            }
        }

        System.out.println();

        // optimized, given that numbers are unique
        // using a Map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            map.put(sequence[i], i);
        }

        for(int val : map.keySet()) {
            if(sequence[map.get(val)] == -1) continue;

            if(map.containsKey(expectedSum-val) && sequence[map.get(expectedSum-val)] != -1) {
                System.out.println(String.format("{%d, %d}", val, expectedSum-val));
                sequence[map.get(val)] = -1;
            }
        }
    }
}
