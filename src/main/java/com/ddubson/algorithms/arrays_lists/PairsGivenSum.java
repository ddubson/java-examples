package com.ddubson.algorithms.arrays_lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ddubson on 10/5/2016.
 * https://leetcode.com/articles/two-sum/
 */
public class PairsGivenSum {
    public static int[] pairsGivenSum1(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return new int[]{arr[i], arr[j]};
                }
            }
        }

        return null;
    }

    public static int[] pairsGivenSum2(int expectedSum, int[] sequence) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sequence.length; i++) {
            map.put(sequence[i], i);
        }

        for (int val : map.keySet()) {
            if (sequence[map.get(val)] == -1) continue;

            if (map.containsKey(expectedSum - val) && sequence[map.get(expectedSum - val)] != -1) {
                return new int[] { map.get(val), map.get(expectedSum - val) };
                //sequence[map.get(val)] = -1;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // find pairs of numbers in sequence that add up to a given sum
        // sum = 10
        // seq = {1, 4, 6, 8, 10, 15, 22, 2}
        // constraints: unordered sequence

        int expectedSum = 10;
        int[] sequence = {1, 4, 6, 8, 10, 15, 22, 2};

        // brute force (run time: O(N*(N-1))
        int[] ret = pairsGivenSum1(sequence, expectedSum);
        System.out.println(String.format("[%d, %d]", ret[0], ret[1]));

        System.out.println();

        // optimized, given that numbers are unique
        // using a Map
        ret = pairsGivenSum2(expectedSum, sequence);
        System.out.println(String.format("[%d, %d]", ret[0], ret[1]));
    }
}
