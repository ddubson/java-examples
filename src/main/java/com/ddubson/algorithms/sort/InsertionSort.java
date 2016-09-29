package com.ddubson.algorithms.sort;

/**
 * Author: ddubson
 */
public class InsertionSort {
    public static int[] sort(int[] array) {
        for(int i = 1; i < array.length; i++){
            int j = i;
            while(j > 0 && array[j-1] > array[j]){
                int temp = array[j];
                array[j] = array[j-1];
                array[j-1] = temp;
                j--;
            }
        }
        return array;
    }
}
