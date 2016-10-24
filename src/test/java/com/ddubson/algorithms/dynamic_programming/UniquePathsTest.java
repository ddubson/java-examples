package com.ddubson.algorithms.dynamic_programming;

import org.junit.Test;

import static com.ddubson.algorithms.dynamic_programming.UniquePaths.paths;
import static org.junit.Assert.*;

/**
 * Created by ddubs on 10/24/2016.
 */
public class UniquePathsTest {
    @Test
    public void uniquePathsTest() throws Exception {
        assertEquals(0, paths(0, 0));
        assertEquals(1, paths(1, 1));
        assertEquals(6, paths(3, 3));
        assertEquals(2, paths(2, 2));
    }
}