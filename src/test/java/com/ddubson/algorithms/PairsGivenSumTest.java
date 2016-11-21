package com.ddubson.algorithms;

import org.junit.Test;

import static com.ddubson.algorithms.arrays_lists.PairsGivenSum.pairsGivenSum2;
import static org.junit.Assert.assertEquals;

/**
 * Created by ddubs on 10/27/2016.
 */
public class PairsGivenSumTest {
    @Test
    public void pairsTest() throws Exception {
        int[] arr = {2, 7, 11, 15};
        int target = 26;
        int[] ret = pairsGivenSum2(target, arr);
        assertEquals(2, ret[0]);
        assertEquals(3, ret[1]);
    }
}