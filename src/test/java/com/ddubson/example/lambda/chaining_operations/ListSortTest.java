package com.ddubson.example.lambda.chaining_operations;

import com.ddubson.example.lambda.Sorting;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Author: ddubson
 */
public class ListSortTest {
    @Test
    public void listSort() throws Exception {
        List<String> unsorted = Arrays.asList("hello", "yes", "me");
        System.out.println(unsorted);
        System.out.println(Sorting.sortByLength(unsorted));
    }
}