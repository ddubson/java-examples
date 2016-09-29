package com.ddubson.algorithms.sort;

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
        printArray(sorted, 0, input.length - 1);
    }

    private static int[] quicksort(int[] input, int low, int high) {
        if(low < high) {
            int p = partition(input, low, high);
            quicksort(input, low, p - 1);
            printArray(input, low, p -1);
            quicksort(input, p + 1, high);
            printArray(input, p+1, high);
        }


        return input;
    }

    private static int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low;

        for (int j = low; j < high; j++) {
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

    private static void printArray(int ar[], int low, int high) {
        for (int i = low; i <= high; i++) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }
}

