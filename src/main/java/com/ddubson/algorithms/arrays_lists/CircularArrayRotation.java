package com.ddubson.algorithms.arrays_lists;

/**
 * Author: ddubson
 */
public class CircularArrayRotation {
    public static int[] rotate(int[] input, int k) {
        if(input.length < 2 || k < 1) return input;

        int[] combined = new int[input.length];
        System.arraycopy(input, input.length-k, combined, 0, k);
        System.arraycopy(input, 0, combined, k, input.length-k);

        return combined;
    }
}
