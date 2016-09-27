package com.ddubson.algorithms.sorts;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ddubson on 9/27/2016.
 */
public class Quicksort {
    public static int[] readInputFromSysIn() {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[scanner.nextInt()];
        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }

        return input;
    }

    public static void main(String[] args) {
        int[] input = readInputFromSysIn();
        int[] sorted = quicksort(input, 0, input.length - 1);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }

    private static int[] quicksort(int[] input, int low, int high) {
        int[] output = Arrays.copyOf(input, input.length);
        if(low < high) {
            int p = partition(output, low, high);
            output = quicksort(output, low, p - 1);
            output = quicksort(output, p + 1, high);
        }

        return output;
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low;

        for (int j = low; j < high-1; j++) {
            if(input[j] <= pivot) {
                swap(input, i, j);
                i++;
            }
        }
        swap(input, high, i);

        return i;
    }

    private static void swap(int[] input, int i, int j) {
        int temp = input[j];
        input[j] = input[i];
        input[i] = temp;
    }
}

