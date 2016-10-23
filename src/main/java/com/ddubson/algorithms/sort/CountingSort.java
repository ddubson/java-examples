package com.ddubson.algorithms.sort;

import java.util.Scanner;

/**
 * Author: ddubson
 * https://www.cs.usfca.edu/~galles/visualization/CountingSort.html
 */
public class CountingSort {
    public static void countingSort(int[] arr, String[] str) {
        if (assumeNonEmpty(arr)) return;

        // Get histogram of counts
        int[] countArr = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i]]++;
        }

        // Get starting positions
        for (int i = 1; i < arr.length; i++) {
            countArr[i] += countArr[i-1];
        }

        String[] outStr = new String[arr.length];
        int[] ogIndex = new int[arr.length];
        for (int i = outStr.length-1; i > -1; i--) {
            outStr[countArr[arr[i]]-1] = str[i];
            ogIndex[countArr[arr[i]]-1] = i;
            countArr[arr[i]]--;
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(ogIndex[i] < arr.length/2) {
                s.append("- ");
            } else {
                s.append(outStr[i]).append(" ");
            }
        }
        System.out.println(s.toString());
    }

    private static boolean assumeNonEmpty(int[] arr) {
        if (arr.length == 0) {
            System.out.println("");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        String[] str = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            str[i] = scanner.next();
        }

        countingSort(arr, str);
    }
}
