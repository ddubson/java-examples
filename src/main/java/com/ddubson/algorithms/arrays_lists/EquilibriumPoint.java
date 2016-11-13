package com.ddubson.algorithms.arrays_lists;

import java.util.Scanner;

/**
 * Author: ddubson
 */
public class EquilibriumPoint {
    /*
    Given an array A your task is to tell at which position the equilibrium first occurs in the array.
    Equilibrium position in an array is a position such that the sum of elements below it is equal to the sum of
    elements after it.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int sizeOfArray = scanner.nextInt();
            int[] arr = new int[sizeOfArray];

            int arraySum = 0;
            for (int j = 0; j < arr.length; j++) {
                int val = scanner.nextInt();
                arraySum += val;
                arr[j] = val;
            }

            if(arr.length == 1) {
                System.out.println("1");
            } else {
                int leftSum = 0;
                int rightSum = arraySum;
                int eqIndex = -1;

                for (int j = 0; j < arr.length; j++) {
                    // 2, 3, 4

                    // calculate rightsum
                    rightSum -= arr[j];

                    // compare left and right sums
                    // if equal, print j, if not equal, on to the next increment
                    if(leftSum==rightSum) {
                        eqIndex=j;
                        break;
                    }

                    leftSum += arr[j];
                }

                if(eqIndex==-1) {
                    System.out.println(eqIndex);
                } else {
                    System.out.println(eqIndex + 1);
                }
            }
        }
    }
}
