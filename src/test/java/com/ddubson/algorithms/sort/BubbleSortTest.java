package com.ddubson.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class BubbleSortTest {
    @Test
    public void bubbleSortTest() throws Exception {
        int[] array = new int[] {4, 7, 2, 3, 8};
        int[] output = BubbleSort.sort(array);
        assertEquals(2, output[0]);
        assertEquals(3, output[1]);
        assertEquals(4, output[2]);
        assertEquals(7, output[3]);
        assertEquals(8, output[4]);
    }
}