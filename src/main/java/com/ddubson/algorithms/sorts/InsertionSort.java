package com.ddubson.algorithms.sorts;

/**
 * Author: ddubson
 */
public class InsertionSort {
    private static int[] insertionsort(int[] array) {
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

    public static void main(String... args) {
        int[] array = { 1, 5, 3, 2, 6};
        int[] sorted = insertionsort(array);

    }
}
