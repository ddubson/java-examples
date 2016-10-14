package com.ddubson.algorithms.sort;

import org.junit.Test;

import static com.ddubson.algorithms.sort.CountingSort.countingSort;
import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class CountingSortTest {
   /* Given a list of integers, can you count and output the number of times each value appears?

    Hint: There is no need to sort the data, you just need to count it.


    INPUT: array of integers
    OUTPUT: array of integers that represent the count of each integer from 0 to N-1

    */

    @Test
    public void happyPath() throws Exception {
        int[] arr = {3, 2, 2, 3};
        int[] expectedCount = {0, 0, 2, 2};

        assertEquals(0, countingSort(arr)[0]);
        assertEquals(0, countingSort(arr)[1]);
        assertEquals(2, countingSort(arr)[2]);
        assertEquals(2, countingSort(arr)[3]);
    }

    @Test
    public void negPath() throws Exception {
        int[] arr = {};
        assertEquals(0, countingSort(arr).length);
    }

    @Test
    public void arrSize1() throws Exception {
        int[] arr = {0};
        assertEquals(1, countingSort(arr).length);
        assertEquals(1, countingSort(arr)[0]);
    }
}
