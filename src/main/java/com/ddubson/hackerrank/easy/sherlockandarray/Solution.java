package com.ddubson.hackerrank.easy.sherlockandarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ddubs on 2/11/2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named RansomNote. */
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(r.readLine());

        for(int i = 0; i < testCases; i++) {
            int arraySize = Integer.parseInt(r.readLine());
            int[] numbers = new int[arraySize];
            String[] stringArr = r.readLine().split(" ");
            for(int j = 0; j < arraySize; j++) {
                numbers[j] = Integer.parseInt(stringArr[j]);
            }

            boolean same = false;
            int sumTotal = IntStream.of(numbers).sum();
            int leftRollingSum = 0;
            int rightRollingSum = sumTotal;

            if(arraySize == 1) {
                same = true;
            }

            for(int j = 0; j < arraySize; j++) {
                if(j == 0 || j+1 == numbers.length) {
                    rightRollingSum -= numbers[j];
                    continue;
                }

                leftRollingSum += numbers[j-1];
                rightRollingSum -= numbers[j];

                if(leftRollingSum == rightRollingSum) {
                    same = true;
                }
            }

            if(same) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
