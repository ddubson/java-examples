package com.ddubson.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ddubson on 9/29/2016.
 */
public class InsertionSortTest {
    @Test
    public void sort_shouldSortArraySuccessfully() throws Exception {
        int[] array = { 1, 5, 3, 2, 6};
        int[] sortedArray = {1, 2, 3, 5, 6};
        int[] sorted = InsertionSort.sort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            assertTrue(sorted[i]==sortedArray[i]);
        }
    }
}