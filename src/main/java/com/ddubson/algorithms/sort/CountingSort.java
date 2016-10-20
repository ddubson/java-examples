package com.ddubson.algorithms.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: ddubson
 */
public class CountingSort {
    public static int[] countingSort(int[] arr) {
        if(arr.length == 0)
            return new int[0];

        int[] countArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        return countArr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] count = countingSort(arr);
        Arrays.stream(count).forEach(c -> System.out.print(c + " "));
    }
}
