package com.ddubson.algorithms.sort;

import java.util.Arrays;

/**
 * Author: ddubson
 */
public class BubbleSort {
    public static int[] sort(int[] input) {
        boolean swapped;
        int[] output = Arrays.copyOf(input, input.length);

        do {
            swapped=false;
            for (int i = 0; i < output.length-1; i++) {
                int x = output[i];
                int y = output[i+1];

                if (x > y) {
                    int temp = output[i+1];
                    output[i+1] = output[i];
                    output[i] = temp;
                    swapped=true;
                }
            }
        } while(swapped);

        return output;
    }
}
