package com.ddubson.algorithms;

/**
 * Author: ddubson
 */
public class ShiftArray {
    //WIP
    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 5};

        int[] shifted = shiftArray(arr, 2);
        for (int aShifted : shifted) {
            System.out.print(aShifted + " ");
        }
    }

    private static int[] shiftArray(int[] arr, int shiftTimes) {
        // create interm array for number of times to shift
        int[] im = new int[shiftTimes];
        int start = arr.length - shiftTimes;
        for (int i = start, j = 0; i < arr.length; i++, j++) {
            im[j] = arr[i];
        }

        int[] newArr = new int[arr.length];
        for (int i = 0; i < im.length; i++) {
            newArr[i] = im[i];
        }

        for (int i = im.length; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return arr;
    }
}
