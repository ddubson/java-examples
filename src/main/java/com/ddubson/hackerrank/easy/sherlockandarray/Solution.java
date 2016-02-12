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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
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
            for(int j = 0; j < arraySize; j++) {
                if(j == 0 || j+1 == numbers.length) {
                    continue;
                }

                int leftSum = IntStream.of(Arrays.copyOfRange(numbers, 0, j)).sum();
                int rightSum = IntStream.of(Arrays.copyOfRange(numbers, j+1, numbers.length)).sum();

                if(leftSum == rightSum && leftSum != 0) {
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
